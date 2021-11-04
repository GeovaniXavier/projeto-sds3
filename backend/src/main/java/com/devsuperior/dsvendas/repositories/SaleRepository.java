package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.saller, SUM(obj.amount)) FROM Sale AS obj GROUP BY obj.saller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.saller, SUM(obj.visited), SUM(obj.deals)) FROM Sale AS obj GROUP BY obj.saller")
    List<SaleSuccessDTO> successGroupedBySeller();

}
