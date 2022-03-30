package com.tim.backendapplication.product;

import com.tim.backendapplication.categories.CategoryDTO;
import com.tim.backendapplication.position.PositionDTO;
import org.junit.jupiter.api.Test;

import static com.tim.backendapplication.product.ProductTestData.randomProductEntity;
import static com.tim.testutils.RandomValues.randomInt;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    @Test
    void givenEntityMapsToDtoThenLabelShouldBeSet() {
        ProductMapper underTest = new ProductMapper();
        ProductEntity productEntity = randomProductEntity();
        ProductDTO result = underTest.mapToDto(productEntity, "lager_test", "category_test");
        assertEquals(new PositionDTO(productEntity.getPositionID(), "lager_test"), result.getPosition());
        assertEquals(new CategoryDTO(productEntity.getCategoryID(), "category_test"), result.getCategory());
    }

    @Test
    void givenEntityMapsToDtaAndBackThenResultShouldEqualInput() {
        ProductMapper underTest = new ProductMapper();
        ProductEntity productEntity = randomProductEntity();
        ProductDTO productDTO = underTest.mapToDto(productEntity, "lager_test", "category_test");
        ProductEntity result = underTest.mapToEntity(productDTO);
        assertThat(result).isEqualTo(productEntity);
    }
}
