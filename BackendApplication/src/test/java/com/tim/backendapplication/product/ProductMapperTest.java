package com.tim.backendapplication.product;

import com.tim.backendapplication.position.PositionDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    @Test
    void mapToDto() {
        ProductMapper underTest = new ProductMapper();
        ProductEntity entity = new ProductEntity();
        entity.setPositionID(5);
        entity.setDescription("aDescription");
        ProductDTO result = underTest.mapToDto(entity, "lager_test", "category_test");
        assertEquals(entity.getDescription(), result.getDescription());
        assertEquals(new PositionDTO(entity.getPositionID(), "lager_test"), result.getPosition());
    }
}