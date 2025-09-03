package com.example.vo;

/**
 * This class provides the attributes needed in order to do filtering.
 * @author gloria.figueroa
 */
public class Filter {
	
	private int id;
	private String name;
	private String description;
	private int width;
	private int height;
	private double[] mask;
	
	/**
	 * Gets the identifier of the filter.
	 * @return id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * Sets the identifier of the filter;
	 * @param id
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the filter.
	 * @return name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Sets the name of the filter to the value passed.
	 * @param name
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description of the filter.
	 * @return description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the filter.
	 * @param description
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets width of the filter.
	 * @return width;
	 */
	public final int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the filter.
	 * @param width 
	 */
	public final void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets height of the filter.
	 * @return height
	 */
	public final int getHeight() {
		return height;
	}

	/**
	 * Sets height of the filter.
	 * @param height
	 */
	public final void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the values for the mask.
	 * @param mask
	 */
	public final void setMask(double[] mask) {
		this.mask = mask;
	}
	
	/**
	 * Returns the pixel in the mask of a specific x,y position.
	 * @param x x position.
	 * @param y y position.
	 * @return The pixel in the mask in x,y position.
	 * @throws IndexOutOfBoundsException Indicates the index is out of range.
	 */
	public final double getMaskPixel(int x, int y) throws IndexOutOfBoundsException {
		return mask[(x * width) + y];
	}
}
