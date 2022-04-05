package com.ip.demo.controller;

import com.ip.demo.model.IpResponse;
import com.ip.demo.repository.IpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IpController {
    @Autowired
    IpRepository ipRepository;

    @GetMapping
    public String test(){
        return "Hello";
    }
    @GetMapping("/{ip}")
    public ResponseEntity<IpResponse> getIpDetail(@PathVariable String ip) {
        IpResponse ipResponse= new IpResponse();
        if (ipRepository.existsById(ip)) {
            ipResponse = ipRepository.findById(ip).orElseThrow();
        } else {
            String url = "http://ip-api.com/json/" + ip;
            RestTemplate restTemplate = new RestTemplate();
            IpResponse result = restTemplate.getForObject(url, IpResponse.class);
            ipRepository.saveAndFlush(result);
            ipResponse = result;
        }
        return new ResponseEntity<IpResponse>(ipResponse, HttpStatus.OK);
    }
}
