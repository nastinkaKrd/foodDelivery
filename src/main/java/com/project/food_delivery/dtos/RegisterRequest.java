package com.project.food_delivery.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Schema(description = "Username", example = "nastinka_krd")
    private String username;

    @Email
    @Schema(description = "Email", example = "nastinka352@gmail.com")
    private String email;

    @Schema(description = "Password", example = "qwerty123")
    private String password;

    @Schema(description = "Phone number", example = "1234567890")
    private String phoneNumber;
}