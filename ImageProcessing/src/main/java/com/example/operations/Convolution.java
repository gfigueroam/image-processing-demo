package com.example.operations;

import java.awt.image.BufferedImage;

import com.example.vo.Filter;

/**
 * This class implements the {@link ITransformation} interface based on the
 * convolution technique used in image processing.
 * @see https://en.wikipedia.org/wiki/Kernel_(image_processing)
 * @author gloria.figueroa
 */
public class Convolution implements ITransformation {

    /**
     * This method does a transformation of a pixel applying convolution.
     * Takes an image and a kernel and a position, applies the
     * convolution at that position.
     * The convolution consist in colocate the center of the mask on
     * the x,y position and get the dot product of all the neighbours
     * using the mask as a second matrix and returns the new pixel value.
     */
	@Override
	public int transformPixel(BufferedImage image, int x,  int y,  Filter filter) {
		int outputRed = 0;
	    int outputGreen = 0;
	    int outputBlue = 0;
	    int color = 0;
	    int _x = 0;
	    int _y = 0;
	    int output = 0;
	    
	    //get the displacement for x and y
	    int xDisp = filter.getWidth() / 2;
	    int yDisp = filter.getHeight() / 2;
	    
	    //go through all the values of the filter
	   for (int i = 0; i < filter.getWidth(); i++) {
	      for (int j = 0; j < filter.getHeight(); j++) {
	    	  _x = x - xDisp + i;
	    	  _y = y - yDisp + j;
	    	  
	    	  //validate the position is within the image bounds 
	    	  if (isIndexWithinBounds(_x, _y, image.getWidth(), image.getHeight())) {
	    		  
	    		  //save the rgb color to extract each component
	    		  color =  image.getRGB(_x, _y);
	    		  
	    		  //multiply each pixel with a pixel in the mask
	    		  outputRed += filter.getMaskPixel(i, j) * ((color & 0x00ff0000) >> 16);
	    	      outputGreen += filter.getMaskPixel(i, j) * ((color & 0x0000ff00) >> 8);
	    	      outputBlue  += filter.getMaskPixel(i, j) * (color & 0x000000ff);  
	    	  }
	      }
	    }
	   //generate rgb integer as a result
	   output = ((constrain((int) outputRed) << 16) & 0x00ff0000) +
			    ((constrain((int) outputGreen) << 8) & 0x0000ff00) +
			    (constrain((int) outputBlue) & 0x000000ff);
	 
	    return output;
	}
	
	/**
	 * Validates if the x,y position is within the image bounds.
	 * @param x position to validate.
	 * @param y position to validate.
	 * @param width width of the bound.
	 * @param height height of the bound.
	 * @return true if the x,y position is within the image bounds, otherwise it returns false. 
	 */
	private boolean isIndexWithinBounds(int x, int y, int width, int height) {
		return (x >= 0) && (y >= 0) &&  (x < width) &&  (y < height);
	}
	
	/**
	 * This method constraint the pixel value between 0 - 255.
	 * If the pixel value is less than 0, it will return 0.
	 * If the pixel value is greater than 255, it will return 255.
	 * @param pixel The pixel to constraint.
	 * @return A valid value for a pixel.
	 */
	 private int constrain(int pixel) {
		 if (pixel < 0)
			 return 0;
		 if (pixel > 255)
			 return 255;
		 return pixel;
	  }

}
