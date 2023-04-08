package de.bcxp.challenge.reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvDataReader implements DataReader<String[]> {
    private static final Logger logger = LogManager.getLogger(CsvDataReader.class);
    // Default delimiter for csv file is a comma
    private char delimiter = ',';
    private int withSkipLines = 1;


    // Constructor for setting custom delimiter
    public CsvDataReader(char delimiter, int withSkipLines) {

        this.delimiter = delimiter;
        this.withSkipLines = withSkipLines;
    }


    public CsvDataReader() {

    }


    @Override
    public List<String[]> readData(String filePath) {

        List<String[]> allData = null;

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                logger.error("File not found: " + filePath);
                return null;
            }
            if (!file.canRead()) {
                logger.error("File is not readable: " + filePath);
                return null;
            }


            FileReader filereader = new FileReader(filePath);

            CSVParser csvParser = new CSVParserBuilder()
                    .withSeparator(this.delimiter)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(withSkipLines)
                    .withCSVParser(csvParser)
                    .build();

            allData = csvReader.readAll();

        } catch (FileNotFoundException e) {
            logger.error("File not found: " + filePath);
        } catch (IOException e) {
            logger.error("Error when reading file: " + filePath);
        } catch (CsvException e) {
            logger.error("Error when parsing CSV file: " + filePath);
        }

        return allData;
    }

}
