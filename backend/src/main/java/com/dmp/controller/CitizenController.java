package com.dmp.controller;

import com.dmp.model.Incident;
import com.dmp.model.SosRequest;
import com.dmp.repository.IncidentRepository;
import com.dmp.repository.SosRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Citizen Portal endpoints: emergency reporting, SOS, incident reporting, map/weather lookups.
 */
@RestController
@RequestMapping("/api/citizen")
@RequiredArgsConstructor
public class CitizenController {

    private final IncidentRepository incidentRepository;
    private final SosRequestRepository sosRequestRepository;

    @PostMapping("/incidents")
    public Incident reportIncident(@RequestBody Incident incident) {
        return incidentRepository.save(incident);
    }

    @GetMapping("/incidents")
    public List<Incident> listMyIncidents() {
        return incidentRepository.findAll();
    }

    @PostMapping("/sos")
    public SosRequest sendSos(@RequestBody SosRequest sosRequest) {
        return sosRequestRepository.save(sosRequest);
    }
}
