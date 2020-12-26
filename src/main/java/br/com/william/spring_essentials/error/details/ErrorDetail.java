package br.com.william.spring_essentials.error.details;

public class ErrorDetail {
	private String title;
	private int satus;
	private String detail;
	private long timestamp;
	private String developerMessage;
	public ErrorDetail(String title, int satus, String detail, long timestamp, String developerMessage) {
		super();
		this.title = title;
		this.satus = satus;
		this.detail = detail;
		this.timestamp = timestamp;
		this.developerMessage = developerMessage;
	}
	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSatus() {
		return satus;
	}
	public void setSatus(int satus) {
		this.satus = satus;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
	
}
