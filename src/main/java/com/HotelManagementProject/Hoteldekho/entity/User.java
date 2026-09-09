package com.HotelManagementProject.Hoteldekho.entity;

import com.HotelManagementProject.Hoteldekho.entity.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Roles>roles;
    private String name;
    @Column(unique = true,nullable = true)
    private String email;
    private String password;
}
