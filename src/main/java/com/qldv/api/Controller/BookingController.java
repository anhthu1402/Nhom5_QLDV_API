package com.qldv.api.Controller;

import com.qldv.api.DTO.BookingRequest;
import com.qldv.api.DTO.BookingResponse;
import com.qldv.api.Model.Booking;
import com.qldv.api.Service.Implement.BookingService;
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
    public ResponseEntity<BookingResponse> bookTicket(@RequestBody BookingRequest request) {
        BookingResponse bookedTicket = _bookingService.bookTicket(request);
        return new ResponseEntity<>(bookedTicket, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelTicket(@PathVariable Integer id) {
        _bookingService.cancelBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
