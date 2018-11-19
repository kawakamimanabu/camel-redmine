package com.foo.camel.component;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RedmineComponentTest extends CamelTestSupport {
	private final String URL = "http://localhost:3000";
	private final String APIKEY = "apikey";

    @Test
    public void testRedmine() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(1);
        
        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() {
                from("redmine://"+ URL + "?apikey=" + APIKEY)
//                  .to("redmine://"+ URL + "?apikey=" + APIKEY)
                  .to("mock:result");
            }
        };
    }
}
