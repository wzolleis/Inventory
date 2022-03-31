package com.tim.backendapplication.options;

import com.tim.backendapplication.position.PositionEntity;
import com.tim.backendapplication.position.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OptionService {

    private final CategoryRepository categoryRepository;
    private final PositionRepository positionRepository;

    public OptionService(CategoryRepository categoryRepository, PositionRepository positionRepository) {
        this.categoryRepository = categoryRepository;
        this.positionRepository = positionRepository;
    }


    public OptionResponse findOptions(){
        OptionResponse optionResponse = new OptionResponse(positionRepository.findAll(), categoryRepository.findAll());
        return optionResponse;



    }

}
