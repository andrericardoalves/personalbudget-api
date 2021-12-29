package com.alves.personalbudget.dto;

import com.alves.personalbudget.model.Contact;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class PersonDTO {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String addressNumber;
    private String addressComplement;
    private String addressDistrict;
    @NotBlank
    private String addressZipCode;
    @NotBlank
    private String addressCityId;
    @NotNull
    private List<Contact> contacts;
}
