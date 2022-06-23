package com.ccms.user.domain.service;

import com.ccms.user.owner.domain.model.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerService {
    List<Owner> getAll();
    Page<Owner> getAll(Pageable pageable);
    Owner getById(Long ownerId);
    Owner create(Owner owner);
    Owner update(Long ownerId, Owner request);
    ResponseEntity<?> delete(Long ownerId);
}
