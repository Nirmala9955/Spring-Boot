package com.sahu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahu.document.DrivingLicense;

public interface IDrivingLicenseRepo extends MongoRepository<DrivingLicense, Long> {

}
