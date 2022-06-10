package com.ccms.studio.domain.service;

import com.ccms.studio.domain.model.entity.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudioService {
    List<Studio> getAll();
    Page<Studio> getAll(Pageable pageable);
    Studio getById(Long studioId);
    Studio create(Studio studio);
    Studio update(Long studioId, Studio request);
    ResponseEntity<?> delete(Long studioId);
}
