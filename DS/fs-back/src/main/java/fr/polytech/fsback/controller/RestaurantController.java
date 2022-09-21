package fr.polytech.fsback.controller;
import fr.polytech.fsback.dto.RestaurantDto;
import fr.polytech.fsback.service.RestauService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    private List<RestaurantDto> restaurantDtos = new ArrayList<>(Arrays.asList(RestaurantDto.builder().id(1).nom("Au petit fourneau").adresse("5 chemin de la rose, Fraize").build(), RestaurantDto.builder().id(2).nom("La maison dans le parc").adresse("3 rue sainte Catherine, Nancy").build()));

    private final RestauService restauService;


    @GetMapping("/restaurant")
    public @ResponseBody List<RestaurantDto> getAllRestau() {
        System.out.println("Retourne tous les Restaurant");
        return this.restauService.getAllRestaurant().stream().map(entity -> RestaurantDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @GetMapping("/restaurant/{id}")
    public @ResponseBody RestaurantDto getRestauById(@PathVariable final int id) {
        return RestaurantDto.fromEntity(this.restauService.getRestauById(id));

    }

    //

    @PostMapping("/restaurant")
    public @ResponseBody RestaurantDto addRestau(@Valid @RequestBody RestaurantDto R) {
        return RestaurantDto.fromEntity(this.restauService.addRestau(R.getNom(),R.getAdresse()));
    }

    /*@PutMapping("/restaurant/{id}")
    public @ResponseBody RestaurantDto updateRestau(@PathVariable final int id, @Valid @RequestBody RestaurantDto R) {
       return RestaurantDto.fromEntity(this.restauService.getRestauById(id).updateRestau(R.getNom(),R.getAdresse()));
    }*/

    @DeleteMapping("/restaurant/{id}")
    public void DeleteRestau(@PathVariable final int id) {
        this.restauService.deleteRestau(id);
    }
}