package fr.polytech.fsback.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Evaluation")
public class EvaluationsEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "evaluateur")
    private String evaluateur;

    @Column(name = "message")
    private String message;

    @Column(name = "note")
    private int note;

    @ManyToOne
    @JoinColumn(name = "restau_id", referencedColumnName = "id")
    private RestaurantEntity restaurant;

}
