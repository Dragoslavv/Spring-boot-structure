package com.example.demo.utils;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;

// The UTILS program class, also known as the auxiliary class,
// is a class that contains only static methods, has no citizenship, and cannot incarnate.
// It contains a bunch of related methods so that they can be reused in applications.
// The utility class is usually declared final, so it cannot be divided.
// With a declared private constructor,
// it is assumed to generate and classes cannot run an instance of another class.

public final class Validator {

    // Logger
    private static final Logger log = Logger.getLogger(Validator.class);

    @Bean
    public static boolean isThreeLetters(String param){
        log.info(param);
        return param.matches("[a-zA-Z]{3}");
    }

    @Bean
    public static boolean isLetters(String param){
        log.info(param);
        return param.matches("/[a-zA-Z]+$/");
    }

    @Bean
    public static boolean isValidEmail(String email) {
        log.info(email);
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
