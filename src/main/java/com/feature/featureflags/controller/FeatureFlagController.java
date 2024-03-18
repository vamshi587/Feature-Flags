package com.feature.featureflags.controller;

import com.feature.featureflags.Entity.FeatureFlag;
import com.feature.featureflags.service.FeatureFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feature-flags")
public class FeatureFlagController {

    @Autowired
    private FeatureFlagService featureFlagService;

    @GetMapping
    public List<FeatureFlag> getAllFeatureFlags() {
        return featureFlagService.getAllFeatureFlags();
    }
    @GetMapping("/{id}")
    public FeatureFlag getFlagById(@PathVariable Long id) {
        return featureFlagService.getFlagById(id);
    }
    @PostMapping
    public FeatureFlag createFeatureFlag(@RequestBody FeatureFlag featureFlag) {
        return featureFlagService.createFeatureFlag(featureFlag);
    }

    @PutMapping("/{id}")
    public FeatureFlag updateFeatureFlag(@PathVariable Long id, @RequestBody FeatureFlag featureFlag) {
        return featureFlagService.updateFeatureFlag(id, featureFlag);
    }

    @DeleteMapping("/{id}")
    public void deleteFeatureFlag(@PathVariable Long id) {
        featureFlagService.deleteFeatureFlag(id);
    }
}