package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_join_addresses")
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UsersJoinAddresses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UsersJoinAddresses(User user, Address address) {
        this.user = user;
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "addres_id", referencedColumnName = "id")
    private Address address;
}
