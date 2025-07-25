package com.splitwiseapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense extends BaseModel{
   @ManyToOne
   @JoinColumn(name = "group_id")
   Group group;

   String name;

   int amount;

   @OneToMany(fetch = FetchType.EAGER)
   List<UserExpense> paidBy;

   @OneToMany(fetch = FetchType.EAGER)
   List<UserExpense> owedBy;


}