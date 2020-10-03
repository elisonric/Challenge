package br.com.challenge.debts.endpoint.controller;

import br.com.challenge.debts.endpoint.entity.Person;
import br.com.challenge.debts.endpoint.service.DebtsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
@Api(value = "Endpoint to consult people's debts")
public class PersonDebtsController {

    @Autowired
    private DebtsService debtsService;

    @GetMapping
    @ApiOperation(value = "List All people's debts", response = Person[].class)
    public ResponseEntity listPeople() {
        return new ResponseEntity<>(debtsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "person/{id}")
    @ApiOperation(value = "Find person's debts", response = Person.class)
    public ResponseEntity personDebts(@PathVariable("id")Long id) {
        return new ResponseEntity<>(debtsService.findPerson(id), HttpStatus.OK);
    }
}
