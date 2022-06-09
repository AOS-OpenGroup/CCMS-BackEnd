package com.ccms.studio.domain.persistence;

import com.ccms.studio.domain.model.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
    Studio findByEmail(String email);
}
