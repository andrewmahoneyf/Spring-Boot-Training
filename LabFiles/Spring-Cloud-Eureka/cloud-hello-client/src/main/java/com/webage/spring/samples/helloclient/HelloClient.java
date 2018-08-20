package com.webage.spring.samples.helloclient;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class HelloClient implements CommandLineRunner {
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired RestTemplateBuilder restTemplateBuilder;

	@Override
	public void run(String ... args) {
		System.out.println("What's your name?");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();

		// Insert Lookup Code here...
		List<ServiceInstance> helloServers=
				discoveryClient.getInstances("CLOUD HELLO");
		System.out.println("The following hello-services are available:");
		for(ServiceInstance instance: helloServers){
			System.out.printf("%s at %s\n", instance.getServiceId(), instance.getUri().toString());
		}

		// Insert code to make the call here...
        if(helloServers.size() == 0) {
            System.out.println("Sorry, but I can't find a server to use");
            System.exit(0);
		}
		int chosen=(int) (Math.random()*helloServers.size());
		ServiceInstance chosenInstance=helloServers.get(chosen);
		RestTemplate rt=restTemplateBuilder.build();
		URI callUri = UriComponentsBuilder.fromUri(chosenInstance.getUri())
                .path("/hello-message").queryParam("name", name).build().toUri();
		// Do the call
        Map<String, Object> resp=
                (Map<String, Object>) rt.getForObject(callUri, Map.class);
        System.out.println("Server says:" + resp.get("message"));

		// Exit
		//System.exit(0);
	}
}
