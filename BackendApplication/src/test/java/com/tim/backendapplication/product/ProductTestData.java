package com.tim.backendapplication.product;

import org.apache.commons.lang3.RandomStringUtils;

import static com.tim.testutils.RandomValues.randomInt;
import static com.tim.testutils.RandomValues.randomString;

public abstract class ProductTestData {
    public static ProductEntity randomProductEntity(int id) {
        ProductEntity entity = randomProductEntity();
        entity.setId(id);
        return entity;
    }

    public static ProductDTO randomProductDTO(int id) {
        ProductEntity entity = randomProductEntity();
        ProductDTO dto = new ProductMapper().mapToDto(entity, "aPositionName", "aCategoryName");
        dto.setId(id);
        return dto;
    }

    public static ProductEntity randomProductEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setId(randomInt(100));
        entity.setDescription(randomString(5));
        entity.setPositionID(randomInt(100));
        entity.setCategoryID(randomInt(100));
        entity.setJobID(randomInt(100));
        entity.setInventoryNumber(RandomStringUtils.randomNumeric(10));
        entity.setOccupation(randomString(10));
        entity.setImageURL(randomString(10));
        entity.setSerialNumber(randomString(10));
        return entity;
    }
}
