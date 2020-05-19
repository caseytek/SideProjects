package com.caseyteknology.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.caseyteknology.models.Word;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class APIController {
	
	@CrossOrigin
	@GetMapping(path= {"/wordSearch/{wordSearch}"})
	public List<Word> wordSearch(@PathVariable String wordSearch)throws JsonProcessingException, IOException {
		String apiURL = "https://od-api.oxforddictionaries.com/api/v2/entries/en-gb/" + wordSearch.toLowerCase() + "?strictMatch=false";
		String keyValue = "de50904a917fdc0a6a7fefcdbebd1d66";
		String appId = "dabe52fa";
		
		  	HttpHeaders httpHeaders = new HttpHeaders();
		  	
		  	//adding required headers for URL
	        httpHeaders.add("app_id", appId);
	        httpHeaders.add("app_key", keyValue);

	        
	        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
	        RestTemplate restTemplate = new RestTemplate();
	        ObjectMapper objectMapper = new ObjectMapper();

	        ResponseEntity<String> response = restTemplate.exchange(apiURL, HttpMethod.GET, httpEntity, String.class);

	        JsonNode jsonNode = objectMapper.readTree(response.getBody());
	        
	        List <Word> words = new ArrayList<>();
	        
	        for (int i =0; i < jsonNode.path("results").size(); i++) {
//	        	for (int x =0; x < jsonNode.path("lexicalEntries").size(); x++) {
//	        		for (int y =0; y < jsonNode.path("entries").size(); y++) {
	        	Word wordName = new Word();
	    	    wordName.setName(jsonNode.path("results").path(i).findPath("id").asText());
//	        	wordName.setEtymology(jsonNode.path("results").path(i).path("lexicalEntries").path(x).path("entries").path(y).path("etymologies").path(0).toString());
//	        	wordName.setDefinition(jsonNode.path("results").path(i).path("lexicalEntries").path(x).path("entries").path(y).path("senses").path(0).path("definitions").path(0).toString());
//	        	wordName.setExample(jsonNode.path("results").path(i).path("lexicalEntries").path(x).path("entries").path(y).path("senses").path(0).path("examples").path(0).findPath("text").toString());
	        	words.add(wordName);
	        	System.out.println("word: " + wordName.getName());
//	        		}
//	        }	
	     } return words; 
	}
}
