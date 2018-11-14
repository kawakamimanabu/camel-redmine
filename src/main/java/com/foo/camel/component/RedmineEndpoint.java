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
    syntax="redmine:target", 
    consumerClass = RedmineConsumer.class,
    label = "Redmine")
public class RedmineEndpoint extends DefaultEndpoint {
    @UriPath @Metadata(required = "true")
    private String target;
    @UriParam(defaultValue = "10")
    private int option = 10;

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
     * Some description of this option, and what it does
     */
    public void setTarget(String name) {
        this.target = name;
    }

    public String getTarget() {
        return target;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
