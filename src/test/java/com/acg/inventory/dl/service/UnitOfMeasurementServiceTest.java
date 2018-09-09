package com.acg.inventory.dl.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.acg.inventory.dl.domain.UnitOfMeasurement;
import com.acg.inventory.dl.exception.UnitOfMeasurementException;
import com.acg.inventory.dl.repository.UnitOfMeasurementRepository;

public class UnitOfMeasurementServiceTest {

	@InjectMocks
	UnitOfMeasurementService unitOfMeasurementService;

	@Mock
	UnitOfMeasurementRepository unitOfMeasurementRepository;

	private UnitOfMeasurement unitOfMeasurement;

	@Before
	public void setUp() throws Exception {
		Mockito.mock(Mockito.class);
		MockitoAnnotations.initMocks(this);
		unitOfMeasurement = new UnitOfMeasurement();
		unitOfMeasurement.setId("1");
		unitOfMeasurement.setName("Kg");
	}

	@Test
	public void addUOM() throws UnitOfMeasurementException {
		Mockito.when(unitOfMeasurementRepository.findById(Mockito.any(String.class)))
				.thenReturn(Optional.ofNullable(unitOfMeasurement));
		assertTrue(unitOfMeasurementService.add(unitOfMeasurement));
	}

	@Test
	public void getUOM() throws UnitOfMeasurementException {
		Mockito.when(unitOfMeasurementRepository.findById(Mockito.any(String.class)))
				.thenReturn(Optional.ofNullable(unitOfMeasurement));
		assertEquals(unitOfMeasurement, unitOfMeasurementService.get("1"));
	}

	@Test
	public void updateUOM() throws UnitOfMeasurementException {
		Mockito.when(unitOfMeasurementRepository.findById(Mockito.any(String.class)))
				.thenReturn(Optional.ofNullable(unitOfMeasurement));
		assertTrue(unitOfMeasurementService.update(unitOfMeasurement));
	}

}
