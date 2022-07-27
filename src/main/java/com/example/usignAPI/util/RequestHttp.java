package com.example.usignAPI.util;

import com.example.usignAPI.model.entity.LinkPreview;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestHttp {

    private String apikey = "2a693a6df13d15c1ae1bf57990393dfc";

    private String url = "https://api.linkpreview.net/?key=" + apikey  +"&q=";

    public LinkPreview getRequest(String link){

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        try {
            LinkPreview linkPreview = restTemplate.getForObject(url + link, LinkPreview.class);
            return linkPreview;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }



}
