package com.whirlwin.example;

import com.whirlwin.example.config.AppConfig
import org.junit.Before
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
class PageControllerTest {

    PageController pageController = new PageController()

    MockMvc mockMvc

    @Before
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pageController).build()
    }

    @Test
    void testIndex() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk())
    }
}
