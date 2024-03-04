
package com.jgm.proyectoDWES;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jgm.proyectoDWES.controller.EngineController;
import com.jgm.proyectoDWES.entities.Engine;
import com.jgm.proyectoDWES.service.EngineService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EngineControllerTest {

    @InjectMocks
    private EngineController engineController;

    @Mock
    private EngineService engineService;

    @Test
    public void testListAllEngines() {
        Page<Engine> mockPage = mock(Page.class);
        when(engineService.listAllEngines(any())).thenReturn(mockPage);

        ResponseEntity<Page<Engine>> response = engineController.listAllEngines(0, 10);

        verify(engineService).listAllEngines(any());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPage, response.getBody());
    }

    @Test
    public void testGetEngineById() {
        Engine mockEngine = mock(Engine.class);
        when(engineService.getEngineById(anyLong())).thenReturn(mockEngine);

        Engine result = engineController.getEngineById(1L);

        verify(engineService).getEngineById(1L);
        assertEquals(mockEngine, result);
    }

    @Test
    public void testAddEngine() {
        Engine mockEngine = mock(Engine.class);
        when(engineService.addEngine(any())).thenReturn(mockEngine);

        Engine result = engineController.addEngine(mockEngine);

        verify(engineService).addEngine(any());
        assertEquals(mockEngine, result);
    }

    @Test
    public void testUpdateEngine() {
        Engine mockEngine = mock(Engine.class);
        when(engineService.updateEngine(anyLong(), any())).thenReturn(mockEngine);

        Engine result = engineController.updateEngine(1L, mockEngine);

        verify(engineService).updateEngine(1L, mockEngine);
        assertEquals(mockEngine, result);
    }

    @Test
    public void testDeleteEngine() {
        engineController.deleteEngine(1L);

        verify(engineService).deleteEngine(1L);
    }
}