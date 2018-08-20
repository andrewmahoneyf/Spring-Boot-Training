package bitcoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// add class-level annotations


public class BitcoinPriceService {

  private static Logger log = LoggerFactory.getLogger(BitcoinPriceService.class);

  // add a main method and start the SpringBoot App

  // add mapping for "/price"

  // insert the getPrice() method
  // return a random price (string)
  // between "$1" and "20000"

}