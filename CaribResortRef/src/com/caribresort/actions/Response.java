package com.caribresort.actions;

import java.io.Serializable;
import java.util.Arrays;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boolean success;
	private String[] errors;
	private Serializable result;
	
	public Response() {
		this(true,new String[0],true);
	}
	
	public Response(Serializable object) {
		this(true,new String[0],object);
	}
	

	/**
	 * Response - constructor
	 * @param success - {Boolean}
	 * @param errors - {String[]}
	 * @param result - {Serializable}
	 * */
	public Response(Boolean success, String[] errors, Serializable result) {
		super();
		this.success = success;
		this.errors = errors;
		this.result = result;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String[] getErrors() {
		return errors;
	}

	public void setErrors(String[] errors) {
		this.errors = errors;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Serializable result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Response [success=" + success + ", errors="
				+ Arrays.toString(errors) + ", result=" + result + "]";
	}
	
}
