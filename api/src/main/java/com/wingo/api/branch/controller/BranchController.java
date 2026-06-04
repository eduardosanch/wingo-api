package com.wingo.api.branch.controller;

import com.wingo.api.branch.entity.Branch;
import com.wingo.api.branch.service.BranchService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchService branchService;

    public BranchController(
            BranchService branchService
    ) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<Branch>> getBranches() {

        return ResponseEntity.ok(
                branchService.getAllBranches()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranch(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                branchService.getBranch(id)
        );
    }
}