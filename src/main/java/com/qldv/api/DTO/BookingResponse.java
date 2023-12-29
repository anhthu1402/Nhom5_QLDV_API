package com.qldv.api.DTO;

import java.util.Date;
import java.util.List;

public class BookingResponse {
    private Date bookingDate;
    private String touringDate;
    private Integer quantity;
    private Long totalPrice;
    private Integer userId;
    private List<BookingDetailRequest> bookingDetails;
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTouringDate() {
        return touringDate;
    }

    public void setTouringDate(String touringDate) {
        this.touringDate = touringDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
    public List<BookingDetailRequest> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetailRequest> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
}
