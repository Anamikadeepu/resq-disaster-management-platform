package com.dmp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role; // CITIZEN, RESPONDER, ADMIN

    private Double lastKnownLatitude;
    private Double lastKnownLongitude;

    public enum Role {
        CITIZEN, RESPONDER, ADMIN
    }
}
