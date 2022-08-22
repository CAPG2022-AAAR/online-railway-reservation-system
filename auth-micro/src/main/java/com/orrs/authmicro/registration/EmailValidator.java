package com.orrs.authmicro.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class EmailValidator {
        public static String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    public boolean test(String emailAddress) {
        boolean b  =  Pattern.compile(regex)
                .matcher(emailAddress)
                .matches();
        System.out.println(b + emailAddress);
        return b;
    }
}
