package com.qldv.api.Repository;

import com.qldv.api.Model.Booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	List<Booking> findByStatus(int status);
}
