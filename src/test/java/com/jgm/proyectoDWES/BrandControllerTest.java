package com.jgm.proyectoDWES;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jgm.proyectoDWES.controller.BrandController;
import com.jgm.proyectoDWES.entities.Brand;
import com.jgm.proyectoDWES.service.BrandService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BrandControllerTest {

    @InjectMocks
    private BrandController brandController;

    @Mock
    private BrandService brandService;

    @Test
    public void testListAllBrands() {
        Page<Brand> mockPage = mock(Page.class);
        when(brandService.listAllBrands(any())).thenReturn(mockPage);

        ResponseEntity<Page<Brand>> response = brandController.listAllBrands(0, 10);

        verify(brandService).listAllBrands(any());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPage, response.getBody());
    }

    @Test
    public void testGetBrandById() {
        Brand mockBrand = mock(Brand.class);
        when(brandService.getBrandById(anyLong())).thenReturn(mockBrand);

        Brand result = brandController.getBrandById(1L);

        verify(brandService).getBrandById(1L);
        assertEquals(mockBrand, result);
    }

    @Test
    public void testAddBrand() {
        Brand mockBrand = mock(Brand.class);
        when(brandService.addBrand(any())).thenReturn(mockBrand);

        Brand result = brandController.addBrand(mockBrand);

        verify(brandService).addBrand(any());
        assertEquals(mockBrand, result);
    }

    @Test
    public void testUpdateBrand() {
        Brand mockBrand = mock(Brand.class);
        when(brandService.updateBrand(anyLong(), any())).thenReturn(mockBrand);

        Brand result = brandController.updateBrand(1L, mockBrand);

        verify(brandService).updateBrand(1L, mockBrand);
        assertEquals(mockBrand, result);
    }

    @Test
    public void testDeleteBrand() {
        brandController.deleteBrand(1L);

        verify(brandService).deleteBrand(1L);
    }
}