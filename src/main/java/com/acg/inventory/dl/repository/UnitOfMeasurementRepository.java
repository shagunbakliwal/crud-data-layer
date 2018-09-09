package com.acg.inventory.dl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.acg.inventory.dl.domain.UnitOfMeasurement;

public interface UnitOfMeasurementRepository extends MongoRepository<UnitOfMeasurement, String> {

	public UnitOfMeasurement findByName(String name);

}
