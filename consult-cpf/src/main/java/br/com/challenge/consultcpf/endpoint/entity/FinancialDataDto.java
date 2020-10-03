package br.com.challenge.consultcpf.endpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialDataDto {

    private Person person;
    private List<FinalcialMoviment> financialMovement;

}
