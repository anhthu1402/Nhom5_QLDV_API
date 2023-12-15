package com.qldv.api.Service.Implement;

import com.qldv.api.Model.BookingDetails;
import com.qldv.api.Repository.BookingDetailsRepository;
import com.qldv.api.Service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingDetailService implements IBookingService {
    private final BookingDetailsRepository _bookingDetailRepository;

    @Autowired
    public BookingDetailService(BookingDetailsRepository bookingDetailRepository) {
        _bookingDetailRepository = bookingDetailRepository;
    }

    public List<BookingDetails> getAllBookings() {
        return _bookingDetailRepository.findAll();
    }

    public BookingDetails getTicketById(Integer id) {
        Optional<BookingDetails> bookingDetails = _bookingDetailRepository.findById(id);
        if(bookingDetails.isPresent()) {
            return bookingDetails.get();
        }
        return null;
    }

    public BookingDetails bookTicket(BookingDetails booking) {
        return _bookingDetailRepository.save(booking);
    }

    public void cancelTicket(Integer id) {
        _bookingDetailRepository.deleteById(id);
    }
}
