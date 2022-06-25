package com.ccms.reviews.domain.persistence;

import com.ccms.reviews.domain.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    //List<Review> findByStudioId(Long studioId);
}
