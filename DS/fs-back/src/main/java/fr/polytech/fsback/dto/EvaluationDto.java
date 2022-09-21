package fr.polytech.fsback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.entity.EvaluationsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class EvaluationDto {

    @JsonProperty("id")
    private int id;

    @Size(max=50)
    @JsonProperty("evaluateur")
    private String evaluateur;

    @NotBlank
    @Size(max=255)
    @JsonProperty("message")
    private String message;

    @JsonProperty("note")
    private int note;
 // fonctionne que pour le message et l'id
    public static EvaluationDto fromEntity(EvaluationsEntity entity) {
        return EvaluationDto.builder()
                .id(entity.getId())
                .evaluateur(entity.getEvaluateur())
                .message(entity.getMessage())
                .note(entity.getNote())
                .build();
    }
}
