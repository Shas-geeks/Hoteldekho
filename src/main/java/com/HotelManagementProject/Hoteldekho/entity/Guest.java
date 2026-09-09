package com.HotelManagementProject.Hoteldekho.entity;

import com.HotelManagementProject.Hoteldekho.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @CreationTimestamp
    @Column(name="CreatedAt")
    private LocalDateTime CreatedAt;


}
