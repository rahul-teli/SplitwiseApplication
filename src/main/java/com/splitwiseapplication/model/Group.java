package com.splitwiseapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "splitwisegroup")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group extends BaseModel {
    String name;
    @ManyToMany
    List<User> users;


}
