package com.infosys.eDoctor.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Users#Users()}
     *   <li>{@link Users#setEmail(String)}
     *   <li>{@link Users#setName(String)}
     *   <li>{@link Users#setPassword(String)}
     *   <li>{@link Users#setUsername(String)}
     *   <li>{@link Users#getEmail()}
     *   <li>{@link Users#getName()}
     *   <li>{@link Users#getPassword()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange and Act
        Users actualUsers = new Users();
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setName("Name");
        actualUsers.setPassword("iloveyou");
//        actualUsers.setUsername("Janedoe");
        String actualEmail = actualUsers.getEmail();
        String actualName = actualUsers.getName();

        // Assert that nothing has changed
        assertEquals("Name", actualName);
        assertEquals("iloveyou", actualUsers.getPassword());
        assertEquals("jane.doe@example.org", actualEmail);
    }

    /**
     * Test getters and setters.
     * <ul>
     *   <li>When {@code jane.doe@example.org}.</li>
     * </ul>
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Users#Users(String, String, String)}
     *   <li>{@link Users#setEmail(String)}
     *   <li>{@link Users#setName(String)}
     *   <li>{@link Users#setPassword(String)}
     *   <li>{@link Users#setUsername(String)}
     *   <li>{@link Users#getEmail()}
     *   <li>{@link Users#getName()}
     *   <li>{@link Users#getPassword()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters; when 'jane.doe@example.org'")
    void testGettersAndSetters_whenJaneDoeExampleOrg() {
        // Arrange and Act
        Users actualUsers = new Users();
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setName("Name");
        actualUsers.setPassword("iloveyou");
//        actualUsers.setUsername("Janedoe");
        String actualEmail = actualUsers.getEmail();
        String actualName = actualUsers.getName();

        // Assert that nothing has changed
        assertEquals("Name", actualName);
        assertEquals("iloveyou", actualUsers.getPassword());
        assertEquals("jane.doe@example.org", actualEmail);
    }
}
