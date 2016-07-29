package com.codependent.storyteller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "finder")
public class StoryHolder {

	private static final Logger LOG = LoggerFactory.getLogger(StoryHolder.class);

	private List<Story> stories = new ArrayList<>();

	@PostConstruct
	public void init() {
		LOG.debug("Stories loaded from config: {}", stories);
	}

	public List<Story> getStories() {
		return stories;
	}

}
