package com.qldv.api.Service;

import com.qldv.api.DTO.BookingRequest;
import com.qldv.api.DTO.BookingResponse;
import com.qldv.api.Model.Booking;

import java.util.List;

public interface IBookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Integer id);
    BookingResponse bookTicket(BookingRequest request);
    void cancelBooking(Integer id);
}
