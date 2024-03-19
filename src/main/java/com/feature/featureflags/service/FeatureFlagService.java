package com.feature.featureflags.service;

import com.feature.featureflags.Entity.FeatureFlag;
import com.feature.featureflags.repository.FeatureFlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureFlagService {

    @Autowired
    private FeatureFlagRepository featureFlagRepository;

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    public List<FeatureFlag> getAllFeatureFlags() {
        return featureFlagRepository.findAll();
    }
    public FeatureFlag getFlagById(String name) {
        Optional<FeatureFlag> flagOptional = featureFlagRepository.findById(name);
        return flagOptional.orElse(null);
    }
    public FeatureFlag createFeatureFlag(FeatureFlag featureFlag) {
        featureFlag.setCreatedDate(LocalDateTime.now().format(format));
        featureFlag.setLastModifiedDate(LocalDateTime.now().format(format));
        return featureFlagRepository.save(featureFlag);
    }

    public FeatureFlag updateFeatureFlag(String name, Boolean enabled) {
        Optional<FeatureFlag> flagOptional = featureFlagRepository.findById(name);
        FeatureFlag featureFlag=flagOptional.get();
        featureFlag.setEnabled(enabled);
        featureFlag.setLastModifiedDate(LocalDateTime.now().format(format));
        return featureFlagRepository.save(featureFlag);
    }

    public void deleteFeatureFlag(String id) {
        featureFlagRepository.deleteById(id);
    }
}