package com.qldv.api.Controller;


import com.qldv.api.DTO.BookingRequest;
import com.qldv.api.DTO.BookingResponse;
import com.qldv.api.DTO.FastestTicket;
import com.qldv.api.Model.Booking;
import com.qldv.api.Service.Implement.BookingService;
import com.qldv.api.Service.Implement.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/statictis")
public class StatictisController {
    private final StatisticService _statisticService;

    @Autowired
    public StatictisController(StatisticService statisticService) {
        _statisticService = statisticService;
    }
    @GetMapping("/users")
    public ResponseEntity<Integer> getNumberUser() {
        return new ResponseEntity<>(_statisticService.numberUsers(), HttpStatus.OK);
    }
    @GetMapping("/orders")
    public ResponseEntity<Integer> getNumberTickets() {
        return new ResponseEntity<>(_statisticService.numberOrders(), HttpStatus.OK);
    }
    @GetMapping("/fastest-tickets")
    public ResponseEntity<FastestTicket> getFastestTickets() {
        return new ResponseEntity<>(_statisticService.getFastestTicket(), HttpStatus.OK);
    }


}