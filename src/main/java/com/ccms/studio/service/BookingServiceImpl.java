package com.ccms.studio.service;

import com.ccms.shared.exception.ResourceNotFoundException;
import com.ccms.shared.exception.ResourceValidationException;
import com.ccms.studio.domain.model.entity.Booking;
import com.ccms.studio.domain.model.entity.Studio;
import com.ccms.studio.domain.persistence.BookingRepository;
import com.ccms.studio.domain.service.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class BookingServiceImpl implements BookingService {

    private static final String ENTITY = "Booking";
    private final BookingRepository bookingRepository;
    private final Validator validator;


    public BookingServiceImpl(BookingRepository bookingRepository, Validator validator) {
        this.bookingRepository = bookingRepository;
        this.validator = validator;
    }


    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Page<Booking> getAll(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }

    @Override
    public Booking getById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException(ENTITY,bookingId));
    }


    @Override
    public Booking create(Booking booking) {

        //Set<ConstraintViolation<Booking>> violations = validator.validate(booking);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Date Uniqueness validation
        Booking bookWithDate = bookingRepository.findByDate(booking.getDate());
        if (bookWithDate != null)
            throw new ResourceValidationException(ENTITY,
                    "A book with the same date already exists.");

        return bookingRepository.save(booking);

    }

    @Override
    public Booking update(Long bookingId, Booking request) {

        Set<ConstraintViolation<Booking>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return bookingRepository.findById(bookingId).map(booking ->
                        bookingRepository.save(booking.withDate(request.getDate()))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, bookingId)));
    }
    }

    @Override
    public ResponseEntity<?> delete(Long bookingId) {
        return bookingRepository.findById(bookingId).map(booking -> {
            bookingRepository.delete(booking);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, bookingId));
    }
}
