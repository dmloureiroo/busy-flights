package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.dto.ToughJetFlightDTO;
import com.travix.medusa.busyflights.service.ToughJetFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/toughJet")
public class ToughJetController {

    @Autowired
    private ToughJetFlightService toughJetFlightService;

    public ToughJetController(final ToughJetFlightService toughJetFlightService) {
        this.toughJetFlightService = toughJetFlightService;
    }

    @GetMapping(value = "/flights")
    public Page<ToughJetFlightDTO> toughJetFlights(Pageable pageable) {
        return toughJetFlightService.getAllToughJetFlights(pageable);
    }

    @GetMapping(value = "/flight/search")
    public List<ToughJetResponse> toughJetFlightSearch(@RequestBody final ToughJetRequest toughJetRequest) {
        return toughJetFlightService.searchToughJetFlights(toughJetRequest);
    }
}
