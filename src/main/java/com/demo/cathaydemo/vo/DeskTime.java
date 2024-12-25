package com.demo.cathaydemo.vo;


public class DeskTime {
    private String updated;
    private String updatedISO;
    private String updateduk;

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdatedISO() {
        return updatedISO;
    }

    public void setUpdatedISO(String updatedISO) {
        this.updatedISO = updatedISO;
    }

    public String getUpdateduk() {
        return updateduk;
    }

    public void setUpdateduk(String updateduk) {
        this.updateduk = updateduk;
    }

    @Override
    public String toString() {
        return "{" +
                "updated='" + updated + '\'' +
                ", updatedISO='" + updatedISO + '\'' +
                ", updateduk='" + updateduk + '\'' +
                '}';
    }
}
