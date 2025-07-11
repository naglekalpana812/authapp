package org.kalpana.projects.authservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
    private Long userId;
    private String name;
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}