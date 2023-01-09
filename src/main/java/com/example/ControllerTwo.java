package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@Controller
public class ControllerTwo {

    @Get("/hidden/one")
    public void method() {

    }
}
