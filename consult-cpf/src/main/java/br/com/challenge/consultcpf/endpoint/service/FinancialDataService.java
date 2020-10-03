package br.com.challenge.consultcpf.endpoint.service;

import br.com.challenge.consultcpf.endpoint.entity.FinancialDataDto;
import br.com.challenge.consultcpf.endpoint.repository.FinancialDataRepository;
import br.com.challenge.consultcpf.endpoint.repository.PersonRepository;
import br.com.challenge.core.exception.NotFoundAnyDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialDataService {

    @Autowired
    private FinancialDataRepository financialDataRepository;

    @Autowired
    private PersonRepository personRepository;

    public FinancialDataDto findFinancialDataByCpf(String cpf) {
        FinancialDataDto financialDataDto = new FinancialDataDto();
        if (personRepository.findPersonByCpf(cpf).isPresent()) {
            financialDataDto.setPerson(personRepository.findPersonByCpf(cpf).get());
            financialDataDto.setFinancialMovement(financialDataRepository.findByMovimentPerson(cpf));
            return financialDataDto;
        }

        throw new NotFoundAnyDataException("Não foi encontrado nenhum registro para esse CPF: "+ cpf);
    }
}
