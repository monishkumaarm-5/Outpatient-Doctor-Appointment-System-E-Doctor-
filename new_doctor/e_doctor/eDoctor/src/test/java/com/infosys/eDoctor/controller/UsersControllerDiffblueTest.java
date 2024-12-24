package com.infosys.eDoctor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.eDoctor.entity.Users;
import com.infosys.eDoctor.repository.UsersRepo;
import com.infosys.eDoctor.request.LoginRequest;
import com.infosys.eDoctor.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UsersController.class, UserService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UsersControllerDiffblueTest {
    @MockBean
    private UsersRepo usersRepo;

    @MockBean
    private UserService userService;

    @Autowired
    private UsersController usersController;

    /**
     * Test {@link UsersController#addUser(Users)}.
     * <p>
     * Method under test: {@link UsersController#addUser(Users)}
     */
    @Test
    @DisplayName("Test addUser(Users)")
    void testAddUser() throws Exception {
        // Arrange
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("password");

        Users users2 = new Users();
        users2.setEmail("jane.doe@example.org");
        users2.setName("Name");
        users2.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(users2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"email\":\"jane.doe@example.org\",\"name\":\"Name\",\"password\":\"iloveyou\"}"));
    }

    /**
     * Test {@link UsersController#loginUser(LoginRequest)}.
     * <p>
     * Method under test: {@link UsersController#loginUser(LoginRequest)}
     */
    @Test
    @DisplayName("Test loginUser(LoginRequest)")
    @Disabled("TODO: Complete this test")
    void testLoginUser() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@68b5e5d1 testClass = com.infosys.eDoctor.controller.DiffblueFakeClass221, locations = [], classes = [com.infosys.eDoctor.controller.UsersController, com.infosys.eDoctor.service.UserService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@284dc2ae, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@18b11b2f, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.reactor.netty.DisableReactorResourceFactoryGlobalResourcesContextCustomizerFactory$DisableReactorResourceFactoryGlobalResourcesContextCustomizerCustomizer@5865b55d, org.springframework.boot.test.autoconfigure.OnFailureConditionReportContextCustomizerFactory$OnFailureConditionReportContextCustomizer@698f0732, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@12fa8e51], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUserId("42");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/loginUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(usersController).build().perform(requestBuilder);
    }

}
