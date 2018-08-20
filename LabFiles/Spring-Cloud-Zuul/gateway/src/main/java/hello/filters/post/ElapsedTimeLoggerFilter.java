package hello.filters.post;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ElapsedTimeLoggerFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(ElapsedTimeLoggerFilter.class);

  // add type, order and shouldFilter methods here

  // add run method here

}