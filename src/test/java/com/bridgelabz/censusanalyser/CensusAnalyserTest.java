package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bridgelabz.censusanalyser.exception.CensusAnalyserException;
import com.bridgelabz.censusanalyser.model.CensusAnalyser;
import static com.bridgelabz.censusanalyser.exception.CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT;

public class CensusAnalyserTest {
	private String INIDAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
	private String INIDAN_CENSUS_WRONGCSV_FILE_PATH = "./src/main/resources/IndiaSateCensusData.csv";
	private String INDIAN_CENSUS_INCORRECT_FILE_FORMAT = "./src/main/resources/IndiaStateCensusData.txt";
	private String INDIAN_CENSUS_WITHWRONG_DELIMITER = "src/main/resources/IndiaStateCensusDataWithWrongDelimiter.csv";
	private String INDIAN_CENSUS_WITHWRONG_HEADER = "src/main/resources/IndiaStateCensusDataWithWrongHeader.csv";

	private String INIDAN_STATE_CODE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
	private String INIDAN_STATE__CODE_WRONGCSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
	private String INDIAN_STATE_CODE_INCORRECT_FILE_FORMAT = "./src/main/resources/IndiaStateCodeData.txt";
	private String INDIAN_STATE_CODE_WITHWRONG_DELIMITER = "src/main/resources/IndiaStateCodeWithWrongDelimeter.csv";
	private String INDIAN_STATE_CODE_WITHWRONG_HEADER = "src/main/resources/IndiaStateCodeWithWrongHeader.csv";

	@Test
	public void givenIndianCensusWrongCSVFile_WhenLoad_ShouldReturnException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INIDAN_CENSUS_WRONGCSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT, e.type);
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

	@Test
	public void givenIndianCensusCSVFile_WhenWrongDelimiter_ShouldThrowException() {

		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WITHWRONG_DELIMITER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusCSVFile_WhenWrongHeader_ShouldThrowException() {

		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WITHWRONG_HEADER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT, e.type);
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws Exception {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		int count = censusAnalyser.loadIndianStateCodeData(INIDAN_STATE_CODE_CSV_FILE_PATH);
		Assert.assertEquals(37, count);
	}

	@Test
	public void givenIndianStateCode_WrongCSVFile_WhenLoad_ShouldReturnException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCodeData(INIDAN_STATE__CODE_WRONGCSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.type, CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER);
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCode_CSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CODE_INCORRECT_FILE_FORMAT);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, e.type);
		}
	}

	@Test
	public void givenIndianStateCodeCSVFile_WhenWrongDelimiter_ShouldThrowException() {

		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CODE_WITHWRONG_DELIMITER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT, e.type);
			e.toString();
		}
	}

	@Test
	public void givenIndianStateCodeCSVFile_WhenWrongHeader_ShouldThrowException() {

		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CODE_WITHWRONG_HEADER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT, e.type);
			e.toString();
		}
	}
}