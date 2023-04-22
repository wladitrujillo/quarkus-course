package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.jpa.Customer;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerRepositoryTest {
    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    public void testCreateAndFindAnArtist() throws SQLException {

        assertTrue(repository.listAllDans().size() <= repository.count());
        Customer customer = new Customer("firstName", "lastName", "bio");
        repository.persist(customer);
        assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("firstName", customer.getFirstName());
    }
}
