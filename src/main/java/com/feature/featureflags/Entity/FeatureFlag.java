package com.feature.featureflags.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class FeatureFlag {
    @Id
    private String name;
    private boolean enabled;
    private String createdDate;
    private String lastModifiedDate;
}