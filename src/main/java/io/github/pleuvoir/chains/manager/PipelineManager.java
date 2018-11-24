package io.github.pleuvoir.chains.manager;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import io.github.pleuvoir.chains.filter.Filter;

public abstract class PipelineManager<R> {

	protected Collection<Filter<R>> filters = Collections.synchronizedCollection(new LinkedList<Filter<R>>());

	public void start(R water) {
		this.filters.forEach(filter -> filter.doFilter(water));
	}

	public void addFilter(Filter<R> filter) {
		this.filters.add(filter);
	}

	public void removeFilter(Filter<R> filter) {
		this.filters.remove(filter);
	}
}
