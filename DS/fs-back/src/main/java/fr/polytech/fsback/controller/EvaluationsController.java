package fr.polytech.fsback.controller;

import fr.polytech.fsback.dto.EvaluationDto;
import fr.polytech.fsback.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EvaluationsController {
    private final EvaluationService evaluationService;

    @PostMapping("restaurant/{restauId}/evaluation")
    public @ResponseBody EvaluationDto addCommentaire(@Valid @RequestBody EvaluationDto eval, @PathVariable int restauId) {
        return EvaluationDto.fromEntity(this.evaluationService.addCommentaire(restauId, eval.getMessage()));
    }
}
