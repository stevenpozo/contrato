package com.contrato.contrato.Service;

import com.contrato.contrato.Entity.Contract;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    //Get all contract
    List<Contract> getAllContract();

    //Get contract by id
    Optional<Contract> getContractById(Long id);

    //Save a new contract
    Contract saveContract(Contract contract);

    //Delete a contract
    void deleteContractById(Long id);

    //Update contract
    Contract updateContract(Contract contract, Long id);
}
