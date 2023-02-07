package it.xenia.petstore.controller;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-24T08:53:54.400Z[GMT]")
public class ApiException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
