package com.belstu.thesisproject.psychouserservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient extends User {}
