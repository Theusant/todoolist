package com.theu.todoolist.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = User.TABLE_NAME)
public class User {

    private interface CreateUser {

    }

    private interface UpdateUser {

    }

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Column(name = "username", nullable = false, unique = false)
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    private String username;

    @Column(name = "password", nullable = false)
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    private String password;

    @OneToMany(mappedBy = "user")
    List<Task> tasks = new ArrayList<Task>();
}
