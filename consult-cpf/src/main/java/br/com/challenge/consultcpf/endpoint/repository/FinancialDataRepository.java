package br.com.challenge.consultcpf.endpoint.repository;

import br.com.challenge.consultcpf.endpoint.entity.FinalcialMoviment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialDataRepository extends JpaRepository<FinalcialMoviment, Long> {

    @Query(" SELECT m" +
            " FROM FinalcialMoviment m" +
            " WHERE " +
            "   m.person.cpf = :cpf")
    List<FinalcialMoviment> findByMovimentPerson(String cpf);
}
