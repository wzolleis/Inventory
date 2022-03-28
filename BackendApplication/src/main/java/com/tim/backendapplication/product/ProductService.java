package com.tim.backendapplication.product;

import com.tim.backendapplication.categories.CategoryRepository;
import com.tim.backendapplication.position.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PositionRepository positionRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, PositionRepository positionRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.positionRepository = positionRepository;
        this.productMapper = productMapper;
    }

    public ProductEntity getProduct(int productId) {
        return productRepository.getById(productId);
    }

    public String getCategoryString(int categoryId) {
        return categoryRepository.getById(categoryId).getName();

    }

    public String getPositionString(int positionId) {
        return positionRepository.getById(positionId).getName();
    }

    public List<ProductDTO> findProductsByJobID(int jobId) {
        List<ProductEntity> entities = productRepository.findByJobID(jobId);
        return entities.stream().map(this::convertToProductDTO).collect(Collectors.toList());

    }

    public ProductDTO retrieveProductResponse(int productId) {
        ProductEntity entity = getProduct(productId);
        ProductDTO product = convertToProductDTO(entity);
        return product;
    }

    private ProductDTO convertToProductDTO(ProductEntity entity) {
        String categoryName = getCategoryString(entity.getCategoryID());
        String positionName = getPositionString(entity.getPositionID());
        return productMapper.mapToDto(entity, positionName, categoryName);
    }


}
