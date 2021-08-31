package com.tbpay.preference.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbpay.preference.model.PreferenceDto;
import com.tbpay.preference.repository.daomodels.Preference;
import com.tbpay.preference.service.PreferenceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@WebMvcTest(controllers = PreferenceController.class)
class PreferenceControllerTest {

    private static final String URI = "/preferences";
    @MockBean
    private PreferenceService preferenceService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private PreferenceDto preferenceDto;

    private Preference preference;

    @BeforeEach
    void setUp() {
        preferenceDto = PreferenceDto.builder()
                .userId("15RafeeK")
                .smsPreference(false)
                .postPreference(true)
                .emailPreference(true)
                .build();

        preference = Preference.builder()
                .userId("15RafeeK")
                .smsPreference(false)
                .postPreference(true)
                .emailPreference(true)
                .build();

    }

    @Test
    void createUserTest() throws Exception {

        Mockito.when(preferenceService.createOrUpdatePreferences(Mockito.any(PreferenceDto.class))).thenReturn(preference);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(preferenceDto).getBytes(StandardCharsets.UTF_8))
                        .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String preferenceJson = result.getResponse().getContentAsString();
        Assertions.assertThat(preferenceJson).isNotEmpty();
    }

}