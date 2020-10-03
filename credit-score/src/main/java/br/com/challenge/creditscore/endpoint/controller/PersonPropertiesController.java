package br.com.challenge.creditscore.endpoint.controller;

import br.com.challenge.creditscore.endpoint.entity.Person;
import br.com.challenge.creditscore.endpoint.service.PersonPropertiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person/properties")
@Api(value = "Endpoint person properties")
public class PersonPropertiesController {

    @Autowired
    private PersonPropertiesService personPropertiesService;

    @GetMapping("/{cpf}")
    @ApiOperation(value = "Find the latest date purchase consultation at CPF", response = Person.class)
    public ResponseEntity personProperties(@PathVariable("cpf") String cpf) {
        return new ResponseEntity<>(personPropertiesService.findPersonProperties(cpf), HttpStatus.OK);
    }
}
