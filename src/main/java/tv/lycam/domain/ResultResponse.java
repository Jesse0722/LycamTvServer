package tv.lycam.domain;

public class ResultResponse {
	
	private boolean success;
	
	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public ResultResponse(boolean success){
		this.success=success;
	}

	public ResultResponse(){
		this.success=false;
	}
}
