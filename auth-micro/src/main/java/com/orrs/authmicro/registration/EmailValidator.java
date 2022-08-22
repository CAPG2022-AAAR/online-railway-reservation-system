package com.orrs.authmicro.registration;

import org.springframework.stereotype.Service;



import java.util.regex.Pattern;


@Service
public class EmailValidator {
        public static final String REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    public boolean test(String emailAddress) {
        return Pattern.compile(REGEX)
                .matcher(emailAddress)
                .matches();
    }
}
