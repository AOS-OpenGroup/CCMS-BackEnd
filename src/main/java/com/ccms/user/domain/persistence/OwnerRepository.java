package com.ccms.user.domain.persistence;

import com.ccms.user.owner.domain.model.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByEmail(String email);
}
