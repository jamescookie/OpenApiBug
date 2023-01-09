package com.example;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
class OpenApiBugTest {
    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void getApiDocs() {
        String uri = "/api-docs/openapibug-0.0.yml";
        var response = client.toBlocking().exchange(uri, String.class);

        assertThat(response.status().getCode()).isEqualTo(200);
    }

}
