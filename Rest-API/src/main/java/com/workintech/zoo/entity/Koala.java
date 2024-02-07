package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Koala {
    private Long id;
    private String name;
    private double weight;
    private int sleepHour;
    private String gender;
}
