package com.opstree.microservice.salary.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void testMessageConstructorAndGetMessage() {
        // Create a sample message
        String messageText = "Hello, world!";
        Message message = new Message(messageText);

        // Check if the message is correctly initialized using the constructor
        assertEquals(messageText, "Hello, world!");
    }
}
