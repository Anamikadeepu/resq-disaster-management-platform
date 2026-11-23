package com.dmp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private IncidentType type; // MEDICAL, FIRE, FLOOD, MISSING_PERSON, OTHER

    private String description;
    private String photoUrl;

    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private Priority priority; // CRITICAL, HIGH, NORMAL

    @Enumerated(EnumType.STRING)
    private Status status; // REPORTED, ASSIGNED, IN_PROGRESS, RESOLVED

    private Long reportedByUserId;
    private Long assignedRescueTeamId;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    public enum IncidentType { MEDICAL, FIRE, FLOOD, MISSING_PERSON, LOST_HOUSE, OTHER }
    public enum Priority { CRITICAL, HIGH, NORMAL }
    public enum Status { REPORTED, ASSIGNED, IN_PROGRESS, RESOLVED }
}
