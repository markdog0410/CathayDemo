package com.demo.cathaydemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private float rateFloat;

    // Getters and setters
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

    public float getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(float rateFloat) {
        this.rateFloat = rateFloat;
    }
}

