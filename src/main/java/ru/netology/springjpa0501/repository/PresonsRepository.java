package ru.netology.springjpa0501.repository;



import org.hibernate.annotations.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.netology.springjpa0501.entity.Fio;
import ru.netology.springjpa0501.entity.Persons;

import java.util.List;
import java.util.Optional;


@Repository
public interface PresonsRepository extends PagingAndSortingRepository<Persons, Fio> {

    List<Persons> findByCityOfLiving(String city);

    List<Persons> findAllByAgeBeforeOrderByAge(Integer age);

    Optional<Persons> findByFio(Fio fio);

}
