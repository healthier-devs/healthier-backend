package com.healthier.diagnosis.domain.question;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Data
@Document(collection = "diagnosis_logic")
public class Question {

    @Id
    private String id;
    private String question;
    private int is_multiple;
    private List<Answer> answers;

}