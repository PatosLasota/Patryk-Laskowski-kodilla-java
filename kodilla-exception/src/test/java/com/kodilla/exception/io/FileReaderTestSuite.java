package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileReaderTestSuite {

    @Test
    void testReadExistingFile() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertDoesNotThrow(() -> fileReader.readFile("names.txt"));
    }

    @Test
    void testReadNonExistingFileShouldThrowException() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt"));
    }

    @Test
    void testReadFileWithNullNameUsesDefaultFile() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertDoesNotThrow(() -> fileReader.readFile(null));
    }
}