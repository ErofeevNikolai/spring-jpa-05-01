package ru.netology.springjpa0501.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.springjpa0501.entity.Fio;
import ru.netology.springjpa0501.entity.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface PresonsRepository extends CrudRepository<Persons, Fio> {
    @Query("select p  from Persons p where p.cityOfLiving =:city")
    List<Persons> findByCityOfLiving(@Param("city") String cityOfLiving);

    @Query("select p.fio.name, p.fio.surname, p.age from Persons p where p.age <:age order by p.age")
    List<String> findAllByAgeBeforeOrderByAge(Integer age);

    @Query("select p from Persons p where p.fio =:fio")
    Optional<Persons> findByFio(Fio fio);
}
