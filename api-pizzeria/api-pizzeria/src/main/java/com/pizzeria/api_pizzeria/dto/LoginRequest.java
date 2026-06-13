package com.pizzeria.api_pizzeria.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String  dni;
    private String  password;
}
