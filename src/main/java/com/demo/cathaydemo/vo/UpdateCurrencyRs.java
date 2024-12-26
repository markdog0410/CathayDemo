package com.demo.cathaydemo.vo;

import com.demo.cathaydemo.util.ResultBean;

public class UpdateCurrencyRs extends ResultBean {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    private double rateFloat;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(double rateFloat) {
        this.rateFloat = rateFloat;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rate='" + rate + '\'' +
                ", description='" + description + '\'' +
                ", rateFloat=" + rateFloat +
                '}';
    }
}
