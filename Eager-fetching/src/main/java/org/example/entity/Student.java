package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {

    @Id
    private String id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Laptop> laptop;
}