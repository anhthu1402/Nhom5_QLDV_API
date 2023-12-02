package com.qldv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qldv.api.model.ReviewTag;

@Repository
public interface ReviewTagRepository extends JpaRepository<ReviewTag, Integer>{

}
