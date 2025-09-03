package com.example.processors;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.example.vo.Filter;

/**
 * Process an image applying a transformation, based on the filter. It is run using multithreading.
 * @author gloria.figueroa
 */
public class ImageProcessor {
	
	private static final Logger LOGGER = Logger.getLogger(ImageProcessor.class.getName());
	private static final String EXCEPTION_READING_IMAGE = "Exception reading the image with URL ";
	private static final String EXCEPTION_SHUTTING_DOWN_THREAD_POOL = "Exception shuting down the thread pool"; 
	
	private static final int THREAD_POOL_SIZE = 10;
	private static final int AWAIT_TERMINATION_IN_MILLISECONDS = 500;
	
	private FilterManager filterManager;
	private ExecutorService pool;
	
	/**
	 * Constructor, gets the filter and creates the thread pool.
	 */
	public ImageProcessor() {
		filterManager = FilterManager.getInstance();
		pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
	}
	
	/**
	 * Applies a transformation to an image using the filter with the correspondent identifier.
	 * @param url Url of the image to transform.
	 * @param filterId Identifier of the filter to be used. 
	 * @return The image with the transformation applied.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public BufferedImage applyFilter(URL url, int filterId) throws IOException, InterruptedException {
		BufferedImage img = null;
		BufferedImage imgFiltered = null;
		Filter filter = null;
		
		try {
			//read the image
			img = ImageIO.read(url);
			int height = img.getHeight();
			int width = img.getWidth();
			
			//create the final BufferedImage
			imgFiltered = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			//get the filter to process the image
			filter = filterManager.getFilter(filterId);
			
			//go through each pixel of the image
			for (int x = 0; x < width; x++) {
				for (int y = 0 ; y < height; y++) { 
					//execute transformation for each pixel
					pool.execute(new TransformationThread(img, x, y, filter, imgFiltered));
				}
			}
			//shutdown the pool and wait for the thread to finish 
			pool.shutdown();
			pool.awaitTermination(AWAIT_TERMINATION_IN_MILLISECONDS, TimeUnit.MILLISECONDS);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, EXCEPTION_READING_IMAGE + url, e);
			throw e;
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, EXCEPTION_SHUTTING_DOWN_THREAD_POOL , e);
			throw e;
		} 
		return imgFiltered;
	}
	
	 
}
