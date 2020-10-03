package br.com.challenge.debts.endpoint.service;

import br.com.challenge.core.exception.NotFoundAnyDataException;
import br.com.challenge.debts.endpoint.entity.Person;
import br.com.challenge.debts.endpoint.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DebtsService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll(){
        log.info("Listing all person debts");
        return personRepository.findAll();
    }

    public Optional<Person> findPerson(Long id) {

        if (personRepository.findById(id).isPresent()){
            return personRepository.findById(id);
        }
        throw new NotFoundAnyDataException("Não foi encontrado nenhum registro para esse ID: "+ id);
    }
}
