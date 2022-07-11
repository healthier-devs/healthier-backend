package com.healthier.diagnosis.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DecisiveQuestionRequestDto {
    @NotNull
    private String questionId;
    @NotNull
    private int answerId;

    private String period;
    private String cycle;
    private int scoreB;  // 수면 위생 점수
    private String gender;
    private int birthYear;
    private List<Integer> interests;
}