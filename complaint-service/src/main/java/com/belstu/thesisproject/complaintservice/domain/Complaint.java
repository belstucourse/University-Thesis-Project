package com.belstu.thesisproject.complaintservice.domain;

import static javax.persistence.EnumType.STRING;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "complaint")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Complaint {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "complaint_id", columnDefinition = "VARCHAR(255)")
  private String id;

  private String reviewerId;
  private String clientId;

  @Enumerated(STRING)
  private ComplaintType complaintType;

  private String title;
  private String complaintText;
  private String answerText;

  private LocalDate reviewDate;
  private LocalDate creationDate;
}
