/**
 * 
 */
package com.andrewswan.cashflow.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.andrewswan.cashflow.domain.CashflowUser;
import com.andrewswan.cashflow.domain.Person;

/**
 * A {@link UserDetailsService} that obtains user details via JPA
 * 
 * @author Admin
 */
@Component
public class JpaUserDetailsService implements UserDetailsService {

	// Constants
	protected static final Log LOGGER =
		LogFactory.getLog(JpaUserDetailsService.class);
	
	private static final String
		// N.B. Google IDs are hostname-specific
		MY_GOOGLE_ID = "https://www.google.com/" +
			"accounts/o8/id?id=AItOawlCl-0vtR2izod5nCMWwECL7whmMtLJTy8",
		MY_VERISIGN_ID = "http://aswan.pip.verisignlabs.com/";

	@Override
	public UserDetails loadUserByUsername(final String username)
		throws UsernameNotFoundException
	{
		addTestUsers();
		try {
			final Person user = (Person)
				Person.findPeopleByOpenIdEquals(username).getSingleResult();
			return new CashflowUser(user);
		}
		catch (EmptyResultDataAccessException e) {
			throw new UsernameNotFoundException(
				"No user with an OpenID of '" + username + "'", e);
		}
	}

	private void addTestUsers() {
		LOGGER.debug("Adding test users");
		Person.add("Andrew the Admin", MY_GOOGLE_ID, true);
		Person.add("Andrew the User", MY_VERISIGN_ID, false);
	}
}
