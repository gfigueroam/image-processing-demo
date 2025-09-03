package com.example.web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.processors.ImageProcessor;
import com.example.util.Error;

/**
 * Image processing servlet.
 * @author gloria.figueroa
 */
@WebServlet("/filtered_images/fruits.png")
public class ImageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4087162519626860409L;
	private static final String ERROR_ATTRIBUTE = "error";
	private static final Logger LOGGER = Logger.getLogger(ImageServlet.class.getName());
	
	/**
     * Default constructor.
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
    }

	/**
	 * Gets the url of the image and the filter to use.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filterId;
		ImageProcessor imageProcessor;
		BufferedImage img;
		
		//get the parameters
		String sFilterId = request.getParameter("filterId");
		String sOriginalImage = request.getParameter("originalImage");
		
		if (sFilterId == null || sOriginalImage == null) {
			//if one parameter is missing
			LOGGER.log(Level.SEVERE, Error.MANDATORY_PARAMETER_MISSING.getDescription());
			request.setAttribute(ERROR_ATTRIBUTE, Error.MANDATORY_PARAMETER_MISSING.getDescription());
			return;
		}
		
		try {
			//get the identifier of the filter
			filterId = Integer.parseInt(sFilterId); 
			//create the processor and transform the image
			imageProcessor = new ImageProcessor();
			img = imageProcessor.applyFilter(new URL(sOriginalImage), filterId);
			
			//clear the response and set the new content
			response.reset();
	        response.setContentType("image/png");
	        ImageIO.write(img, "png", response.getOutputStream());
	        
		} catch(NumberFormatException e) {
			LOGGER.log(Level.SEVERE, Error.FILTER_ID_NOT_NUMERIC.getDescription());
			request.setAttribute(ERROR_ATTRIBUTE, Error.FILTER_ID_NOT_NUMERIC.getDescription());
			return;
		} catch(MalformedURLException e){
			LOGGER.log(Level.SEVERE, Error.MALFORMED_URL.getDescription());
			request.setAttribute(ERROR_ATTRIBUTE, Error.MALFORMED_URL.getDescription());
			return;
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, Error.SYSTEM_ERROR.getDescription());
			request.setAttribute(ERROR_ATTRIBUTE, Error.SYSTEM_ERROR.getDescription());
			return;
		}
	}
}
