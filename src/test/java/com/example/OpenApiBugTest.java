package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
    void getApiDocs() throws Exception {
        String uri = "/api-docs/openapibug-0.0.yml";
        var response = client.toBlocking().exchange(uri, String.class);

        assertThat(response.status().getCode()).isEqualTo(200);
        String yml = response.body();
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Map<?, ?> ymlMap = yamlReader.readValue(yml, Map.class);
        Object paths = ymlMap.get("paths");
        assertThat(paths).isInstanceOf(Map.class);
        assertThat((Map) paths).hasSize(1);
    }

}
