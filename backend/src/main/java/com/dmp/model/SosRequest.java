package com.dmp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sos_requests")
public class SosRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long callerUserId;
    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private Status status; // PENDING, ACKNOWLEDGED, DISPATCHED, RESOLVED

    private Instant createdAt = Instant.now();

    public enum Status { PENDING, ACKNOWLEDGED, DISPATCHED, RESOLVED }
}
