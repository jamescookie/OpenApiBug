package com.example;

import io.micronaut.http.annotation.Get;

public class AbstractController {
    @Get("/should-be-hidden/one")
    public void methodOne() {

    }

    @Get("/should-be-hidden/two")
    public void methodTwo() {

    }

}
