package com.qldv.api.controller;

import com.qldv.api.model.Booking;
import com.qldv.api.service.Implement.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/bookings")
public class BookingController {
    private final BookingService _bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        _bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllTickets() {
        List<Booking> bookings = _bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        Booking booking = _bookingService.getBookingById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTicket(@RequestBody Booking booking) {
        Booking bookedTicket = _bookingService.bookTicket(booking);
        return new ResponseEntity<>(bookedTicket, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelTicket(@PathVariable Integer id) {
        _bookingService.cancelBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
