package br.com.challenge.creditscore.endpoint.service;

import br.com.challenge.core.exception.NotFoundAnyDataException;
import br.com.challenge.creditscore.endpoint.entity.Person;
import br.com.challenge.creditscore.endpoint.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonPropertiesService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> findPersonProperties(String cpf) {
        if (personRepository.findPersonByCpf(cpf).isPresent()) {
            return personRepository.findPersonByCpf(cpf);
        }
        throw new NotFoundAnyDataException("Não foi encontrado nenhum item para este CPF: " + cpf);
    }
}
