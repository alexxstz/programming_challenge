package de.bcxp.challenge.reader;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CsvDataReader implements DataReader<String[]>{


    /**
     *
     * @param filePath path of the input csv file
     * @return a list of string with data from csv
     */
    @Override
    public List<String[]> readData(String filePath){

        List<String[]> allData = null;

        try{
            FileReader filereader = new FileReader(filePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                                        .withSkipLines(1)
                                        .build();

            allData = csvReader.readAll();

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return allData;
    }

}
