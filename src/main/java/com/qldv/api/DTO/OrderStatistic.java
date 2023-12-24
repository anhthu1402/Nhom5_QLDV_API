package com.qldv.api.DTO;

public class OrderStatistic {
    private int totalOrders;
    private int revenues;
    public int getTotalOrders(){
        return totalOrders;
    }
    public int getRevenues(){
        return revenues;
    }
    public void setTotalOrders(int totalOrders){
        this.totalOrders = totalOrders;

    }
    public void setRevenues(int revenues){
        this.revenues = revenues;
    }
}
