package com.codependent.storyteller;

import java.util.function.Predicate;
import java.util.stream.Stream;

public interface StoryLister {

	Stream<Story> filterBy(Predicate<Story> p);

	int size();

	Story[] toArray();

}