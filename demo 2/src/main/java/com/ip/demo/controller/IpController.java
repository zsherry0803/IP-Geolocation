package com.ip.demo.controller;

import com.ip.demo.model.IpResponse;
import com.ip.demo.repository.IpRepository;
import com.ip.demo.service.IpService;
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
    IpService ipService;

    @GetMapping
    public String test(){
        return "Hello";
    }
    @GetMapping("/{ip}")
    public ResponseEntity<IpResponse> getIpDetail(@PathVariable String ip) {
        IpResponse ipResponse= ipService.getIpDetailByQuery(ip);
        return new ResponseEntity<IpResponse>(ipResponse, HttpStatus.OK);
    }
}
