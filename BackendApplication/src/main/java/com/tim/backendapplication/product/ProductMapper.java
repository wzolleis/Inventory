package com.tim.backendapplication.product;

import com.tim.backendapplication.categories.CategoryDTO;
import com.tim.backendapplication.position.PositionDTO;

public class ProductMapper {
    public ProductDTO mapToDto(ProductEntity entity, String positionName, String categoryName) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(entity.getId());
        productDTO.setName(entity.getName());
        productDTO.setDescription(entity.getDescription());
        productDTO.setCategory(new CategoryDTO(entity.getCategoryID(), categoryName));
        productDTO.setPosition(new PositionDTO(entity.getPositionID(), positionName));
        productDTO.setQuantity(entity.getQuantity());
        productDTO.setJobID(entity.getJobID());
        productDTO.setSerialNumber(entity.getSerialNumber());
        productDTO.setInventoryNumber(entity.getInventoryNumber());
        productDTO.setImageURL(entity.getImageURL());
        productDTO.setOccupation(entity.getOccupation());
        return productDTO;
    }

    public ProductEntity mapToEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.getId());
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setCategoryID(productDTO.getCategory().id());
        productEntity.setPositionID(productDTO.getPosition().id());
        productEntity.setQuantity(productDTO.getQuantity());
        productEntity.setJobID(productDTO.getJobID());
        productEntity.setSerialNumber(productDTO.getSerialNumber());
        productEntity.setInventoryNumber(productDTO.getInventoryNumber());
        productEntity.setImageURL(productDTO.getImageURL());
        productEntity.setOccupation(productDTO.getOccupation());
        return productEntity;
    }
}
