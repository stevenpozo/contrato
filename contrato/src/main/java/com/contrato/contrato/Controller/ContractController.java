package com.contrato.contrato.Controller;

import com.contrato.contrato.Entity.Contract;
import com.contrato.contrato.Service.ContractService;
import com.contrato.contrato.Utils.Validations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    // Get all contracts
    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContract();
    }

    // Get contract by id
    @GetMapping("/{id}")
    public Optional<Contract> getContractById(@PathVariable("id") Long id) {
        return contractService.getContractById(id);
    }

    // Create a new contract
    @PostMapping
    public ResponseEntity<?> createContract(@Valid @RequestBody Contract contract, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = Validations.getValidationErrors(result);
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(contractService.saveContract(contract));
    }

    // Delete contract by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable Long id) {
        try {
            contractService.deleteContractById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Update an existing contract
    @PutMapping("/{id}")
    public ResponseEntity<?> updateContract(@Valid @RequestBody Contract contract, @PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = Validations.getValidationErrors(result);
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            return ResponseEntity.ok(contractService.updateContract(contract, id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
