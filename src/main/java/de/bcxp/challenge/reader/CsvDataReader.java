package de.bcxp.challenge.reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CsvDataReader implements DataReader<String[]>{

    // Default delimiter for csv file is a comma
    private char delimiter = ',';
    /**
     *
     * @param filePath path of the input csv file
     * @return a list of string with data from csv
     */

    // Constructor for setting custom delimiter
    public CsvDataReader(char delimiter){
        this.delimiter = delimiter;
    }

    public CsvDataReader(){

    }
    @Override
    public List<String[]> readData(String filePath){

        List<String[]> allData = null;

        try{
            FileReader filereader = new FileReader(filePath);

            CSVParser csvParser = new CSVParserBuilder()
                    .withSeparator(this.delimiter)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .withCSVParser(csvParser)
                    .build();

            allData = csvReader.readAll();

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return allData;
    }

}
