package fr.polytech.fsback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("Nom")
    @Size(max = 90)
    private String nom;

    @JsonProperty("Adresse")
    @Size(max=255)
    private String adresse;

    @JsonProperty("evaluation")
    private List<EvaluationDto> evaluation;

    public static RestaurantDto fromEntity(RestaurantEntity restaurantEntity){
        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .evaluation(restaurantEntity.getEvaluation().stream().map(evaluation -> EvaluationDto.fromEntity(evaluation)).collect(Collectors.toList()))
                .build();
    }
}
