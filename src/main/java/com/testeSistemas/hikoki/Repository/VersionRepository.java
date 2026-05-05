package com.testeSistemas.hikoki.Repository;

import com.testeSistemas.hikoki.Entity.UserEntity;
import com.testeSistemas.hikoki.Entity.VersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.DataOutput;
import java.util.Optional;

public interface VersionRepository extends JpaRepository<VersionEntity, Integer> {
    Optional<UserEntity> findByVersao(Double versao);
    boolean existsByVersao(Double versao);
}
