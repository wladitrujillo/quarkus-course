package org.agoncal.quarkus.panache;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void testCreateAndFindAPublisher() throws SQLException {

        Publisher publisher = new Publisher("name");
        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);
        assertEquals("name", publisher.name);
    }

}
