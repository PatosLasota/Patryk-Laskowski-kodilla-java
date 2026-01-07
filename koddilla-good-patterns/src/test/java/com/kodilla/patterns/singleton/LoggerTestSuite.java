package com.kodilla.patterns.singleton;

import com.kodilla.patterns.singelton.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        Logger logger = Logger.getInstance();
        logger.log( "Test message" );

        String result = logger.getLastLog();

        assertEquals("Test message", result);
    }


    @Test
    public void testGetInstance() {
        Logger logger = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        assertEquals(logger, logger2);
    }

    @Test
    public void testMultipleLogs() {
        Logger logger = Logger.getInstance();

        logger.log( "Test message 1" );
        logger.log( "Test message 2" );
        logger.log( "Test message 3" );
        String result = logger.getLastLog();

        assertEquals("Test message 3", result);
    }



}
