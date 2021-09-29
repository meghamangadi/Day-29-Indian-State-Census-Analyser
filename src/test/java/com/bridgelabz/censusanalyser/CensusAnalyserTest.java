package com.bridgelabz.censusanalyser;

 
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bridgelabz.censusanalyser.exception.CensusAnalyserException;
import com.bridgelabz.censusanalyser.model.CensusAnalyser;
import static  com.bridgelabz.censusanalyser.exception.CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT; 

public class CensusAnalyserTest {
    private String INIDAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private String INIDAN_CENSUS_WrongCSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private String INDIAN_CENSUS_INCORRECT_FILE_FORMAT = "./src/main/resources/IndiaStateCensusData.txt";

    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INIDAN_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29, count);
    }

    
    @Test
    public void givenIndianCensusWrongCSVFile_WhenLoad_ShouldReturnException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INIDAN_CENSUS_WrongCSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(e.type, CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT);
            e.printStackTrace();
        }

    }
    
    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_INCORRECT_FILE_FORMAT);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, e.type);
        }
    }
}