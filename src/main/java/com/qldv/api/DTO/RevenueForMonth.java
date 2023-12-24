package com.qldv.api.DTO;

import java.util.List;

public class RevenueForMonth {
    private List<String> months;
    private List<Integer> revenues;
    


    public void setMonths(List<String> months){
        this.months = months;
    }
    public void setRevenues(List<Integer> revenues){
        this.revenues = revenues;
    }
    public List<String> getMonths(){
        return  months;
    }
    public List<Integer> getRevenues(){
        return revenues;
    }
}
