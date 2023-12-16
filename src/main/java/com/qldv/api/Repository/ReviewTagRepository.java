package com.qldv.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qldv.api.Model.ReviewTag;

@Repository
public interface ReviewTagRepository extends JpaRepository<ReviewTag, Integer>{

}
