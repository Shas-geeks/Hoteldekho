package com.HotelManagementProject.Hoteldekho.entity;

import com.HotelManagementProject.Hoteldekho.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String transactionId;
    private BigDecimal Price;
    @CreationTimestamp
    @Column(name="CreatedAt")
    private LocalDateTime CreatedAt;
    @UpdateTimestamp
    @Column(name="UpdatedAt")
    private LocalDateTime UpdatedAt;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

}
