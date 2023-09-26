package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "user_roles")
    @Enumerated(EnumType.STRING)
    private UserRoles userRoles;
}
