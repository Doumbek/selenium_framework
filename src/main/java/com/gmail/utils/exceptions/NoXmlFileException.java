package com.gmail.utils.exceptions;

public class NoXmlFileException extends Exception {

	private String message;

	public NoXmlFileException() {
		super();
	}

	public NoXmlFileException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {

		return message;

	}

}
