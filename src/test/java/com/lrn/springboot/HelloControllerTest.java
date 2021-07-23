package com.lrn.springboot;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired //自动装配
    private MockMvc mvc;
    @BeforeAll
    public static void beforeClass(){
        System.out.println("=== before class ===");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("===before method===");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("===after method===");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("===after class===");
    }

    @Test
    public void hello() throws Exception {
        MvcResult result = mvc.perform(get("/")
                .param("name", "IMOOC")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Hello IMOOC"))
                .andReturn();

        System.out.println("==="+result.getResponse().getContentAsString()+"===");
    }
}