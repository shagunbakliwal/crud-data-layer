package com.acg.inventory.dl.service.interfaces;

import com.acg.inventory.dl.domain.UnitOfMeasurement;
import com.acg.inventory.dl.exception.UnitOfMeasurementException;

public interface IUnitOfMeasurement {

	public boolean add(UnitOfMeasurement unitOfMeasurement) throws UnitOfMeasurementException;

	public UnitOfMeasurement get(String id) throws UnitOfMeasurementException;

	public boolean update(UnitOfMeasurement unitOfMeasurement) throws UnitOfMeasurementException;
}
