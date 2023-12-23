package com.qldv.api.DTO;

import com.qldv.api.Model.BookingDetails;

import java.util.Date;
import java.util.List;

public class BookingRequest {
    //private Date bookingDate;
    private String touringDate;
    private int quantity;
    private long totalPrice;
    private List<BookingDetailRequest> bookingDetails;
//    public Date getBookingDate() {
//        return bookingDate;
//    }

//    public void setBookingDate(Date bookingDate) {
//        this.bookingDate = bookingDate;
//    }

    public String getTouringDate() {
        return touringDate;
    }

    public void setTouringDate(String touringDate) {
        this.touringDate = touringDate;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
    public List<BookingDetailRequest> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetailRequest> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
}
