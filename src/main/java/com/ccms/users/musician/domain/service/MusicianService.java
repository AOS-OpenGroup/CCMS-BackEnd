package com.ccms.users.musician.domain.service;

import com.ccms.users.musician.domain.model.entity.Musician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MusicianService {
    List<Musician> getAll();
    Page<Musician> getAll(Pageable pageable);
    Musician getById(Long musicianId);
    Musician create(Musician musician);
    Musician update(Long musicianId, Musician request);
    ResponseEntity<?> delete(Long musicianId);
}
