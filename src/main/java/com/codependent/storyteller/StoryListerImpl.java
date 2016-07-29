package com.codependent.storyteller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StoryListerImpl implements StoryLister {

	private final List<Story> stories;

	public StoryListerImpl(List<Story> stories) {
		this.stories = stories;
	}

	@Override
	public Stream<Story> filterBy(Predicate<Story> p) {
		return this.stories.parallelStream().filter(p);
	}

	@Override
	public int size() {
		return this.stories.size();
	}

	@Override
	public Story[] toArray() {
		return this.stories.toArray(new Story[this.size()]);
	}

}