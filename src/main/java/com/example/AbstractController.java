package com.example;

import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public class AbstractController {
    @Get("/should-be-hidden/one")
    public void methodOne() {

    }

    @Get("/should-be-hidden/two")
    public void methodTwo() {

    }

}
