package tv.lycam.domain;

public class CountResponse {
	private int count;
	
	public CountResponse(int count){
		this.setCount(count);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
