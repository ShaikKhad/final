package com.jsp.newcurdoperation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Page<CheckIn> findByCheckInDateContaining(String checkInDate, Pageable pageable);
}