package com.alianza.customerManagement.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
@Entity
@Setter
@Getter
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sharedKey;
    private String name;
    private String email;
    private String phone;
    private LocalDate startDate;
    private LocalDate endDate;
}
