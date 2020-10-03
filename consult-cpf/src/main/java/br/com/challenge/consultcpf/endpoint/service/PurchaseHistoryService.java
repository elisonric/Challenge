package br.com.challenge.consultcpf.endpoint.service;

import br.com.challenge.consultcpf.endpoint.entity.PurchaseHistory;
import br.com.challenge.consultcpf.endpoint.repository.PurchaseHistoryRepository;
import br.com.challenge.core.exception.NotFoundAnyDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    public Optional<PurchaseHistory> findLastDataPurchase(String cpf) {

        if (purchaseHistoryRepository.findLastPurchase(cpf).isPresent()){

            return purchaseHistoryRepository.findLastPurchase(cpf);
        }
        throw new NotFoundAnyDataException("Não foi encontrado nenhum registro para esse CPF: "+ cpf);
    }
}
