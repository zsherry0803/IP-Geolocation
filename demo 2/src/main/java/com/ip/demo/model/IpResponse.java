package com.ip.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "IpResponse")
@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class IpResponse {
    @Column(name = "status")
    private String status;
    @Column(name = "message")
    private String message;
    @Column(name = "Continent")
    private String Continent;
    @Column(name = "continentCode")
    private String continentCode;
    @Column(name = "country")
    private String country;
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "region")
    private String region;
    @Column(name = "regionName")
    private String regionName;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "zip")
    private String zip;
    @Column(name = "lat")
    private BigDecimal lat;
    @Column(name = "lon")
    private BigDecimal lon;
    @Column(name = "timezone")
    private String timezone;
//    @Column(name = "off-set")
//    private int offset;
    @Column(name = "currency")
    private String currency;
    @Column(name = "isp")
    private String isp;
    @Column(name = "org")
    private String org;
    @Column(name = "as")
    private String as;
    @Column(name = "asname")
    private String asname;
    @Column(name = "reverse")
    private String reverse;
    @Column(name = "mobile")
    private boolean mobile;
    @Column(name = "proxy")
    private boolean proxy;
    @Column(name = "hosting")
    private boolean hosting;
    @Id
    @NotNull
    @Column(name = "query")
    private String query;


}
