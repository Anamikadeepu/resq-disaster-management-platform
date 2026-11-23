package com.dmp.controller;

import com.dmp.model.Incident;
import com.dmp.model.RescueTeam;
import com.dmp.repository.IncidentRepository;
import com.dmp.repository.RescueTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Responder Portal endpoints: emergency requests queue, rescue team assignment/tracking.
 */
@RestController
@RequestMapping("/api/responder")
@RequiredArgsConstructor
public class ResponderController {

    private final IncidentRepository incidentRepository;
    private final RescueTeamRepository rescueTeamRepository;

    @GetMapping("/requests")
    public List<Incident> listEmergencyRequests() {
        return incidentRepository.findAll();
    }

    @PutMapping("/requests/{id}/assign/{teamId}")
    public Incident assignTeam(@PathVariable Long id, @PathVariable Long teamId) {
        Incident incident = incidentRepository.findById(id).orElseThrow();
        incident.setAssignedRescueTeamId(teamId);
        incident.setStatus(Incident.Status.ASSIGNED);
        return incidentRepository.save(incident);
    }

    @GetMapping("/teams")
    public List<RescueTeam> listTeams() {
        return rescueTeamRepository.findAll();
    }
}
