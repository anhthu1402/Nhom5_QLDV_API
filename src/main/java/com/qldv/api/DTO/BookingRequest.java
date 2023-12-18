package com.qldv.api.DTO;

import com.qldv.api.Model.BookingDetails;

import java.util.Date;
import java.util.List;

public class BookingRequest {
    private Date bookingDate;
    private Date touringDate;
    private Integer quantity;
    private Long totalPrice;
    private List<BookingDetailRequest> bookingDetails;
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getTouringDate() {
        return touringDate;
    }

    public void setTouringDate(Date touringDate) {
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
}
