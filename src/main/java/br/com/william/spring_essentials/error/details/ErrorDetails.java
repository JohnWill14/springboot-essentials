package br.com.william.spring_essentials.error.details;

import javax.annotation.Generated;

public class ErrorDetails {
	private String title;
	private int satus;
	private String detail;
	private long timestamp;
	private String developerMessage;
	@Generated("SparkTools")
	private ErrorDetails(BuilderErrorDetails builder) {
		this.title = builder.title;
		this.satus = builder.satus;
		this.detail = builder.detail;
		this.timestamp = builder.timestamp;
		this.developerMessage = builder.developerMessage;
	}
	public ErrorDetails(String title, int satus, String detail, long timestamp, String developerMessage) {
		super();
		this.title = title;
		this.satus = satus;
		this.detail = detail;
		this.timestamp = timestamp;
		this.developerMessage = developerMessage;
	}
	public ErrorDetails() {
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
	/**
	 * Creates builder to build {@link ErrorDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static BuilderErrorDetails builderErrorDetails() {
		return new BuilderErrorDetails();
	}
	/**
	 * Builder to build {@link ErrorDetails}.
	 */
	@Generated("SparkTools")
	public static final class BuilderErrorDetails {
		private String title;
		private int satus;
		private String detail;
		private long timestamp;
		private String developerMessage;

		public BuilderErrorDetails() {
		}

		public BuilderErrorDetails withTitle(String title) {
			this.title = title;
			return this;
		}

		public BuilderErrorDetails withSatus(int satus) {
			this.satus = satus;
			return this;
		}

		public BuilderErrorDetails withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public BuilderErrorDetails withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public BuilderErrorDetails withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ErrorDetails build() {
			return new ErrorDetails(this);
		}
	}
	
	
}
