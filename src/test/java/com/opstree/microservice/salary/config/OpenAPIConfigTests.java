package com.opstree.microservice.salary.swagger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = OpenAPIConfig.class)
class OpenAPIConfigTest {

    @Test
    void testOpenAPIConfiguration() {
        // Load the Spring context and retrieve the OpenAPI bean
        OpenAPI openAPI = new OpenAPIConfig().myOpenAPI();

        // Verify that the OpenAPI object is not null
        assertNotNull(openAPI);

        // Verify the server details
        assertEquals(1, openAPI.getServers().size());
        Server server = openAPI.getServers().get(0);
        assertEquals("http://localhost:8080", server.getUrl());
        assertEquals("Server URL in Development environment", server.getDescription());

        // Verify the contact details
        Contact contact = openAPI.getInfo().getContact();
        assertEquals("opensource@opstree.com", contact.getEmail());
        assertEquals("Opstree Solutions", contact.getName());
        assertEquals("https://opstree.com", contact.getUrl());

        // Verify the license details
        License license = openAPI.getInfo().getLicense();
        assertEquals("MIT License", license.getName());
        assertEquals("https://choosealicense.com/licenses/mit/", license.getUrl());

        // Verify other general info details
        assertEquals("Salary Microservice API", openAPI.getInfo().getTitle());
        assertEquals("1.0", openAPI.getInfo().getVersion());
        assertEquals("This API exposes endpoints to manage salary information.", openAPI.getInfo().getDescription());
        assertEquals("https://www.opstree.com/terms", openAPI.getInfo().getTermsOfService());
    }
}

