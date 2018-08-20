package com.webage.spring.samples.helloclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class RibbonHelloClient implements CommandLineRunner {

    // Insert autowired HelloAPI here...
    @Autowired
    HelloAPI helloAPI;

    @Override
    public void run(String... args) {
        System.out.println("What's your name?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        /*
         * We're going to do 500 requests, and keep track of the numbers of
         * responses
         */
        Map<String, Integer> responseCounts = new HashMap<String, Integer>();
        for (int i = 0; i < 500; i++) {
            //  Insert code to make the call here...
            Map<String, Object> resp = helloAPI.getGreeting(name);
            String greeting = (String) resp.get("message");
            System.out.println("Server says:" + resp.get("message"));

            if (!responseCounts.containsKey(greeting)) {
                responseCounts.put(greeting, 0);
            }
            responseCounts.put(greeting, responseCounts.get(greeting) + 1);
        }
        for (String greeting : responseCounts.keySet()) {
            System.out.printf("%s occured %d times\n", greeting, responseCounts.get(greeting));
        }
        // Exit
        System.out.println("Press any key to exit");
        input.nextLine();
        System.exit(0);
    }
}
