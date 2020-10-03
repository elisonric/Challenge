package br.com.challenge.consultcpf.endpoint.repository;

import br.com.challenge.consultcpf.endpoint.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByCpf(String cpf);
}
