package com.example.filmdemoenkelspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//Testar bara weblagret. Ingen webbserver, ingen Springkontext skapas upp
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World!!!!!!!!!")));
    }

    @Test
    public void shouldReturnHolaMundo() throws Exception {
        this.mockMvc.perform(get("/esp"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hola Mundo!!!!!!!!")));
    }

    @Test
    public void shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/nonsenseURL"))
                .andExpect(status().isNotFound());
    }

}