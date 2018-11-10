package com.foo.camel.component;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Redmine producer.
 */
public class RedmineProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(RedmineProducer.class);
    private RedmineEndpoint endpoint;

    public RedmineProducer(RedmineEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody());    
    }

}
