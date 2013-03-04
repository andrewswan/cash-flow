package com.andrewswan.cashflow.domain;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.andrewswan.cashflow.domain.RecurrenceType;
import javax.persistence.Enumerated;
import com.andrewswan.cashflow.domain.Account;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class MonetaryTransaction {
	
	@NotNull
	@Size(max = 50)
	private String description;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date nextDate;

    @NotNull
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date lastDate;

    private Integer recurrenceInterval;

    @NotNull
    @Enumerated
    private RecurrenceType recurrenceType;

    @NotNull
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn
    private Account account;
}
