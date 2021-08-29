package com.tbpay.preference.controller;

import com.tbpay.preference.service.PreferenceService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class PreferenceControllerTest {

    @InjectMocks
    private PreferenceController preferenceController;
    @Mock
    private PreferenceService preferenceService;

    private MockMvc mockMvc;


    @BeforeAll
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Object [] controller = new Object[0];
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}