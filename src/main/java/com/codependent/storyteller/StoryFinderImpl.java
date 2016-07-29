package com.codependent.storyteller;

public class StoryFinderImpl implements StoryFinder {

	private final StoryLister storyLister;

	public StoryFinderImpl(StoryLister lister) {
		this.storyLister = lister;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.codependent.storyteller.IStoryFinder#count()
	 */
	@Override
	public int count() {
		return storyLister.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.codependent.storyteller.IStoryFinder#findAll()
	 */
	@Override
	public Story[] findAll() {
		return storyLister.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.codependent.storyteller.IStoryFinder#findBy(int)
	 */
	@Override
	public Story findBy(int id) {
		Story missing = new Story();
		missing.setId(-1);
		missing.setName("Not Found!");
		return storyLister.filterBy(story -> story.getId() == id).findAny().orElse(missing);
	}
}
