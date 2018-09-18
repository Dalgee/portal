package com.xyz.portal.repository;

import com.xyz.portal.domain.entity.DefaultConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultConfigRepository extends JpaRepository<DefaultConfig, Long> {

}
