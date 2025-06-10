package org.kalpana.projects.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserDetailsDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 1, message = "At least one contact is required")
    private List<ContactDTO> contacts;

    @Size(min = 1, message = "At least one address is required")
    private List<AddressDTO> addresses;
}
