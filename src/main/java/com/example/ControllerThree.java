package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@Controller
public class ControllerThree extends AbstractController {

    @Hidden
    @Override
    public void methodTwo() {
        super.methodTwo();
    }
}
