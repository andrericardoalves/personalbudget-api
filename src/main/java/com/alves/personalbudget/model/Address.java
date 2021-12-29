package com.alves.personalbudget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {
    private String address;
    private String addressNumber;
    private String complement;
    private String district;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
