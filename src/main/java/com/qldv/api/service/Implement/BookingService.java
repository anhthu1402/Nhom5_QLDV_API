package com.qldv.api.service.Implement;

import com.qldv.api.model.Booking;
import com.qldv.api.model.Review;
import com.qldv.api.repository.BookingRepository;
import com.qldv.api.service.IBookingService;
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
