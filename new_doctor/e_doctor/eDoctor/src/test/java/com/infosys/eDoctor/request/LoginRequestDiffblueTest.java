package com.infosys.eDoctor.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginRequestDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link LoginRequest#LoginRequest()}
     *   <li>{@link LoginRequest#setPassword(String)}
     *   <li>{@link LoginRequest#setUserId(String)}
     *   <li>{@link LoginRequest#getPassword()}
     *   <li>{@link LoginRequest#getUserId()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange and Act
        LoginRequest actualLoginRequest = new LoginRequest();
        actualLoginRequest.setPassword("iloveyou");
        actualLoginRequest.setUserId("42");
        String actualPassword = actualLoginRequest.getPassword();

        // Assert that nothing has changed
        assertEquals("42", actualLoginRequest.getUserId());
        assertEquals("iloveyou", actualPassword);
    }

    /**
     * Test getters and setters.
     * <ul>
     *   <li>When {@code 42}.</li>
     * </ul>
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link LoginRequest#LoginRequest(String, String, String)}
     *   <li>{@link LoginRequest#setPassword(String)}
     *   <li>{@link LoginRequest#setUserId(String)}
     *   <li>{@link LoginRequest#getPassword()}
     *   <li>{@link LoginRequest#getUserId()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters; when '42'")
    void testGettersAndSetters_when42() {
        // Arrange and Act
        LoginRequest actualLoginRequest = new LoginRequest("42", "iloveyou","doctor");
        actualLoginRequest.setPassword("iloveyou");
        actualLoginRequest.setUserId("42");
        String actualPassword = actualLoginRequest.getPassword();

        // Assert that nothing has changed
        assertEquals("42", actualLoginRequest.getUserId());
        assertEquals("iloveyou", actualPassword);
    }
}
