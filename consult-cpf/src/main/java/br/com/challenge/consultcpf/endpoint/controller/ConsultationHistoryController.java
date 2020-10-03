package br.com.challenge.consultcpf.endpoint.controller;

import br.com.challenge.consultcpf.endpoint.entity.ConsultationHistory;
import br.com.challenge.consultcpf.endpoint.service.ConsultationHistoryService;
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
@RequestMapping("/consult")
@Api(value = "Endpoint to consult history the consult")
public class ConsultationHistoryController {

    @Autowired
    private ConsultationHistoryService consultationHistoryService;

    @GetMapping("/last/{cpf}")
    @ApiOperation(value = "Find last consult on CPF", response = ConsultationHistory.class)
    public ResponseEntity lastConsult(@PathVariable("cpf") String cpf){
        return new ResponseEntity(consultationHistoryService.findLastConsult(cpf), HttpStatus.OK);
    }
}
