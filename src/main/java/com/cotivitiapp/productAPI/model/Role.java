package com.cotivitiapp.productAPI.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    public Role(){}
    public Role(ERole name) {
        this.name = name;
    }

    @JsonIgnoreProperties("roles")
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> users;

}
