package br.com.challenge.creditscore.endpoint.repository;

import br.com.challenge.creditscore.endpoint.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByCpf(String cpf);
}
