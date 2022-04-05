package com.ip.demo;

import com.ip.demo.model.IpResponse;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.springframework.http.MediaType;


public class ControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getIpDetail() throws Exception {
        String uri = "/24.48.0.1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        IpResponse ipResponses = super.mapFromJson(content, IpResponse.class);
        assertTrue(ipResponses.getQuery().equals("24.48.0.1"));
    }

}
