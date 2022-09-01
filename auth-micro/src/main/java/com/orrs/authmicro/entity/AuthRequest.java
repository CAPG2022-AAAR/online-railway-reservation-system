package com.orrs.authmicro.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String userName;
    private String password;
}
