package com.healthier.diagnosis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthier.diagnosis.dto.QuestionRequestDto;
import com.healthier.diagnosis.dto.headache.QuestionResponse;
import com.healthier.diagnosis.dto.headache.painArea.HeadachePainAreaFirstRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class HeadacheQuestionControllerTest {
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    HeadacheQuestionController questionController;

    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @DisplayName("API : 특정 통증 부위 시작 질문 - 뒷목")
    @Test
    void painAreaFirstQuestion() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/diagnose/headache/pain-area/first").contentType(MediaType.APPLICATION_JSON)
                        .content(
                                objectMapper.writeValueAsString(new HeadachePainAreaFirstRequest("뒷목")
                                        )))
                .andExpect(result -> status().isOk());
    }
}