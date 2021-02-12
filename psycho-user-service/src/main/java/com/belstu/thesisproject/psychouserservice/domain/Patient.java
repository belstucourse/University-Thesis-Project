package com.belstu.thesisproject.psychouserservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "patients")
@NoArgsConstructor
@Data
public class Patient extends User {}
