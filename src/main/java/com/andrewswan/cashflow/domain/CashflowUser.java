/**
 * 
 */
package com.andrewswan.cashflow.domain;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * A {@link UserDetails} specific to this application
 * 
 * @author Admin
 */
public class CashflowUser extends User {

	// Constants
	private static final long serialVersionUID = 1L;
	
	// Properties
	private final Person person;
	
	/**
	 * Constructor
	 * 
	 * @param person can't be <code>null</code>
	 */
	public CashflowUser(final Person person) {
		super(person.getOpenId(), "ignored", person.isActivated(), true, true,
				true, person.getAuthorities());
		this.person = person;
	}
	
	/**
	 * Returns this user's full name
	 * 
	 * @return
	 */
	public String getFullName() {
		return person.getFullName();
	}
}
