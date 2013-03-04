package com.andrewswan.cashflow.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.andrewswan.cashflow.domain.Person;

/**
 * Seeds the database with essential startup data
 * 
 * TODO use this class to replace that in {@link JpaUserDetailsService}
 * 
 * @author Admin
 */
@Component
@Transactional
public class DataSeederService {
	
	// Constants
	protected static final Log LOGGER =
		LogFactory.getLog(DataSeederService.class);

	private static final String
		// N.B. Google IDs are hostname-specific
		MY_GOOGLE_ID = "https://www.google.com/" +
			"accounts/o8/id?id=AItOawlCl-0vtR2izod5nCMWwECL7whmMtLJTy8",
		MY_VERISIGN_ID = "http://aswan.pip.verisignlabs.com/";

	// @PostConstruct
	void seedData() {
		LOGGER.debug("Adding seed data");
		addTestUsers();
	}
	
	/**
	 * Adds some test users to the system
	 */
	private void addTestUsers() {
		Person.add("Andrew the Admin", MY_GOOGLE_ID, true);
		Person.add("Andrew the User", MY_VERISIGN_ID, false);
		final long people = Person.countPeople();
		Assert.state(people >= 2, "Only found people x " + people);
	}
}
