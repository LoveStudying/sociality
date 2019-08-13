package com.zyl.sociality.enums;

import lombok.Getter;

/**
 * @author zhuyanlin
 * @date 2019/8/12 16:31
 */
@Getter
public enum BuildPriceEnum {
    B1("恒大雅苑", "https://sy.lianjia.com/xiaoqu/3115388196767878/"),
    B2("碧桂园学府壹号", "https://sy.lianjia.com/xiaoqu/3115347486329454/"),
    B3("融创唐轩公馆", "https://sy.lianjia.com/xiaoqu/3117794521926039/"),
    B4("万科金域华府", "https://sy.lianjia.com/xiaoqu/3115342600752343/"),
    B5("郡源悦城", "https://sy.lianjia.com/xiaoqu/3115842683924942/"),
    B6("旭辉御府", "https://sy.lianjia.com/xiaoqu/3115365386546642/"),
    B7("华茂中心", "https://sy.lianjia.com/xiaoqu/3115824966158953/"),
    B8("保利紫荆公馆", "https://sy.lianjia.com/xiaoqu/3115502611090625/"),
    B9("中海康城橙郡","https://sy.lianjia.com/xiaoqu/3116867952724689/"),
    B10("恒大名都三期","https://sy.lianjia.com/xiaoqu/3120032894566488/"),
    B11("碧桂园公园里","https://sy.lianjia.com/xiaoqu/3117887322713220/")
    ;

    private String buildName;
    private String buildUrl;

    BuildPriceEnum(String buildName, String buildUrl) {
        this.buildName = buildName;
        this.buildUrl = buildUrl;
    }
}
