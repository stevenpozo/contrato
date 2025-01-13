package com.contrato.contrato.Service;

import com.contrato.contrato.Entity.Contract;
import com.contrato.contrato.Repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> getAllContract() {
        try {
            List<Contract> contracts = contractRepository.findAll();
            if (contracts.isEmpty()) {
                return new ArrayList<>();
            }
            return contracts;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error retrieving contracts", e);
        }
    }

    @Override
    public Optional<Contract> getContractById(Long id) {
        try {
            Optional<Contract> contract = contractRepository.findById(id);
            if (contract.isPresent()) {
                return contract;
            } else {
                throw new RuntimeException("Contract with id " + id + " not found");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error finding contract with id " + id, e);
        }
    }

    @Override
    public Contract saveContract(Contract contract) {
        try {
            contract.setDate_start(LocalDateTime.now());
            return contractRepository.save(contract);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error saving contract", e);
        }
    }

    @Override
    public void deleteContractById(Long id) {
        try {
            Optional<Contract> contract = contractRepository.findById(id);
            if (contract.isPresent()) {
                contractRepository.deleteById(id);
            } else {
                throw new RuntimeException("Contract with id " + id + " not found");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error deleting contract with id " + id, e);
        }
    }

    @Override
    public Contract updateContract(Contract contract, Long id) {
        try {
            Optional<Contract> existingContract = contractRepository.findById(id);
            if (existingContract.isPresent()) {
                Contract updateContract = existingContract.get();
                updateContract.setEmploy(contract.getEmploy());
                updateContract.setCompany(contract.getCompany());
                updateContract.setMonth_duration(contract.getMonth_duration());
                updateContract.setDate_start(contract.getDate_start());
                return contractRepository.save(updateContract);
            } else {
                throw new RuntimeException("Contract with id " + id + " not found");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error updating contract with id " + id, e);
        }
    }
}
