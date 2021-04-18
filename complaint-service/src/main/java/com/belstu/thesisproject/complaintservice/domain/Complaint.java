package com.belstu.thesisproject.complaintservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

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

  @Column(name = "reviewer_id", nullable = false)
  private String reviewerId;
  @Column(name = "client_id", nullable = false)
  private String clientId;

  @Enumerated(STRING)
  private ComplaintType complaintType;

  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "complaint_text", nullable = false)
  private String complaintText;
  @Column(name = "answer_text", nullable = false)
  private String answerText;

  @Column(name = "review_date")
  private LocalDate reviewDate;

  @Column(name = "creation_date", nullable = false)
  private LocalDate creationDate;
}
