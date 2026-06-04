package com.wingo.api.branch.service;

import com.wingo.api.branch.entity.Branch;
import com.wingo.api.branch.repository.BranchRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(
            BranchRepository branchRepository
    ) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Branch getBranch(Long id) {

        return branchRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Sucursal no encontrada"
                        ));
    }
}