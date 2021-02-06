package com.belstu.thesisproject.psychouserservice.domain;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor extends User {}
