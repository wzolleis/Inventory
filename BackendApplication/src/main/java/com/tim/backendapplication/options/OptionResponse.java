package com.tim.backendapplication.options;

import com.tim.backendapplication.position.PositionEntity;
import lombok.Getter;

import java.util.List;


@Getter
public class OptionResponse {

    private List<PositionEntity> positions;
    private List<CategoryEntity> categories;


    public OptionResponse(List<PositionEntity> positions, List<CategoryEntity> categories) {
        this.positions = positions;
        this.categories = categories;
    }
}
