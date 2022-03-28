package com.tim.backendapplication.product;

import com.tim.backendapplication.categories.CategoryDTO;
import com.tim.backendapplication.position.PositionDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDTO {


    private int id;
    private String name;
    private String description;
    private CategoryDTO category;
    private PositionDTO position;
    private int quantity;
    private int jobID;
    private String serialNumber;
    private String inventoryNumber;
    private String imageURL;
    private String occupation;


}
