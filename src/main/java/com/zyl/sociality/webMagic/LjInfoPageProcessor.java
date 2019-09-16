package com.zyl.sociality.webMagic;

import com.zyl.sociality.domain.BuildInfo;
import com.zyl.sociality.common.BuildPriceEnum;
import com.zyl.sociality.utils.DateHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * @author zhuyanlin
 * @date 2019/8/12 14:07
 */
@Component
public class LjInfoPageProcessor implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
    @Override
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        Html html = page.getHtml();
        BuildInfo info = new BuildInfo();
        try {
            info.setBuildName(html.xpath("//h1/text()").toString());
            info.setBuildPrice(html.xpath("//span[@class='xiaoquUnitPrice']/text()").toString());
            info.setInfoDate(DateHelper.getNowTime());
        }
        catch(Exception e){
            page.setSkip(true);
        }
        page.putField("info", info);
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Scheduled(cron = "0 0 8 15 * ?")//每月15日8点执行
    public void runSpider() throws InterruptedException {
        for(BuildPriceEnum buildPriceEnum: BuildPriceEnum.values())
        {
            Spider.create(new LjInfoPageProcessor())
                    .addUrl(buildPriceEnum.getBuildUrl())
                    .addPipeline(new BuidInfoPipeline())
                    .thread(1)
                    //启动爬虫
                    .run();
            //轮训查询中间停顿3秒
            Thread.sleep(3000);
        }
    }
}
