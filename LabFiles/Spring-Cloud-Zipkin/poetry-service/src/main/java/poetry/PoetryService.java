package poetry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@SpringBootApplication
public class PoetryService {

  private static String ZUUL_URL     = "http://localhost:8080/";
  private static String FIRE_AND_ICE = "poem-service/fire-and-ice/";

  private static Logger log = LoggerFactory.getLogger(PoetryService.class);

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;

  // add task executor


  public static void main(String[] args) {
    SpringApplication.run(PoetryService.class, args);
  }

  @RequestMapping("/poem")
  public String getPoem() {

    StringBuilder sb = new StringBuilder();

    sb.append(restTemplate.getForObject(
                  ZUUL_URL+FIRE_AND_ICE+"title",
                  String.class));

    // get the rest of the poem

    log.info(sb.toString());

    return sb.toString();
  }

  // Add getPoemAsync() here

  // Add the asynchronous getPoemSection

}

// create the ThreadConfig class here
