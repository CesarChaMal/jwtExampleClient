package com.example.jwtExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeWebService {
//   @Autowired
//   private RestTemplate restTemplate;

   private final RestTemplate restTemplate;

   public ConsumeWebService(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
   }

   @RequestMapping("test")
   public String test() {
      String authToken = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJ0ZXN0SldUIiwic3ViIjoiQ2VzYXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNTk1Mjc3MTk5LCJleHAiOjE1OTUyNzc3OTl9.W0MxnwH2gfChyjYnAKo82ttI9vy2xC45ya41ReBfOIZIxJsbcLpjYaXzrKbxasyuAtjU4-mXqi8IfP046DjzDg";
      HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//      headers.add("User-Agent", "Spring's RestTemplate" );  // value can be whatever
      headers.add("Authorization", "Bearer "+authToken );

//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<String> entity = new HttpEntity<String>(headers);
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

      return restTemplate.exchange("http://localhost:8080/hello?name=Cesar", HttpMethod.GET, entity, String.class).getBody();
   }
}