package com.example.operations;

import java.awt.image.BufferedImage;

import com.example.vo.Filter;

/**
 * Defines the structure of a transform techniques applied to image processing.
 * @author gloria.figueroa
 */
public interface ITransformation {
	
		/**
		 * Defines the basic transformation of a pixel applying a filter.
		 * @param image The image to be transformed.
		 * @param x The x coordinate for the position to apply transformation.
		 * @param y The y coordinate for the position to apply transformation.
		 * @param filter The filter object representing the kernel.
		 * @return The new pixel value after the convolution.
		 */
		int transformPixel(BufferedImage image, int x, int y, Filter filter);
}
