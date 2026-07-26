package com.sprintBoot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="customer_name", nullable = false)
    private String customerName;

    @NotBlank
    @Column(name="customer_email", nullable = false)
    private String customerEmail;

    @NotNull
    @Column(nullable = false)
    private String status;

    @NotNull
    @Column(name="total_price", nullable = false)
    private BigDecimal totalPrice;

    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
