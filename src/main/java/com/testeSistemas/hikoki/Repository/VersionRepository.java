package com.testeSistemas.hikoki.Repository;

import com.testeSistemas.hikoki.Entity.VersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<VersionEntity, Integer> {
}
