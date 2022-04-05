package com.ip.demo.repository;

import com.ip.demo.model.IpResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpRepository extends JpaRepository<IpResponse, String> {

}
