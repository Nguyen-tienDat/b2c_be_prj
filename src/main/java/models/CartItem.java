package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartItem implements Serializable {
    private Product product;
    private int quantity = 1;
}
