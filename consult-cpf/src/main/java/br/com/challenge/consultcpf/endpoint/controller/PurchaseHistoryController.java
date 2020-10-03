package br.com.challenge.consultcpf.endpoint.controller;

import br.com.challenge.consultcpf.endpoint.entity.ConsultationHistory;
import br.com.challenge.consultcpf.endpoint.entity.PurchaseHistory;
import br.com.challenge.consultcpf.endpoint.service.PurchaseHistoryService;
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
@RequestMapping("/purchase-history")
@Api(value = "Endpoint to purchase history")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @GetMapping("/last/{cpf}")
    @ApiOperation(value = "Find the latest date purchase consultation at CPF", response = PurchaseHistory.class)
    public ResponseEntity lastPurchase(@PathVariable("cpf")String cpf) {
        return new ResponseEntity(purchaseHistoryService.findLastDataPurchase(cpf), HttpStatus.OK);
    }
}
