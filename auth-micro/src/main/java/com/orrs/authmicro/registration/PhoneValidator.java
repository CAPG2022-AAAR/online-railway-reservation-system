package com.orrs.authmicro.registration;


import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PhoneValidator {
    public static String regex = "\\+?\\d[\\d -]{8,12}\\d";

    public boolean test(String phoneNumber) {
        boolean b  =  Pattern.compile(regex)
                .matcher(phoneNumber)
                .matches();

        return b;
    }
}