package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_join_addresses")
@Data
public class UsersJoinAddresses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "addres_id", referencedColumnName = "id")
    private Address address;
}
