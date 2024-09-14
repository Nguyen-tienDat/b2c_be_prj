package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private int categoryId;
    private String path;


}
