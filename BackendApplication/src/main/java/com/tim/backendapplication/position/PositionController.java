package com.tim.backendapplication.position;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class PositionController {

    private final PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping("/position/{id}")
    public Optional<PositionEntity> allProducts(@PathVariable int id) {
        return positionRepository.findById(id);
    }

    @GetMapping("/position/all")
    public List<PositionEntity> allPositions() {
        return positionRepository.findAll();
    }
}
