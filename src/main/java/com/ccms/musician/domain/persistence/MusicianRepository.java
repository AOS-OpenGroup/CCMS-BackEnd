package com.ccms.musician.domain.persistence;

import com.ccms.musician.domain.model.entity.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long>{
    Musician findByEmail(String email);
}
