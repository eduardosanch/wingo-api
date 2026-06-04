package com.wingo.api.reward.controller;

import com.wingo.api.reward.entity.Reward;
import com.wingo.api.reward.service.RewardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(
            RewardService rewardService
    ) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public ResponseEntity<List<Reward>> getRewards() {

        return ResponseEntity.ok(
                rewardService.getAllRewards()
        );
    }
}