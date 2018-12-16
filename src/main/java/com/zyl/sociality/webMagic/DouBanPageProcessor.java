package com.zyl.sociality.webMagic;

import com.zyl.sociality.domain.PostInfo;
import com.zyl.sociality.utils.DateHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

@Component
public class DouBanPageProcessor implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
    @Override
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        Html html = page.getHtml();
        PostInfo info = new PostInfo();
        try {
            info.setTitle(html.xpath("//title/text()").toString());
            info.setContent(html.xpath("//div[@class='topic-richtext']").toString());
            info.setSourceUrl(html.getDocument().location());
            info.setSource("豆瓣");
            info.setPublishtime(DateHelper.strToDate(html.xpath("//span[@class='color-green']/text()").toString()));
            //page.putField("title", page.getHtml().xpath("//title/text()").toString());
        }
        catch(Exception e){
            page.setSkip(true);
        }
        if (info.getContent() == null) {
            //skip this page
            page.setSkip(true);
        }else {
            page.putField("info", info);
        }

        // 部分三：从页面发现后续的url地址来抓取

        page.addTargetRequests(page.getHtml().links().regex("https://www.douban.com/group/topic/\\d+/").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Scheduled(cron = "0 0 2 * * ?")
    public void runSpider(){
        Spider.create(new DouBanPageProcessor())
                .addUrl("https://www.douban.com/group/sydb/discussion?start=0")
                .addPipeline(new PostInfoPipeline())
                //开启5个线程抓取
                .thread(4)
                //启动爬虫
                .run();
    }
}
