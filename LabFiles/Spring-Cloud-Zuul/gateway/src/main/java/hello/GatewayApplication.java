package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import hello.filters.pre.RequestLoggerFilter;
import hello.filters.pre.StartTimerFilter;
import hello.filters.post.ElapsedTimeLoggerFilter;


// add the annotation for Eureka
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  // Request logger filter

  // Start Timer Filter

  // Elapsed Time Filter

}