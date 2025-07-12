package com.splitwiseapplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Setter
@Getter
public class CreateExpenseDto {
    String name;
    int amount;
    Long groupId;
    Map<Long, Integer> paidBy;
    Map<Long, Integer> owedBy;
}
