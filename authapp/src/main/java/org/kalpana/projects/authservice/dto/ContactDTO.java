package org.kalpana.projects.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactDTO {
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;
}
