package com.example.usignAPI.controller;

import com.example.usignAPI.model.entity.LinkPreview;
import com.example.usignAPI.util.RequestHttp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class LinkPreviewController {

    @GetMapping("/getInfo")
    @ResponseStatus(HttpStatus.CREATED)
    public String getInfo(@RequestParam("link")String link) throws IOException, InterruptedException {

        RequestHttp requestHttp = new RequestHttp();
        LinkPreview linkPreview =  requestHttp.getRequest(link);

        return "<h1>" + linkPreview.getTitle() + "</h1> <br> <h3>" + linkPreview.getDescription() + "</h3>"
                + "<img src=" + linkPreview.getImage() +">";
    }

}
