package com.bridgelabz.censusanalyser.exception;

public class CensusAnalyserException extends Exception {

	private static final long serialVersionUID = 1L;


    public enum ExceptionType {
        CENSUS_FILE_INCORRECT, CENSUS_INCORRECT_FILE_FORMAT, CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER;
    }

	public ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}