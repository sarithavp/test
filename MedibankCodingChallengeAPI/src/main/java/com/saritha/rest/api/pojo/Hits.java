package com.saritha.rest.api.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hits {
	
	private List<MedicineArticle> medArticle;
	
	@JsonProperty("hits")
	public List<MedicineArticle> getMedArticle() {
		return medArticle;
	}

	public void setMedArticle(List<MedicineArticle> medArticle) {
		this.medArticle = medArticle;
	}
	
	

}
