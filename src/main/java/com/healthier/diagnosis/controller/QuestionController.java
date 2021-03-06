package com.healthier.diagnosis.controller;

import com.healthier.diagnosis.dto.*;
import com.healthier.diagnosis.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value="/api/diagnose")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> getNextQuestion(@RequestBody @Valid QuestionRequestDto dto) {
        return ResponseEntity.ok(questionService.findNextQuestion(dto));
    }

    @PostMapping (value = "/sleepdisorder/first")
    public ResponseEntity<?> getFirstQuestion(@RequestBody @Valid FirstQuestionRequestDto dto) {
        return ResponseEntity.ok(questionService.findFirstQuestion(dto));
    }

    @PostMapping (value = "/sleepdisorder/decisive")
    public ResponseEntity<?> getDecisiveQuestion(@RequestBody @Valid DecisiveQuestionRequestDto dto) {
        return ResponseEntity.ok(questionService.findDecisiveQuestion(dto));
    }

    @PostMapping (value =  "/headache/first")
    public ResponseEntity<?> getHeadacheFirstQuestion(@RequestBody @Valid HeadacheFirstQuestionRequestDto dto){
        return ResponseEntity.ok(questionService.findHeadacheFirstQuestion(dto));
    }

    @PostMapping (value = "/headache/decisive")
    public ResponseEntity<?> getHeadacheDecisiveQuestion(@RequestBody @Valid HeadacheDecisiveQuestionRequestDto dto) {
        return ResponseEntity.ok(questionService.findHeadacheDecisiveQuestion(dto));
    }
}
