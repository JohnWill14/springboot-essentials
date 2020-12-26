package br.com.william.spring_essentials.error.details;

import javax.annotation.Generated;

public class ValidationErrorDetails extends ErrorDetails {
	private String field;
	private String fieldMessage;
	public ValidationErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ValidationErrorDetails(String title, int satus, String detail, long timestamp, String developerMessage,
			String field, String fieldMessage) {
		super(title, satus, detail, timestamp, developerMessage);
		this.field = field;
		this.fieldMessage = fieldMessage;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
	
	@Generated("SparkTools")
	private ValidationErrorDetails(Builder builder) {
		this.setTitle(builder.title);
		this.setSatus(builder.satus);
		this.setDetail(builder.detail);
		this.setTimestamp(builder.timestamp);
		this.setDeveloperMessage(builder.developerMessage);
		this.setField(builder.field);
		this.setFieldMessage(builder.fieldMessage);
}
	
	/**
	 * Creates builder to build {@link ResourcesNotFoundDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link ResourcesNotFoundDetails}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String title;
		private int satus;
		private String detail;
		private long timestamp;
		private String developerMessage;
		private String field;
		private String fieldMessage;
		public Builder() {
		}

		public Builder withField(String field) {
			this.field = field;
			return this;
		}
		public Builder withFieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withSatus(int satus) {
			this.satus = satus;
			return this;
		}

		public Builder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ValidationErrorDetails build() {
			return new ValidationErrorDetails(this);
		}
	}
	
}
