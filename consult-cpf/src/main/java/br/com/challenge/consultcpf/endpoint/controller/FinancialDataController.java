package br.com.challenge.consultcpf.endpoint.controller;

import br.com.challenge.consultcpf.endpoint.entity.ConsultationHistory;
import br.com.challenge.consultcpf.endpoint.entity.FinancialDataDto;
import br.com.challenge.consultcpf.endpoint.service.FinancialDataService;
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
@RequestMapping("/financial/data")
@Api(value = "Endpoint to consult financial data")
public class FinancialDataController {

    @Autowired
    private FinancialDataService financialDataService;

    @GetMapping("/{cpf}")
    @ApiOperation(value = "Find financial data on CPF", response = FinancialDataDto.class)
    public ResponseEntity findFinancialDataByCpf(@PathVariable("cpf")String cpf){
        return new ResponseEntity(financialDataService.findFinancialDataByCpf(cpf), HttpStatus.OK);
    }
}
