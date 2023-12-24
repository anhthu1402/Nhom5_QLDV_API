package com.qldv.api.Controller;


import com.qldv.api.DTO.*;
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
@RequestMapping(value = "/api/statistic")
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
    public ResponseEntity<OrderStatistic> getNumberTickets() {
        return new ResponseEntity<>(_statisticService.numberOrders(), HttpStatus.OK);
    }
    @GetMapping("/fastest-tickets")
    public ResponseEntity<FastestTicket> getFastestTickets() {
        return new ResponseEntity<>(_statisticService.getFastestTicket(), HttpStatus.OK);
    }
    @GetMapping("/revenue-months")
    public ResponseEntity<RevenueForMonth> getRevenueForMonths() {
        return new ResponseEntity<>(_statisticService.getRevenueByMonth(), HttpStatus.OK);
    }


}
