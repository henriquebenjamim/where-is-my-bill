package com.bbr.whereismybill.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "orders")
@Table(name = "orders")
@SQLDelete(sql = "UPDATE order SET status = 'Canceled' WHERE id = ?")
@Where(clause = "status = 'On Progress")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("_id")
    private UUID id;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 100)
    @Column(length = 100, nullable = false)
    private String customer;

    @NotNull
    @Pattern(regexp = "[\\d]{2}", message="This field should contain two digits!")
    @Column(name = "restaurant_table")
    private int restaurantTable;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<MenuItemOrder> menuItems;

    @NotNull
    @Length(min = 3, max = 100)
    @Column(name = "serving_staff", length = 100, nullable = false)
    private String servingStaff;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    @Length(max = 12)
    @Pattern(regexp = "Canceled|On Progress|Finished")
    @Column(length = 12, nullable = false)
    private String status = "On Progress";
}


