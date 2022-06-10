package com.ccms.musician.service;
import com.ccms.musician.domain.model.entity.Musician;
import com.ccms.musician.domain.persistence.MusicianRepository;
import com.ccms.musician.domain.service.MusicianService;
import com.ccms.shared.exception.ResourceNotFoundException;
import com.ccms.shared.exception.ResourceValidationException;
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
    private static final String ENTITY = "Musician";
    private final MusicianRepository musicianRepository;

    private final Validator validator;
    public MusicianServiceImpl(MusicianRepository musicianRepository, Validator validator) {
        this.musicianRepository = musicianRepository;
        this.validator = validator;
    }

    @Override
    public List<Musician> getAll() {
        return musicianRepository.findAll();
    }

    @Override
    public Page<Musician> getAll(Pageable pageable) {
        return musicianRepository.findAll(pageable);
    }

    @Override
    public Musician getById(Long musicianId) {
        return musicianRepository.findById(musicianId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, musicianId));
    }

    @Override
    public Musician create(Musician musician) {
        Set<ConstraintViolation<Musician>> violations = validator.validate(musician);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Email Uniqueness validation
        Musician musicianWithEmail = musicianRepository.findByEmail(musician.getEmail());
        if (musicianWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A musician with the same email already exists.");

        return musicianRepository.save(musician);
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
