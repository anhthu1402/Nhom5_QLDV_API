package com.qldv.api.Service.Implement;

import com.qldv.api.Model.Booking;
import com.qldv.api.Repository.BookingRepository;
import com.qldv.api.Service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingService implements IBookingService {
    private final BookingRepository _bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        _bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return _bookingRepository.findAll();
    }

    public Booking getBookingById(Integer id) {
        Optional<Booking> booking = _bookingRepository.findById(id);
        if(booking.isPresent()) {
            return booking.get();
        }
        return null;
    }

    public Booking bookTicket(Booking booking) {
        return _bookingRepository.save(booking);
    }

    public void cancelBooking(Integer id) {
        _bookingRepository.deleteById(id);
    }
}
