package br.com.william.spring_essentials.error.details;

import javax.annotation.Generated;

public class ResourcesNotFoundDetails extends ErrorDetails{
	
	
	
	@Generated("SparkTools")
	private ResourcesNotFoundDetails(Builder builder) {
		this.setTitle(builder.title);
		this.setSatus(builder.satus);
		this.setDetail(builder.detail);
		this.setTimestamp(builder.timestamp);
		this.setDeveloperMessage(builder.developerMessage);
	}
	private ResourcesNotFoundDetails() {
		super();
		// TODO Auto-generated constructor stub
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

		public Builder() {
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

		public ResourcesNotFoundDetails build() {
			return new ResourcesNotFoundDetails(this);
		}
	}
	
	
	
	
}
