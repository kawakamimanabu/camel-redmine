package com.foo.camel.component;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;

/**
 * Represents a Redmine endpoint.
 */
@UriEndpoint(firstVersion = "1.0.0-SNAPSHOT",
    scheme = "redmine",
    title = "Redmine",
    syntax="redmine:url", 
    consumerClass = RedmineConsumer.class,
    label = "Redmine")
public class RedmineEndpoint extends DefaultEndpoint {
    @UriPath @Metadata(required = "true")
    private String url;
    @UriParam(defaultValue = "apikey")
    private String apikey = "";

    public RedmineEndpoint() {
    }

    public RedmineEndpoint(String uri, RedmineComponent component) {
        super(uri, component);
    }

    public RedmineEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new RedmineProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new RedmineConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }

    /**
     * Redmine URL
     */
    public void setUrl(String name) {
        this.url = name;
    }

    public String getUrl() {
        return url;
    }

    /**
     * Redmine API Key
     */
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getApikey() {
        return apikey;
    }
}
