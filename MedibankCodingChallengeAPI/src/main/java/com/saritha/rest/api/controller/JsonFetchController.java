package com.saritha.rest.api.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.saritha.rest.api.pojo.Hits;
import com.saritha.rest.api.pojo.MedicineArticle;
import com.saritha.rest.api.pojo.UnsplashImage;
import com.saritha.rest.api.pojo.UnsplashImageUrl;
import com.fasterxml.jackson.databind.SerializationConfig;

@RestController
public class JsonFetchController {

	@GetMapping("/api/article")
	public MedicineArticle fetchJson() {

		// **Use the hackers news api to randomly pick an article about medicine and use
		// it for the returned JSON title, url, author fields.
		final String hackerNewsUrl = "https://hn.algolia.com/api/v1/search?query=medicine&tags=story&hitsPerPage=40";

		// **Use the unsplash api to randomly pick an image about medicine and use it
		// for the returned JSON imageUrl field.
		final String unsplashUrl = "https://api.unsplash.com/photos/random?count=1&query=medicine&client_id=w3l5_QBR_ohoKklyM7Hhy-uo5BGgO6cG0-is4aKEnZY";

		// using jackson API
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectMapper objectMapper1 = new ObjectMapper();

		List<MedicineArticle> medArticle = new ArrayList<MedicineArticle>();
		Hits medicineArticleHolder = new Hits();

		UnsplashImage[] unsplashImageHolder;
		UnsplashImage unsplashImageHolder1 = new UnsplashImage();

		try {
			// json deserialization
			medicineArticleHolder = objectMapper.readValue(new URL(hackerNewsUrl), Hits.class);
			medArticle = medicineArticleHolder.getMedArticle(); /* get the element from hackerNews response json */

			// json deserialization
			unsplashImageHolder = objectMapper1.readValue(new URL(unsplashUrl), UnsplashImage[].class);
			unsplashImageHolder1 = unsplashImageHolder[0];	/* get the element from unsplash response json */

		} catch (IOException e) {
			e.printStackTrace();
		}

		// **For the duration of 1 hour return the same JSON content
		LocalTime now = LocalTime.now();

		try {
			medArticle.get(now.getHour()).setImageUrl(unsplashImageHolder1.getUnsplashImageUrl().getThumbUrl());
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return medArticle.get(now.getHour());
	}

}
