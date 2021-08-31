package com.hackerrank.sample;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class SampleApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void defaultHelloTest() throws Exception {
        mockMvc.perform(get("/defaultHello"))
                .andDo(print())
                .andExpect(jsonPath("$.echo").value("Default Hello World"))
                .andExpect(status().isOk());
    }

    @Test
    public void defaultHelloWithParamTest() throws Exception {
        mockMvc.perform(get("/defaultHello")
                .param("message", "False Message"))
                .andDo(print())
                .andExpect(jsonPath("$.echo").value("Default Hello World"))
                .andExpect(status().isOk());
    }

    @Test
    public void customHelloTest() throws Exception {

        String jsonContent = "{\"message\":\"customHello\", \"echo\":\"Custom Custom Hello World!\"}";
        mockMvc.perform(post("/customHello")
                .param("message", "Custom Hello World!")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andDo(print())
                .andExpect(jsonPath("$.echo").value("Custom Custom Hello World!"))
                .andExpect(status().isOk());
    }

    @Test
    public void customHelloWithEmptyParamTest() throws Exception {

        String jsonContent = "{\"message\":\"customHello\", \"echo\": \"Custom \"}";
        mockMvc.perform(post("/customHello")
                .param("message", "")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andDo(print())
                .andExpect(jsonPath("$.echo").value("Custom "))
                .andExpect(status().isOk());
    }

    @Test
    public void customHelloWithoutParamTest() throws Exception {
        mockMvc.perform(post("/customHello")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


}
