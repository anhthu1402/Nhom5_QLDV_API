package com.qldv.api.DTO;

import java.util.List;

public class RevenueForMonth {
    private List<String> months;
    private List<Long> revenues;
    
    public RevenueForMonth(List<String> months, List<Long> revenues) {
    	this.months = months;
    	this.revenues = revenues;
    	
	}
    public void setMonths(List<String> months){
        this.months = months;
    }
    public void setRevenues(List<Long> revenues){
        this.revenues = revenues;
    }
    public List<String> getMonths(){
        return  months;
    }
    public List<Long> getRevenues(){
        return revenues;
    }
}
