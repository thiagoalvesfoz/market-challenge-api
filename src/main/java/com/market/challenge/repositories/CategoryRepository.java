package com.market.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.challenge.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
