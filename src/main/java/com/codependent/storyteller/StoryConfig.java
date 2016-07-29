package com.codependent.storyteller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StoryHolder.class)
public class StoryConfig {

	private static final Logger LOG = LoggerFactory.getLogger(StoryConfig.class);

	@Bean
	@RefreshScope
	public StoryFinder getStoryFinder(StoryLister lister) {
		return new StoryFinderImpl(lister);
	}

	@Bean
	@RefreshScope
	public StoryLister getLister(StoryHolder storyHolder) {
		return new StoryListerImpl(storyHolder.getStories());

	}

}
