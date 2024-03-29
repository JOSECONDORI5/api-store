package com.josecondori.store.product.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.josecondori.store.product.models.constants.ValidationMessage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = ValidationMessage.NAME_NOT_EMPTY)
    private String name;
    private String description;

    @Positive(message = ValidationMessage.STOCK_MIN)
    private Double stock;

    private Double price;
    private String status;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @NotNull(message = ValidationMessage.CATEGORY_NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ToString.Exclude
    private Category category;
}
