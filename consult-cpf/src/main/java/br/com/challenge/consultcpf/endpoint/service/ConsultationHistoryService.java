package br.com.challenge.consultcpf.endpoint.service;

import br.com.challenge.consultcpf.endpoint.entity.ConsultationHistory;
import br.com.challenge.consultcpf.endpoint.repository.ConsultationHistoryRepository;
import br.com.challenge.core.exception.NotFoundAnyDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultationHistoryService {

    @Autowired
    private ConsultationHistoryRepository consultationHistoryRepository;

    public Optional<ConsultationHistory> findLastConsult(String cpf) {
        if (consultationHistoryRepository.findLastConsult(cpf).isPresent()) {
            return consultationHistoryRepository.findLastConsult(cpf);
        }

        throw new NotFoundAnyDataException("Não foi encontrado nenhum registro para esse CPF: " + cpf);
    }
}
