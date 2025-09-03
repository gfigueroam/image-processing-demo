package com.example.processors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.vo.Filter;

/**
 * This class manage all the filters, and the operations related with filters, as loading filters to memory and allowing the access 
 * to each one throw the {@link FilterManager#getFilter(int) getFilter} method.
 * @author gloria.figueroa
 */
public final class FilterManager {
	
	private static final Logger LOGGER = Logger.getLogger(FilterManager.class.getName());
	
	private static final String EXCEPTION_LIST_FILTERS_CANNOT_BE_NULL = "List filters cannot be null";
	private static final String EXCEPTION_DUPLICATE_FILTER_IDENTIFIER = "Two filters have been defined with the same identifier";
	
	private Map<Integer, Filter> filters;
	private volatile static FilterManager filterManager;
	
	/**
	 * Private constructor to avoid external instantiation.
	 */
	private FilterManager() {
		filters = new HashMap<Integer, Filter>();
	}   
	
	/**
	 * Gets the instance of the FilterManager.
	 * @return FilterManager instance
	 */
	public static FilterManager getInstance() {
		//if the FilterManager has been created, return the instance. avoiding the synchronized block that is very expensive.
		if (filterManager != null)
			return filterManager;
		//make FilterManager thread safe.
		synchronized (FilterManager.class) {
			//if the reference is null create an instance.
			if (filterManager == null)
				filterManager = new FilterManager();
		}
		return filterManager;
	}
	
	/**
	 * Loads the filters to memory using the list passed to create the objects.
	 * @param listFilters List with the filters to load. 
	 * @throws IllegalStateException Exception throw when two filters have been defined with the same identifier.
	 */
	public void loadFilters(List<Filter> listFilters) throws IllegalStateException {
		//clear the filters map
		filters.clear();
		
		if (listFilters == null) {
			IllegalStateException e = new IllegalStateException(EXCEPTION_LIST_FILTERS_CANNOT_BE_NULL);
			LOGGER.log(Level.SEVERE, EXCEPTION_LIST_FILTERS_CANNOT_BE_NULL, e);
			throw e;
		}
			
		//insert the filters with the identifier as key inside the map	
		for (Filter filter: listFilters) {
				//add each filter to the map with the identifier as key
				if (filters.put(filter.getId(), filter) != null) {
					//if the filter map already have one filter with the same identifier, throw and IlegalStateException
					IllegalStateException e = new IllegalStateException(EXCEPTION_DUPLICATE_FILTER_IDENTIFIER);
					LOGGER.log(Level.SEVERE, EXCEPTION_DUPLICATE_FILTER_IDENTIFIER, e);
					throw e;
				}
		}
	}
	
	/**
	 * Return the number of filters loaded to memory.
	 * @return number of filters loaded to memory.
	 */
	public int countFilters(){
		return filters.size();
	}
	
	/**
	 * Returns one specific filter 
	 * @param filterId
	 * @return
	 */
	public Filter getFilter(int filterId) {
		return filters.get(filterId);
	}

}
