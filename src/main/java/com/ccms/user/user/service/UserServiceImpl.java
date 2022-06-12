package com.ccms.user.user.service;
import com.ccms.shared.exception.ResourceNotFoundException;
import com.ccms.shared.exception.ResourceValidationException;
import com.ccms.user.user.domain.model.entity.User;
import com.ccms.user.user.domain.persistence.UserRepository;
import com.ccms.user.user.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


@Service

public class UserServiceImpl implements UserService {

    private static final String ENTITY = "User";
    private final UserRepository userRepository;
    private final Validator validator;
    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Email Uniqueness validation
        User userWithEmail = userRepository.findByEmail(user.getEmail());
        if (userWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A musician with the same email already exists.");

        return userRepository.save(user);
    }

    @Override
    public User update(Long userId, User request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return null;
    }
}
