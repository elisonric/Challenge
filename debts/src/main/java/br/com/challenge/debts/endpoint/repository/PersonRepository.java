package br.com.challenge.debts.endpoint.repository;

import br.com.challenge.debts.endpoint.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
