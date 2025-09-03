package com.example.processors;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.example.vo.Filter;

public class FilterManagerTest {
	
	@Before
	public void setUp() {
    }

	@Test
	public void testGetInstanceFirstTime() {
		Assert.assertNotNull(FilterManager.getInstance());
	}

	@Test(expected = IllegalStateException.class)
	public void testLoadFiltersWithEmptyList() {
		FilterManager.getInstance().loadFilters(null);
	}
	
	@Test
	public void testLoadFiltersWithList() {
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter1 = new Filter();
		filter1.setId(1);
		Filter filter2 = new Filter();
		filter2.setId(2);
		filters.add(filter1);
		filters.add(filter2);
		
		FilterManager.getInstance().loadFilters(filters);
		Assert.assertEquals(2, FilterManager.getInstance().countFilters());
		Assert.assertNotNull(FilterManager.getInstance().getFilter(1));
		Assert.assertNotNull(FilterManager.getInstance().getFilter(2));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testLoadFiltersWithListDuplicateFilterId() {
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter1 = new Filter();
		filter1.setId(2);
		Filter filter2 = new Filter();
		filter2.setId(2);
		filters.add(filter1);
		filters.add(filter2);
		FilterManager.getInstance().loadFilters(filters);
	}
}
