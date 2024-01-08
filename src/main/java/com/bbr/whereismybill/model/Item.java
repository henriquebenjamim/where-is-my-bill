package com.bbr.whereismybill.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@SQLDelete(sql = "UPDATE item SET status = 'Inactive' WHERE id = ?")
@Where(clause = "status = 'Active'")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Digits(integer = 10, fraction = 2, message = "Price must have up to 10 digits with 2 decimal places")
    @Column(nullable = false)
    private double price;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Active|Inactive")
    @Column(length = 10, nullable = false)
    private String status = "Active";
}
