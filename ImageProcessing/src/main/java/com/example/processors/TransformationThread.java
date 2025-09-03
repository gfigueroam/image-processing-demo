package com.example.processors;

import java.awt.image.BufferedImage;

import com.example.operations.Convolution;
import com.example.operations.ITransformation;
import com.example.vo.Filter;

/**
 * Runs the transformation for a single pixel.
 * @author gloria.figueroa
 */
public class TransformationThread implements Runnable{
	
	private BufferedImage image;
	private int x;
	private int y;
	private Filter filter;
	private BufferedImage imageFiltered;
	private ITransformation transformation;

	/**
	 * Constructor that receives parameters needed to perform the transformation.
	 * @param image The image to be transformed.
	 * @param x The x coordinate for the position to apply transformation.
	 * @param y The y coordinate for the position to apply transformation.
	 * @param filter The filter object representing the kernel.
	 * @param imageFiltered The filtered image final.
	 */
	public TransformationThread(BufferedImage image, int x, int y, Filter filter, BufferedImage imageFiltered) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.filter = filter;
		this.imageFiltered = imageFiltered;
		transformation = new Convolution();
	}
	
	/**
	 * Sets the value of the transformation on the imageFiltered object.
	 */
	public void transform() {
		imageFiltered.setRGB(x,y,transformation.transformPixel(image, x, y, filter));
	}
	
	@Override
	public void run() {
		transform();
	}

}
