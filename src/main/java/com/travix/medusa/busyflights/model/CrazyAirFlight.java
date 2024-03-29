package com.travix.medusa.busyflights.model;

import com.travix.medusa.busyflights.enums.CabinClassEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "crazy_air_flight")
@Getter
@Setter
@NoArgsConstructor
public class CrazyAirFlight {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="departure_date")
    private LocalDateTime departureDate;

    @Column(name="arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name="airline")
    private String airline;

    @Column(name="price")
    private Float price;

    @Column(name="cabin_class")
    @Enumerated(EnumType.STRING)
    private CabinClassEnum cabinClass;

    @Column(name="departure_airport_code")
    @Length(max = 3)
    private String departureAirportCode;

    @Column(name="destination_airport_code")
    @Length(max = 3)
    private String destinationAirportCode;

    @Column(name="number_of_passengers")
    private Integer numberOfPassengers;

    public CrazyAirFlight(final Long id,
                          final LocalDateTime departureDate,
                          final LocalDateTime arrivalDate,
                          final String airline,
                          final Float price,
                          final CabinClassEnum cabinClass,
                          final String departureAirportCode,
                          final String destinationAirportCode,
                          final Integer numberOfPassengers) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
        this.price = price;
        this.cabinClass = cabinClass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.numberOfPassengers = numberOfPassengers;
    }
}
