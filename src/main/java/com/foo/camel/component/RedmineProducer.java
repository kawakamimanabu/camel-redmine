package com.foo.camel.component;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Project;

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
    	RedmineManager redmineManager = 
    			RedmineManagerFactory.createWithApiKey(endpoint.getUrl(), endpoint.getApikey());
    	List<Project> projects = redmineManager.getProjectManager().getProjects();
    	if (projects.size() > 0) {
    		Project project = projects.get(0);
        	redmineManager.setObjectsPerPage(100);
        	List<Issue> issues = redmineManager.getIssueManager().getIssues(project.getIdentifier(), null);
        	for (Issue issue : issues) {
        	    System.out.println(issue.toString());
        	}    	
    	}
    	exchange.getIn().setBody(projects);
        System.out.println(exchange.getIn().getBody());    
    }

}
