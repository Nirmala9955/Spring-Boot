package com.sahu.repo.promotions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.model.promotions.Offers;

public interface IOffersRepo extends JpaRepository<Offers, Integer> {

}
