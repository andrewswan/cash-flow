package com.andrewswan.cashflow.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.util.Assert;

@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findPeopleByOpenIdEquals" })
public class Person { 
	
	// Constants
	protected static final Log LOGGER = LogFactory.getLog(Person.class);

	public static final String ADMIN_ROLE = "admin";	// used as literal in JSP
	
	/**
	 * Adds a {@link Person} with the given properties, if there's not already
	 * one with the given OpenId.
	 * 
	 * @param fullName can't be blank
	 * @param openID can't be blank
	 * @param isAdmin
	 */
	public static void add(
		final String fullName, final String openID, final boolean isAdmin)
	{
		Assert.hasText(fullName, "The full name is required");
		Assert.hasText(openID, "The OpenID is required");
		final List<Person> peopleWithThisOpenID =
			Person.findPeopleByOpenIdEquals(openID).getResultList();
		if (peopleWithThisOpenID.isEmpty()) {
			final Person person = new Person();
			person.setAdministrator(isAdmin);
			person.setFullName(fullName);
			person.setOpenId(openID);
			LOGGER.debug("Creating " + person);
			person.merge();
		}
		else {
			LOGGER.debug(
				"A person already exists with OpenID = '" + openID + "'");
		}
	}
	
	private boolean administrator;

    @NotNull
    private String fullName;

    @NotNull
    private String openId;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date addedOn;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date activatedOn;

    @NotNull
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<Account>();
    
    /**
     * Returns this person's rights to this application
     * 
     * @return a non-<code>null</code> {@link Collection}
     */
    public Collection<GrantedAuthority> getAuthorities() {
		final Collection<GrantedAuthority> authorities =
			new ArrayList<GrantedAuthority>();
		if (administrator) {
			authorities.add(new GrantedAuthorityImpl(ADMIN_ROLE));
		}
    	return authorities;
    }
    
    /**
     * Indicates whether this user has been activated
     * 
     * @return see above
     */
    public boolean isActivated() {
    	return activatedOn != null;
    }
}
