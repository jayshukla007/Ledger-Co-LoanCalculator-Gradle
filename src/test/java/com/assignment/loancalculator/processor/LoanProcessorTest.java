package com.assignment.loancalculator.processor;

import com.assignment.loancalculator.extractor.Extractor;
import com.assignment.loancalculator.extractor.FileExtractor;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoanProcessorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldReadCommandsFromFileProcessLoanAndDisplayBalance(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input.txt").getFile());

        Extractor extractor = new FileExtractor();

        String extractedData = extractor.extract(file.getAbsolutePath());
        List<String> commands = Arrays.asList(extractedData.trim().split("\n"));

        LoanProcessor processor = new LoanProcessor();

        commands.stream().forEach(c -> {
            String[] data = c.split(" ");
            processor.executeCommand(data);
        });

        assertTrue(outContent.toString().replaceAll("\\n|\\r\\n", ",").contains("IDIDI Dale 1326 9,IDIDI Dale 3652 4,UON Shelly 15856 3,MBI Harry 9044 10"));
    }

}