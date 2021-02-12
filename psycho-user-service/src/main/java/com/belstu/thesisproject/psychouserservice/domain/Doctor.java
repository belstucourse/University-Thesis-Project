package com.belstu.thesisproject.psychouserservice.domain;

import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "doctors")
@NoArgsConstructor
@Data
public class Doctor extends User {}
