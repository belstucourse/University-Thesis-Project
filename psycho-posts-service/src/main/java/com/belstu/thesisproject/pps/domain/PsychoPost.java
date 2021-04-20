package com.belstu.thesisproject.pps.domain;

import static java.time.LocalDate.now;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "posts")
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PsychoPost {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private String id;

  @Column(name = "author_id", length = 100, nullable = false)
  private String authorId;

  @Column(name = "title", length = 100, nullable = false)
  private String title;

  @Column(name = "text", columnDefinition = "TEXT", nullable = false)
  private String text;

  @Column(name = "post_date", nullable = false)
  private LocalDate postDate;

  @PrePersist
  protected void onCreate() {
    postDate = now();
  }
}
