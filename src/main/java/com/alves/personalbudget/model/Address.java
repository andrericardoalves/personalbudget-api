package com.alves.personalbudget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {
    private String address;
    private String address_number;
    private String complement;
    private String district;
    private String zip_code;
    private String city;
    private String state;
}
