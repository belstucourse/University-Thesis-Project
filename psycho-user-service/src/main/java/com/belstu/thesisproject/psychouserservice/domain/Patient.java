package com.belstu.thesisproject.psychouserservice.domain;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient extends User {}
