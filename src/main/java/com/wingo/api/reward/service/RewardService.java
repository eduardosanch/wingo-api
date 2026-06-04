package com.wingo.api.reward.service;

import com.wingo.api.reward.entity.Reward;
import com.wingo.api.reward.repository.RewardRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;

    public RewardService(
            RewardRepository rewardRepository
    ) {
        this.rewardRepository = rewardRepository;
    }

    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }
}