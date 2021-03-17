package com.belstu.thesisproject.psychouserservice.domain;

import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patients")
@NoArgsConstructor
@Data
public class Patient extends User {}
