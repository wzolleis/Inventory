package com.tim.backendapplication.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@Getter
@Setter
public final class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int categoryID;
    private int positionID;
    private int quantity;
    private int jobID;
    private String serialNumber;
    private String inventoryNumber;
    private String imageURL;
    private String occupation;

}
