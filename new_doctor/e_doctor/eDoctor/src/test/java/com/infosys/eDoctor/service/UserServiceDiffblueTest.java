package com.infosys.eDoctor.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import com.infosys.eDoctor.entity.Users;
import com.infosys.eDoctor.repository.UsersRepo;
import com.infosys.eDoctor.request.LoginRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class, UsersRepo.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserServiceDiffblueTest {
    @MockBean
    private UsersRepo usersRepo;

    @Autowired
    private UserService userService;

    /**
     * Test {@link UserService#addUser(Users)}.
     * <p>
     * Method under test: {@link UserService#addUser(Users)}
     */
    @Test
    @DisplayName("Test addUser(Users)")
    void testAddUser() {
        // Arrange
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");

        Users user = new Users();
        user.setEmail("jane.doe@example.org");
        user.setName("Name");
        user.setPassword("iloveyou");

        // Act
        Users actualAddUserResult = userService.addUser(user);

        // Assert
        assertSame(users, actualAddUserResult);
    }

    /**
     * Test {@link UserService#loginUser(LoginRequest)}.
     * <p>
     * Method under test: {@link UserService#loginUser(LoginRequest)}
     */
    @Test
    @DisplayName("Test loginUser(LoginRequest)")
    @Disabled("TODO: Complete this test")
    void testLoginUser() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@506c134a testClass = com.infosys.eDoctor.service.DiffblueFakeClass213, locations = [], classes = [com.infosys.eDoctor.service.UserService, com.infosys.eDoctor.reposatory.UsersRepo], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@13721844, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@2a6b5c48, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.reactor.netty.DisableReactorResourceFactoryGlobalResourcesContextCustomizerFactory$DisableReactorResourceFactoryGlobalResourcesContextCustomizerCustomizer@3f503098, org.springframework.boot.test.autoconfigure.OnFailureConditionReportContextCustomizerFactory$OnFailureConditionReportContextCustomizer@2f6f058, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@3be552bf], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        userService.loginUser(new LoginRequest("42", "iloveyou","doctor"));
    }

}
