package com.tim.backendapplication.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/product")
//    public List<ProductEntity> allProducts() {
//        return productRepository.findAll();
//    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> productByID(@PathVariable int id) {
        ProductDTO response = productService.retrieveProductResponse(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/jobid/{jobID}")
    public ResponseEntity<List<ProductDTO>> jobID(@PathVariable int jobID) {
        return ResponseEntity.ok(productService.findProductsByJobID(jobID));
    }


}
