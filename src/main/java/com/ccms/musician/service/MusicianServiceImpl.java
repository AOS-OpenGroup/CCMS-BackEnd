package com.ccms.musician.service;
import com.ccms.musician.domain.model.entity.Musician;
import com.ccms.musician.domain.persistence.MusicianRepository;
import com.ccms.musician.domain.service.MusicianService;
import com.ccms.studio.domain.persistence.StudioRepository;
import com.ccms.studio.domain.service.StudioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class MusicianServiceImpl implements MusicianService {
    private static final String ENTITY = "Musicians";
    private final MusicianRepository musicianRepository;

    private final Validator validator;
    public MusicianServiceImpl(MusicianRepository musicianRepository, Validator validator) {
        this.musicianRepository = musicianRepository;
        this.validator = validator;
    }


    @Override
    public List<Musician> getAll() {
        return null;
    }

    @Override
    public Page<Musician> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Musician getById(Long musicianId) {
        return null;
    }

    @Override
    public Musician create(Musician musician) {
        return null;
    }

    @Override
    public Musician update(Long musicianId, Musician request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long musicianId) {
        return null;
    }
}
