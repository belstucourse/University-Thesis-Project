package com.belstu.thesisproject.psychouserservice.domain;

import com.belstu.thesisproject.psychouserservice.updater.UserUpdater;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "support")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Support extends User<Support> {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_admin_id")
  private Admin admin;

  @Override
  public Support update(final UserUpdater userUpdater, final Support newUser) {
    return userUpdater.update(this, newUser);
  }
}
