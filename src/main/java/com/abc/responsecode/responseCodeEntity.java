package com.abc.responsecode;



public class responseCodeEntity {
	int responseCode;
	String responseMessage;
	
	public responseCodeEntity(responseCode code)
	{
		switch(code)
		{
			case NOTFOUND:
			{
				responseCode = 404;
				responseMessage = "Can't found record";
				break;
			}
			case DUPLICATE:
			{
				responseCode = 405;
				responseMessage = "Duplicate Primary Key";
				break;
			}
			case SUCCESS:
			{
				responseCode = 200;
				responseMessage  = "Success";
				break;
			}
			case SERVERERROR:
			{
				responseCode = 500;
				responseMessage = "Server error";
				break;
			}
		}
	}
	
	public int getresponseCode() {
		return responseCode;
	}
	public void setresponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getresponseMessage() {
		return responseMessage;
	}
	public void setresponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
}
