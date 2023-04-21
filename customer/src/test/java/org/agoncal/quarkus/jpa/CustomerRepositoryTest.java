package org.agoncal.quarkus.jpa;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CustomerRepositoryTest {
    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    public void testCreateAndFindAnArtist() throws SQLException {

        Customer customer = new Customer("firstName", "lastName", "bio");
        repository.persist(customer);
        assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("firstName", customer.getFirstName());
    }
}
