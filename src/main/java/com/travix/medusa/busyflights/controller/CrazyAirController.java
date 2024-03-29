package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.service.CrazyAirFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/crazyAir")
public class CrazyAirController {

    @Autowired
    private CrazyAirFlightService crazyAirFlightService;

    public CrazyAirController(final CrazyAirFlightService crazyAirFlightService) {
        this.crazyAirFlightService = crazyAirFlightService;
    }

    @GetMapping(value = "/flights")
    public List<CrazyAirResponse> flights() {
        return crazyAirFlightService.getAllFlights();
    }

    @GetMapping("/flights/find")
    public List<CrazyAirResponse> findFlight(@RequestParam String origin,
                                             @RequestParam String destination,
                                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
                                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate,
                                             @RequestParam int passengerCount) {

        return this.crazyAirFlightService.findFlights(origin, destination, departureDate, returnDate, passengerCount);
    }

}
