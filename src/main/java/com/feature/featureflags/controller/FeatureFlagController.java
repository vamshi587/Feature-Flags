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
    @GetMapping("/{name}")
    public FeatureFlag getFlagById(@PathVariable String name) {
        return featureFlagService.getFlagById(name);
    }
    @PostMapping
    public FeatureFlag createFeatureFlag(@RequestBody FeatureFlag featureFlag) {
        return featureFlagService.createFeatureFlag(featureFlag);
    }

    @PutMapping
    public FeatureFlag updateFeatureFlag(@RequestParam String name, @RequestParam Boolean enabled) {
        return featureFlagService.updateFeatureFlag(name, enabled);
    }

    @DeleteMapping("/{name}")
    public void deleteFeatureFlag(@PathVariable String name) {
        featureFlagService.deleteFeatureFlag(name);
    }
}