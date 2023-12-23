package com.qldv.api.Service.Implement;

import com.qldv.api.DTO.BookingDetailRequest;
import com.qldv.api.DTO.BookingRequest;
import com.qldv.api.DTO.BookingResponse;
import com.qldv.api.DTO.UpdateStatusBooking;
import com.qldv.api.Exception.CustomValidationException;
import com.qldv.api.Model.Booking;
import com.qldv.api.Model.BookingDetails;
import com.qldv.api.Model.Ticket;
import com.qldv.api.Repository.BookingDetailsRepository;
import com.qldv.api.Repository.BookingRepository;
import com.qldv.api.Repository.TicketRepository;
import com.qldv.api.Service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class BookingService implements IBookingService {
    private final BookingRepository _bookingRepository;
    private final BookingDetailsRepository _bookingDetailRepository;
    private final TicketRepository _ticketRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository,
                          BookingDetailsRepository bookingDetailsRepository,
                          TicketRepository ticketRepository) {

        _bookingRepository = bookingRepository;
        _bookingDetailRepository = bookingDetailsRepository;
        _ticketRepository = ticketRepository;
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

    public BookingResponse bookTicket(BookingRequest request) {
        Booking savedBooking = new Booking();
        String dateString = request.getTouringDate(); // Sample date string
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(dateString);
            savedBooking.setTouringDate(date);

        } catch (ParseException e) {
            System.out.println("ParseException occurred: " + e.getMessage());
        }


        LocalDateTime currentDatetime = LocalDateTime.now();
        Date date  = convertToDate(currentDatetime);
        savedBooking.setBookingDate(date);
        savedBooking.setQuantity(request.getQuantity());
        savedBooking.setTotalPrice(request.getTotalPrice());

        List<BookingDetailRequest> detailRequests = request.getBookingDetails();
        List<BookingDetails> details = new ArrayList<BookingDetails>();
        for (int i = 0; i < detailRequests.size(); i++) {
            BookingDetails obj = mapToBookingDetail(detailRequests.get(i));
            details.add(obj);
            // Perform operations on obj as needed
        }
        savedBooking.setBookingDetails(details);
        _bookingRepository.save(savedBooking);
        if (savedBooking.getBookingDetails() != null && !savedBooking.getBookingDetails().isEmpty()) {
            for (BookingDetails bookingDetail : savedBooking.getBookingDetails()) {
                bookingDetail.setBooking(savedBooking);
                _bookingDetailRepository.save(bookingDetail);
            }

        }
        return mapToBookingResponse(request);


    }
    private static Date convertToDate(LocalDateTime localDateTime) {
        // Convert LocalDateTime to Instant (UTC)
        // Then convert Instant to Date
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public void cancelBooking(Integer id) {
        _bookingRepository.deleteById(id);
    }
    private BookingDetails mapToBookingDetail(BookingDetailRequest input) {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setTotalPrice(input.getTotalPrice());
        bookingDetails.setQuantity(input.getQuantity());
        Ticket foundedTicket = _ticketRepository.findById(input.getTicketId()).orElse(null);
        if(foundedTicket == null){
            throw new CustomValidationException("Booking not found with ID: " + input.getTicketId());
        }
        bookingDetails.setTicket(foundedTicket);
        return bookingDetails;
    }
    public Booking updateBookingStatus(int id, UpdateStatusBooking updateStatus){
        Optional<Booking> booking = _bookingRepository.findById(id);
        if(booking.isPresent()) {
            Booking model = booking.get();
            model.setStatus(updateStatus.getStatus());
            _bookingRepository.save(model);
            return model;
        }
        throw new CustomValidationException("Booking is not found");
    }
    private BookingResponse mapToBookingResponse(BookingRequest request){
        LocalDateTime currentDatetime = LocalDateTime.now();
        Date date  = convertToDate(currentDatetime);
        BookingResponse response = new BookingResponse();
        response.setBookingDate(date);
        response.setTotalPrice(request.getTotalPrice());
        response.setQuantity(request.getQuantity());
        response.setTouringDate(request.getTouringDate());

        response.setBookingDetails(request.getBookingDetails());
        return response;
    }
}
