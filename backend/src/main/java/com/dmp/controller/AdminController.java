package com.dmp.controller;

import com.dmp.repository.IncidentRepository;
import com.dmp.repository.RescueTeamRepository;
import com.dmp.repository.ShelterRepository;
import com.dmp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Admin / Command Center endpoints: dashboard summary stats, shelter/hospital/team management.
 */
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    private final IncidentRepository incidentRepository;
    private final RescueTeamRepository rescueTeamRepository;
    private final ShelterRepository shelterRepository;

    @GetMapping("/dashboard/summary")
    public Map<String, Object> dashboardSummary() {
        return Map.of(
                "affectedPeople", userRepository.count(),
                "criticalIncidents", incidentRepository.findAll().stream()
                        .filter(i -> i.getPriority() != null && i.getPriority().name().equals("CRITICAL"))
                        .count(),
                "activeRescuers", rescueTeamRepository.findAll().stream()
                        .filter(t -> t.getStatus() != null && t.getStatus().name().equals("AVAILABLE"))
                        .count(),
                "openShelters", shelterRepository.findAll().stream()
                        .filter(s -> Boolean.TRUE.equals(s.getOpen()))
                        .count()
        );
    }
}
