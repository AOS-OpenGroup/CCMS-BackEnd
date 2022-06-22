package com.ccms.user.domain.persistence;

import com.ccms.user.domain.model.entity.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long>{
    Musician findByEmail(String email);
}
