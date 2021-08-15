package com.saritha.rest.api.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

//ignore all unwanted properties from jSON)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "urls")
public class UnsplashImageUrl {

	private String thumbUrl;

	@JsonProperty(value = "thumb")
	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

}
