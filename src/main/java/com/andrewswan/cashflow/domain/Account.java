package com.andrewswan.cashflow.domain;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import com.andrewswan.cashflow.domain.Person;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Account {

    @NotNull
    @Size(max = 40)
    private String name;

    private BigDecimal startBalance;

    @NotNull
    @ManyToOne(targetEntity = Person.class)
    @JoinColumn
    private Person owner;
}
