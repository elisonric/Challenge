package br.com.challenge.consultcpf.endpoint.repository;

import br.com.challenge.consultcpf.endpoint.entity.ConsultationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultationHistoryRepository extends JpaRepository<ConsultationHistory, Long> {

    @Query(" SELECT c " +
            " FROM ConsultationHistory c" +
            " WHERE " +
            "   c.person.cpf = :cpf AND" +
            "   c.consultationDate = (SELECT MAX(consultationDate) FROM ConsultationHistory)")
    Optional<ConsultationHistory> findLastConsult(@Param("cpf") String cpf);
}
