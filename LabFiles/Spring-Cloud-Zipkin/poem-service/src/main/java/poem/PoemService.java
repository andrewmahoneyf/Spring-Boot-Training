package poem;

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

@RestController
@SpringBootApplication
@RequestMapping("/fire-and-ice")
public class PoemService {

  private static Logger log = LoggerFactory.getLogger(PoemService.class);

  // add delay function here
  private static int DELAY_TIME = 100;

  private static void delay( int delay ) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(PoemService.class, args);
  }

  // add /title handler here
  @RequestMapping("/title")
  public String getTitle() {

  }

  @RequestMapping("/first-line")
  public String getFirstLine() {

    StringBuilder sb = new StringBuilder();
    sb.append("Some say the world will end in fire,\n");
    sb.append("Some say in ice.\n");
    String firtLine = sb.toString();

    delay(DELAY_TIME);

    log.info(firtLine);
    return firtLine;
  }

  // add /second-line handler
  @RequestMapping("/second-line")
  public String getSecondLine() {

  }

  // add /third-line handler
  @RequestMapping("/third-line")
  public String getThirdLine() {

  }

  // add /author handler
  @RequestMapping("/author")
  public String getAuthor() {

  }

}