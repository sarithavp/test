package com.saritha.rest.api.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsplashImage {

	private UnsplashImageUrl unsplashImageUrl;

	@JsonProperty("urls")
	public UnsplashImageUrl getUnsplashImageUrl() {
		return unsplashImageUrl;
	}

	public void setUnsplashImageUrl(UnsplashImageUrl unsplashImageUrl) {
		this.unsplashImageUrl = unsplashImageUrl;
	}

}
