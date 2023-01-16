package ru.netology.springjpa0501.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springjpa0501.entity.Fio;
import ru.netology.springjpa0501.repository.PresonsRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class Controller {
    private PresonsRepository personRepo;

    @GetMapping("/persons/by-city")
    private ResponseEntity<List> getByCiti(@RequestParam("city") String city) {
        return new ResponseEntity<>(personRepo.findByCityOfLiving(city), HttpStatus.OK);
    }

    @GetMapping("/persons/by-age")
    private ResponseEntity<List> getByAge(@RequestParam("age") Integer age) {
        return new ResponseEntity<>(personRepo.findAllByAgeBeforeOrderByAge(age), HttpStatus.OK);
    }

    @GetMapping("/persons/by-fio")
    private ResponseEntity<Optional> getByFio(@Validated Fio fio) {
        return new ResponseEntity<>(personRepo.findByFio(fio), HttpStatus.OK);
    }
}
