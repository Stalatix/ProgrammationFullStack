package fr.polytech.fsback.service;

import fr.polytech.fsback.dto.RestaurantDto;
import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.execption.InvalidValueException;
import fr.polytech.fsback.execption.NotFoundException;
import fr.polytech.fsback.repository.RestauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauService {

    private List<RestaurantDto> restaurantDtos = new ArrayList<>(Arrays.asList(RestaurantDto.builder().id(1).nom("Au petit fourneau").adresse("5 chemin de la rose, Fraize").build(), RestaurantDto.builder().id(2).nom("La maison dans le parc").adresse("3 rue sainte Catherine, Nancy").build()));
    private final RestauRepository restauRepository;

        public List<RestaurantEntity> getAllRestaurant() {
            return this.restauRepository.findAll();
        }

        public RestaurantEntity getRestauById(int id){
            return this.restauRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Restaurant with id " + id + " doesn't exist"));
        }

        public RestaurantEntity addRestau(String titre,String adresse){
            final RestaurantEntity nouveauResto = RestaurantEntity.builder().nom(titre).adresse(adresse).build();
            return this.restauRepository.save(nouveauResto);
        }

        public void deleteRestau(int ID){
            restauRepository.delete(getRestauById(ID));

        }

    public RestaurantEntity updateRestau(int id, String nouveauNom) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }
        final RestaurantEntity MAJrestau = this.restauRepository.findById(id).orElseThrow(() -> new NotFoundException("Restaurant with id " + id + " doesn't exist"));
        MAJrestau.setNom(nouveauNom);
        restauRepository.save(MAJrestau);
        return MAJrestau;
    }
}
