package com.foo.camel.component;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link RedmineEndpoint}.
 */
public class RedmineComponent extends DefaultComponent {
    
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new RedmineEndpoint(uri, this);
        ((RedmineEndpoint)endpoint).setUrl(remaining);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
