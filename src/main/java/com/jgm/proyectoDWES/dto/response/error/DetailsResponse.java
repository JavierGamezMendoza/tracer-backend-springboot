package com.jgm.proyectoDWES.dto.response.error;

import java.util.Date;

public class DetailsResponse {
	 private Date timestamp;
	    private String message;
	    private String details;

	    public DetailsResponse(Date timestamp, String message, String details) {
	        super();
	        this.timestamp = timestamp;
	        this.message = message;
	        this.details = details;
	    }

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

}
