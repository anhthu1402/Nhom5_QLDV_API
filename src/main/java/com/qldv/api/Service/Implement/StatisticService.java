package com.qldv.api.Service.Implement;

import com.qldv.api.DTO.BookingResponse;
import com.qldv.api.DTO.FastestTicket;
import com.qldv.api.Model.Booking;
import com.qldv.api.Model.BookingDetails;
import com.qldv.api.Model.Ticket;
import com.qldv.api.Model.User;
import com.qldv.api.Repository.BookingRepository;
import com.qldv.api.Repository.TicketRepository;
import com.qldv.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    private final UserRepository _userRepository;
    private final BookingRepository _bookingRepository;
    private final TicketRepository _ticketRepository;

    @Autowired
    public StatisticService(UserRepository userRepository,
                            BookingRepository bookingRepository,
                            TicketRepository ticketRepository){
        _userRepository = userRepository;
        _bookingRepository = bookingRepository;
        _ticketRepository = ticketRepository;
    }
    public int numberUsers(){
        List<User> users = _userRepository.findAll();
        return users.size();
    }
    public int numberOrders(){
        List<Booking> bookings = _bookingRepository.findAll();
        return bookings.size();
    }
    public FastestTicket getFastestTicket(){
        List<Booking> bookings = _bookingRepository.findAll();
        List<Ticket> ticketTypes = _ticketRepository.findAll();
        int maxCount = 0;
        String type = "";
        for(Ticket ticket : ticketTypes) {
            int count = 0;
            for(Booking booking : bookings){

                List<BookingDetails> bookingDetails = booking.getBookingDetails();
                for(BookingDetails bookingDetail : bookingDetails){
                    if(bookingDetail.getTicket().equals(ticket)){
                        count++;
                    }
                }
            }
            if(count > maxCount) {
                maxCount = count;
                type = ticket.getType();
            }

        }
        FastestTicket result  = new FastestTicket();
        result.setQuantity(maxCount);
        result.setType(type);
        return result;
    }

}
