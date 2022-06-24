package com.ccms.users.musician.domain.persistence;

import com.ccms.users.musician.domain.model.entity.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long>{
    Musician findByEmail(String email);
}
