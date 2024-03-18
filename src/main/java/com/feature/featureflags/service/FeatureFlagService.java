package com.feature.featureflags.service;

import com.feature.featureflags.Entity.FeatureFlag;
import com.feature.featureflags.repository.FeatureFlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureFlagService {

    @Autowired
    private FeatureFlagRepository featureFlagRepository;

    public List<FeatureFlag> getAllFeatureFlags() {
        return featureFlagRepository.findAll();
    }
    public FeatureFlag getFlagById(Long id) {
        Optional<FeatureFlag> flagOptional = featureFlagRepository.findById(id);
        return flagOptional.orElse(null);
    }
    public FeatureFlag createFeatureFlag(FeatureFlag featureFlag) {
        return featureFlagRepository.save(featureFlag);
    }

    public FeatureFlag updateFeatureFlag(Long id, FeatureFlag featureFlag) {
        featureFlag.setId(id);
        return featureFlagRepository.save(featureFlag);
    }

    public void deleteFeatureFlag(Long id) {
        featureFlagRepository.deleteById(id);
    }
}