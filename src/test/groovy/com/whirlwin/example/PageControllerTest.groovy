package com.whirlwin.example;

import com.whirlwin.example.config.AppConfig
import org.junit.Before
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfig.class)
class PageControllerTest {

    def PageController pageController = new PageController()

    def MockMvc mockMvc

    @Before
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pageController).build()
    }

    @Test
    void testIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
    }
}
