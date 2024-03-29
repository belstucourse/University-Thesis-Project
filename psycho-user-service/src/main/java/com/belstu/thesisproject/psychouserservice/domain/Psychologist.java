package com.belstu.thesisproject.psychouserservice.domain;

import com.belstu.thesisproject.psychouserservice.updater.UserUpdater;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "psychologist")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Psychologist extends User<Psychologist> {

  @Column(name = "is_verified", nullable = false)
  private Boolean verified;

  @Column(name = "verified_date", nullable = false)
  private LocalDate verifiedDate;

  @Column(name = "mobile", length = 20)
  private String mobile;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "psychologist_client",
      joinColumns = @JoinColumn(name = "psychologist_id"),
      inverseJoinColumns = @JoinColumn(name = "client_id"))
  private Set<Client> clients;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "psychologist_tag",
      joinColumns = @JoinColumn(name = "psychologist_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private Set<Tag> tags;

  @ElementCollection
  @CollectionTable(name = "psychologist_posts", joinColumns = @JoinColumn(name = "psychologist_id"))
  private List<String> postIds;

  @Override
  public Psychologist update(final UserUpdater userUpdater, final Psychologist newUser) {
    return userUpdater.update(this, newUser);
  }
}
