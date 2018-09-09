package com.acg.inventory.dl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acg.inventory.dl.domain.UnitOfMeasurement;
import com.acg.inventory.dl.error.ErrorCodes;
import com.acg.inventory.dl.exception.UnitOfMeasurementException;
import com.acg.inventory.dl.repository.UnitOfMeasurementRepository;
import com.acg.inventory.dl.service.interfaces.IUnitOfMeasurement;
import com.acg.utilities.ObjectUtilities;

@Service
public class UnitOfMeasurementService implements IUnitOfMeasurement {

	@Autowired
	UnitOfMeasurementRepository unitOfMeasurementRepository;

	@Override
	public boolean add(UnitOfMeasurement unitOfMeasurement) throws UnitOfMeasurementException {
		if (ObjectUtilities.isNull(unitOfMeasurement)) {
			throw new UnitOfMeasurementException(ErrorCodes.UnitOfMeasurementCode.NULL.getCode(),
					ErrorCodes.UnitOfMeasurementCode.NULL.getValue());

		}
		if (unitOfMeasurementRepository.findByName(unitOfMeasurement.getName()) != null) {
			throw new UnitOfMeasurementException(ErrorCodes.UnitOfMeasurementCode.DUPLICATE.getCode(),
					ErrorCodes.UnitOfMeasurementCode.DUPLICATE.getValue());
		}
		unitOfMeasurementRepository.insert(unitOfMeasurement);
		return true;
	}

	@Override
	public UnitOfMeasurement get(String id) throws UnitOfMeasurementException {
		Optional<UnitOfMeasurement> unitOfMeasurement = unitOfMeasurementRepository.findById(id);
		if (!unitOfMeasurement.isPresent()) {
			throw new UnitOfMeasurementException(ErrorCodes.UnitOfMeasurementCode.INVALID.getCode(),
					ErrorCodes.UnitOfMeasurementCode.INVALID.getValue());
		}
		return unitOfMeasurement.get();
	}

	@Override
	public boolean update(UnitOfMeasurement unitOfMeasurement) throws UnitOfMeasurementException {
		if (ObjectUtilities.isNull(unitOfMeasurement)) {
			throw new UnitOfMeasurementException(ErrorCodes.UnitOfMeasurementCode.NULL.getCode(),
					ErrorCodes.UnitOfMeasurementCode.NULL.getValue());
		}
		Optional<UnitOfMeasurement> unitOfMeasurementDb = unitOfMeasurementRepository
				.findById(unitOfMeasurement.getId());
		if (!unitOfMeasurementDb.isPresent()) {
			throw new UnitOfMeasurementException(ErrorCodes.UnitOfMeasurementCode.INVALID.getCode(),
					ErrorCodes.UnitOfMeasurementCode.INVALID.getValue());
		}
		unitOfMeasurementDb.get().setName(unitOfMeasurement.getName());
		unitOfMeasurementRepository.save(unitOfMeasurementDb.get());
		return true;
	}
}
