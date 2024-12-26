package com.demo.cathaydemo.vo;

import com.demo.cathaydemo.entity.Currency;

import java.util.Map;

public class CoindeskVo {

    private DeskTime time;
    private String disclaimer;
    private String chartName;
    private Map<String, Currency> bpi;

    public DeskTime getTime() {
        return time;
    }

    public void setTime(DeskTime time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public Map<String, Currency> getBpi() {
        return bpi;
    }

    public void setBpi(Map<String, Currency> bpi) {
        this.bpi = bpi;
    }

    @Override
    public String toString() {
        return "{" +
                "time=" + time +
                ", disclaimer='" + disclaimer + '\'' +
                ", chartName='" + chartName + '\'' +
                ", bpi=" + bpi +
                '}';
    }
}
