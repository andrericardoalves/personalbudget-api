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

    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String address_number;
    private String complement;
    private String district;
    @NotBlank
    private String zip_code;
    @NotBlank
    private String cityId;
    @NotNull
    private List<Contact> contacts;
}
