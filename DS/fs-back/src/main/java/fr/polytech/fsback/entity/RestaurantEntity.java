package fr.polytech.fsback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Restaurant")
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class RestaurantEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name ="Nom")
    private String nom;

    @Column(name = "Adresse")
    private String adresse;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationsEntity> evaluation;
}
