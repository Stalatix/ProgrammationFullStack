package fr.polytech.fsback.repository;

import fr.polytech.fsback.entity.EvaluationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<EvaluationsEntity, Integer>{
}
