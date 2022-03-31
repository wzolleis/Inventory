package com.tim.backendapplication.options;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class OptionController {

    private final CategoryRepository categoryRepository;
    private final OptionService optionService;

    public OptionController(CategoryRepository categoryRepository, OptionService optionService) {
        this.categoryRepository = categoryRepository;
        this.optionService = optionService;
    }

    @GetMapping("/category/{id}")
    public Optional<CategoryEntity> allProducts(@PathVariable int id) {
        return categoryRepository.findById(id);
    }
    @GetMapping("/options/all")
    public OptionResponse allCategories() {
        return optionService.findOptions();
    }



}
