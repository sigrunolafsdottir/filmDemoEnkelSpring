package com.example.filmdemoenkelspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloWorld() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello World!");
    }

    @Test
    public void helloWorldEsp() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/esp",
                String.class)).contains("Hola Mundo!");
    }

    @Test
    public void listTest() throws Exception {
        List<Integer> list = this.restTemplate
                .getForObject("http://localhost:" + port + "/listTest",
                ArrayList.class);

        assertThat(list).containsExactly(1,2,3);
        assertThat(list).doesNotContain(4);
        assertThat(list).containsAnyOf(1,2,3,4,5,6,7);
        assertThat(list).hasSize(3);
    }

    @Test
    public void holaMundo() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/esp",
                String.class)).contains("Hola Mundo!!!!!!");
    }
}