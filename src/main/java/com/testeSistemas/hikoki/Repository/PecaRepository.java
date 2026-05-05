package com.testeSistemas.hikoki.Repository;

import com.testeSistemas.hikoki.Entity.PecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecaRepository extends JpaRepository<PecaEntity, Integer> {
}
