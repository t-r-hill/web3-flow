package com.tomiscoding.web3flow;

import com.tomiscoding.web3flow.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;

import java.math.BigInteger;

@SpringBootApplication
public class Web3FlowApplication implements CommandLineRunner {

	@Autowired
	TriggerService triggerService;

	public static void main(String[] args) {
		SpringApplication.run(Web3FlowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(triggerService.getEthBalance());
	}
}
