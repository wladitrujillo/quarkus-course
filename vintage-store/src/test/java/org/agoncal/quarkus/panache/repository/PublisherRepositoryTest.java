package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void testCreateAndFindAPublisher() throws SQLException {

        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);
        Publisher publisher = new Publisher("name");
        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        assertEquals(count + 1, Publisher.count());

        publisher = Publisher.findById(publisher.id);
        assertEquals("name", publisher.name);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }

}
