package com.josecondori.store.customerservice.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.josecondori.store.customerservice.models.constants.ValidationMessage;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "customers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = ValidationMessage.DOCUMENT_NOT_EMPTY)
    @Size(min = 8, max = 8, message = ValidationMessage.DOCUMENT_LENGTH)
    @Column(name = "number_id", unique = true, length = 8, nullable = false)
    private String numberId;

    @NotEmpty(message = ValidationMessage.FIRSTNAME_NOT_EMPTY)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = ValidationMessage.LASTNAME_NOT_EMPTY)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = ValidationMessage.EMAIL_NOT_EMPTY)
    @Email(message = ValidationMessage.EMAIL_INVALID)
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @NotNull(message = ValidationMessage.REGION_NOT_EMPTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    private String state;

}
