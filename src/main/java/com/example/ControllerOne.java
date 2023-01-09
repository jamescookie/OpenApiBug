package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class ControllerOne {

    @Get("/exposed/one")
    public void method() {

    }
}
