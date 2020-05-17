package com.demo.model;

public class Status {
	private String status;

	@Override
	public String toString() {
		return "Status [status=" + status + "]";
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
