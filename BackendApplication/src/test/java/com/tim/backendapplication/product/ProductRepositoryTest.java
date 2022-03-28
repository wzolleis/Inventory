package com.tim.backendapplication.product;

import com.tim.backendapplication.BackendApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = BackendApplication.class)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository underTest;

    @Test
    public void givenProductEntityRepository_whenSaveAndRetrieveEntity_thenOK() {
        ProductEntity product = new ProductEntity();
        product.setDescription("aDescription");
        ProductEntity productEntity = underTest.save(product);
        Optional<ProductEntity> foundEntity = underTest.findById(productEntity.getId());
        assertThat(foundEntity.isPresent()).isTrue();
        assertNotNull(foundEntity.get());
        foundEntity.ifPresent(x -> assertThat(x.getDescription()).isEqualTo(productEntity.getDescription()));
    }
}
