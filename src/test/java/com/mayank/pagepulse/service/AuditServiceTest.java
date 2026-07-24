package com.mayank.pagepulse.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuditServiceTest {

    AuditService service = new AuditService();

    @Test
    void emptyUrlShouldThrowException() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.analyze("")
        );

        assertEquals("URL cannot be empty.", exception.getMessage());

    }

    @Test
    void nullUrlShouldThrowException() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.analyze(null)
        );

        assertEquals("URL cannot be empty.", exception.getMessage());

    }

}