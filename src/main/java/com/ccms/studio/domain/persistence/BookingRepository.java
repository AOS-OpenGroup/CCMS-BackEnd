package com.ccms.studio.domain.persistence;

import com.ccms.studio.domain.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking>findAllByDate(String date);
}
