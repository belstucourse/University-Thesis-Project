package com.belstu.thesisproject.psychouserservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "support")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Support extends User {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_admin_id")
    private Admin admin;
}
