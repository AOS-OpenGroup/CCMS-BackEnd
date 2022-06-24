package com.ccms.users.owner.service;
import com.ccms.shared.exception.ResourceNotFoundException;
import com.ccms.shared.exception.ResourceValidationException;
import com.ccms.users.owner.domain.model.entity.Owner;
import com.ccms.users.owner.domain.persistence.OwnerRepository;
import com.ccms.users.owner.domain.service.OwnerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceImpl implements OwnerService {
    private static final String ENTITY = "Owner";
    private final OwnerRepository ownerRepository;
    private final Validator validator;

    public OwnerServiceImpl(OwnerRepository ownerRepository, Validator validator ) {
        this.ownerRepository = ownerRepository;
        this.validator = validator;
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Page<Owner> getAll(Pageable pageable) {
        return ownerRepository.findAll(pageable);
    }

    @Override
    public Owner getById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, ownerId));
    }

    @Override
    public Owner create(Owner owner) {
        Set<ConstraintViolation<Owner>> violations = validator.validate(owner);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Email Uniqueness validation
        Owner ownerWithEmail = ownerRepository.findByEmail(owner.getEmail());
        if (ownerWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A owner with the same email already exist.");

        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Long ownerId, Owner request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long ownerId) {
        return null;
    }
}
