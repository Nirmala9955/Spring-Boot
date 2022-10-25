package com.sahu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {

}
