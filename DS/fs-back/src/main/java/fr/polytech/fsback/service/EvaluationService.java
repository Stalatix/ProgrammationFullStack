package fr.polytech.fsback.service;
import fr.polytech.fsback.entity.EvaluationsEntity;
import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    private final RestauService restauService;

    public EvaluationsEntity addCommentaire(int RestauId, String messageEval) {
        final RestaurantEntity restaurant = restauService.getRestauById(RestauId);
        final EvaluationsEntity nouvelleEvaluation = EvaluationsEntity.builder().message(messageEval).restaurant(restaurant).build();

        return this.evaluationRepository.save(nouvelleEvaluation);
    }
}
