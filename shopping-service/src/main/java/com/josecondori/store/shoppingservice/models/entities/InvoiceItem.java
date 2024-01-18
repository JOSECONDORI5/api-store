package com.josecondori.store.shoppingservice.models.entities;

import com.josecondori.store.shoppingservice.models.constants.ValidationMessage;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "invoce_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive(message = ValidationMessage.STOCK_MIN)
    private Double quantity;
    private Double price;

    @Column(name = "product_id")
    private Long productId;


    @Transient
    private Double subTotal;


    public InvoiceItem() {
        this.quantity = (double) 0;
        this.price = (double) 0;

    }

    public Double getSubTotal() {
        if (this.price > 0 && this.quantity > 0) {
            return this.quantity * this.price;
        } else {
            return (double) 0;
        }
    }
}
