package com.project.food_delivery.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "places_join_addresses")
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class PlacesJoinAddresses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "addres_id", referencedColumnName = "id")
    private Address address;

    public PlacesJoinAddresses(Place place, Address address) {
        this.place = place;
        this.address = address;
    }
}
