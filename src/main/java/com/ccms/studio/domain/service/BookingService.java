package com.ccms.studio.domain.service;

import com.ccms.studio.domain.model.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {
    List<Booking> getAll();
    Page<Booking> getAll(Pageable pageable);
    Booking getById(Long bookingId);
    Booking create(Booking booking);
    Booking update(Long studentId, Booking request);
    ResponseEntity<?> delete(Long bookingId);
}
