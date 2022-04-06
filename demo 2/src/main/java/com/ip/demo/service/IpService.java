package com.ip.demo.service;

import com.ip.demo.model.IpResponse;
import com.ip.demo.repository.IpRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IpService {
    IpRepository ipRepository;
    public IpService(IpRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    @Cacheable(value = "query")
    public IpResponse getIpDetailByQuery(String ip) {
        IpResponse ipResponse= new IpResponse();
        if (ipRepository.existsById(ip)) {
            System.out.println("not from cache");
            ipResponse = ipRepository.findById(ip).orElseThrow();
        } else {
            String url = "http://ip-api.com/json/" + ip;
            RestTemplate restTemplate = new RestTemplate();
            IpResponse result = restTemplate.getForObject(url, IpResponse.class);
            ipRepository.saveAndFlush(result);
            ipResponse = result;
        }

        return ipResponse;
    }
}
