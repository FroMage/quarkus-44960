package org.acme.test;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MyTest {

	@Inject
	Session session;
	
	@Test
	public void query() {
		// works
		session.createQuery("select distinct e from MyEntity e order by e.field").getResultList();
	}

	@Test
	public void countQuery() {
		// does not work
		session.createQuery("select distinct e from MyEntity e order by e.field").getResultCount();
	}

}
