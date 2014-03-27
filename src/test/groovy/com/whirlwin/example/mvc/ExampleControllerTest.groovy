package com.whirlwin.example.mvc

import com.whirlwin.example.config.AppConfig
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.mockito.Matchers.any
import static org.mockito.Mockito.verify
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfig.class)
class ExampleControllerTest {

    @Mock
    ExampleRepository exampleRepository

    @InjectMocks
    ExampleController exampleController

    MockMvc mockMvc

    @Before
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(exampleController).build()
    }

    @Test
    void testFindUsers() {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(content().encoding("UTF-8"))

        verify(exampleRepository).findUsers()
    }

    @Test
    void testCreateUser() {
        mockMvc.perform(post("/users"))
                .andExpect(status().isCreated())

        verify(exampleRepository).insertUser(any(User.class))
    }
}