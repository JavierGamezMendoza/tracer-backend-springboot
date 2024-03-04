package com.jgm.proyectoDWES;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jgm.proyectoDWES.controller.VehicleController;
import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.service.VehicleService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {

    @InjectMocks
    private VehicleController vehicleController;

    @Mock
    private VehicleService vehicleService;

    @Test
    public void testListAllVehicles() {
        Page<Vehicle> mockPage = mock(Page.class);
        when(vehicleService.listAllVehicles(any())).thenReturn(mockPage);

        ResponseEntity<Page<Vehicle>> response = vehicleController.listAllVehicles(0, 10);

        verify(vehicleService).listAllVehicles(any());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPage, response.getBody());
    }

    @Test
    public void testGetVehicleById() {
        Vehicle mockVehicle = mock(Vehicle.class);
        when(vehicleService.getVehicleById(anyLong())).thenReturn(mockVehicle);

        Vehicle result = vehicleController.getVehicleById(1L);

        verify(vehicleService).getVehicleById(anyLong());
        assertEquals(mockVehicle, result);
    }

    @Test
    public void testGetVehicleByModel() {
        Vehicle mockVehicle = mock(Vehicle.class);
        when(vehicleService.getVehicleByModel(anyString())).thenReturn(mockVehicle);

        Vehicle result = vehicleController.getVehicleByModel("TestModel");

        verify(vehicleService).getVehicleByModel(anyString());
        assertEquals(mockVehicle, result);
    }

    @Test
    public void testAddVehicle() {
        Vehicle mockVehicle = mock(Vehicle.class);
        when(vehicleService.addVehicle(any())).thenReturn(mockVehicle);

        Vehicle result = vehicleController.addVehicle(new Vehicle());

        verify(vehicleService).addVehicle(any());
        assertEquals(mockVehicle, result);
    }

    @Test
    public void testUpdateVehicle() {
        Vehicle mockVehicle = mock(Vehicle.class);
        when(vehicleService.updateVehicle(anyLong(), any())).thenReturn(mockVehicle);

        Vehicle result = vehicleController.updateVehicle(1L, new Vehicle());

        verify(vehicleService).updateVehicle(anyLong(), any());
        assertEquals(mockVehicle, result);
    }

    @Test
    public void testDeleteVehicle() {
        vehicleController.deleteVehicle(1L);

        verify(vehicleService).deleteVehicle(anyLong());
    }
}
