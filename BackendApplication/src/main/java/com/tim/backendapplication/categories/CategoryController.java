package com.tim.backendapplication.categories;


import com.tim.backendapplication.product.ProductEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category/{id}")
    public Optional<CategoryEntity> allProducts(@PathVariable int id) {
        return categoryRepository.findById(id);
    }
}
