package com.dmp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rescue_teams")
public class RescueTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private Double currentLatitude;
    private Double currentLongitude;

    @Enumerated(EnumType.STRING)
    private Status status; // AVAILABLE, EN_ROUTE, BUSY, OFFLINE

    private Long assignedIncidentId;

    public enum Status { AVAILABLE, EN_ROUTE, BUSY, OFFLINE }
}
