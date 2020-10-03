package br.com.challenge.consultcpf.endpoint.repository;

import br.com.challenge.consultcpf.endpoint.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query(" SELECT p " +
            " FROM PurchaseHistory p" +
            " WHERE " +
            "   p.person.cpf = :cpf AND" +
            "   p.purchaseDate = (SELECT MAX(purchaseDate) FROM PurchaseHistory)")
    Optional<PurchaseHistory> findLastPurchase(@Param("cpf") String cpf);
}
