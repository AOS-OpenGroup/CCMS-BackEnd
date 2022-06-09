package com.ccms.studio.service;

import com.ccms.shared.exception.ResourceNotFoundException;
import com.ccms.shared.exception.ResourceValidationException;
import com.ccms.studio.domain.model.entity.Studio;
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
public class StudioServiceImpl implements StudioService {
    private static final String ENTITY = "Studios";
    private final StudioRepository studioRepository;

    private final Validator validator;

    public StudioServiceImpl(StudioRepository studioRepository, Validator validator) {
        this.studioRepository = studioRepository;
        this.validator = validator;
    }


    @Override
    public List<Studio> getAll() {
        return studioRepository.findAll();
    }

    @Override
    public Page<Studio> getAll(Pageable pageable) {
        return studioRepository.findAll(pageable);
    }

    @Override
    public Studio getById(Long studioId) {
        return studioRepository.findById(studioId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, studioId));
    }

    //missing override functions
    @Override
    public Studio create(Studio studio) {

        Set<ConstraintViolation<Studio>> violations = validator.validate(studio);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Email Uniqueness validation
        Studio studioWithEmail = studioRepository.findByEmail(studio.getEmail());
        if (studioWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A studio with the same email already exists.");

        return studioRepository.save(studio);
    }

    @Override
    public Studio update(Long studioId, Studio request) {
        Set<ConstraintViolation<Studio>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return studioRepository.findById(studioId).map(studio ->
                        studioRepository.save(studio.withName(request.getName())
                                .withAddress(request.getAddress())
                                .withEmail(request.getEmail())
                                .withDescription(request.getDescription())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, studioId));
    }

    @Override
    public ResponseEntity<?> delete(Long studioId) {
        return studioRepository.findById(studioId).map(studio -> {
            studioRepository.delete(studio);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, studioId));
    }
}
