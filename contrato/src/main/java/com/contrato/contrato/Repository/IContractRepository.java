package com.contrato.contrato.Repository;

import com.contrato.contrato.Entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
}
