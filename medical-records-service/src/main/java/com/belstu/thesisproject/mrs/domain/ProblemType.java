package com.belstu.thesisproject.mrs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "problem_types")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProblemType {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "problem_type_id", columnDefinition = "VARCHAR(255)")
  private String id;

  private String type;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "record_type_table",
      joinColumns = {@JoinColumn(name = "problem_type_id")},
      inverseJoinColumns = {@JoinColumn(name = "medical_record_id")})
  private Set<MedicalRecord> medicalRecords;
}
