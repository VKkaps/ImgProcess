package com.image_processing.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;



public abstract class AbstractProcessImage {

	protected BufferedImage rawImage = null;  //raw user uploaded image
	
	protected final int imageWidth;
	protected final int imageHeight; 
	protected final int imageWidth_middle;
	protected final int imageHeight_middle;
	
	protected static Pixel[][] imagePixelArray;
	protected int averageRGBPixelvalue;
	protected List<Pixel> noticablePixList = new ArrayList<Pixel>();
	
	private Graphics2D g2d;
	private final Color neon = new Color(58, 255, 20);	
	
	
	//JPG only for BufferedImage!!
	public AbstractProcessImage(BufferedImage b) {
		rawImage = b;
		imageWidth = rawImage.getWidth();
		imageHeight = rawImage.getHeight();
		imageWidth_middle = (imageWidth/2);
		imageHeight_middle = (imageHeight/2);
		imagePixelArray = new Pixel[imageWidth][imageHeight]; //2-D Array comprised of type Pixel
		initImagePixelArray();  // Load Pixels into above array
		findAverageRGBPixelValueForImage();
	}
	

	/*
	 * Create a new 'Pixel' object for every pixel in user provided image
	 * */	
	private void initImagePixelArray() {
		for (int y = 0; y < imageHeight; y++) {
		    for (int x = 0; x < imageWidth; x++) {
		    	imagePixelArray[x][y] = new Pixel((rawImage.getRaster().getPixel(x, y, new int[3])), x, y);
		    }
		}	
	}
	
	
	/*Iterate over every pixel to find the Average RGB value for the entire image.
	 * 
	 * This value will be used to determine what pixels are 'noticable' in the image.
	 * */
	private void findAverageRGBPixelValueForImage() {	
		int rgbSum=0;
		
		for (Pixel[] p: imagePixelArray) {
		    for (Pixel currentPixel: p) {
		    	rgbSum += currentPixel.getrgbAverage();
		    }
		}		
		averageRGBPixelvalue = ((rgbSum) / ((rawImage.getWidth())*(rawImage.getHeight())));			
	}
		
	
	
	/*
	 * Draw a Neon box around each Feature.
	 * getBoundaryArr returns an int Array from the Feature of lowest/highest X and Y pixels
	 * */	
	public BufferedImage boxFeatures(BufferedImage rawImage, Map<Integer, Feature> mapFeatures) {
		g2d = rawImage.createGraphics();
		g2d.setColor(neon);
		
		for (Feature f : mapFeatures.values()) {
			drawNeonBox(rawImage, f.getBoundaryArr());
		}	
		return rawImage;
	}
	
	
	/*
	 * 
	 *	fourCoordinatesArr[0] = firstX;
	 *	fourCoordinatesArr[1] = firstY;
	 *	fourCoordinatesArr[2] = lastX;
	 *  fourCoordinatesArr[3] = lastY;
	 * 
	 * */	
	public void drawNeonBox(BufferedImage b, int[] fourCoordinates) {
		g2d.drawLine(fourCoordinates[0]-1, fourCoordinates[1]-1, fourCoordinates[2]+1, fourCoordinates[1]-1);
		g2d.drawLine(fourCoordinates[0]-1, fourCoordinates[3]+1, fourCoordinates[2]+1, fourCoordinates[3]+1);
		g2d.drawLine(fourCoordinates[0]-1, fourCoordinates[1]-1, fourCoordinates[0]-1, fourCoordinates[3]+1);
		g2d.drawLine(fourCoordinates[2]+1, fourCoordinates[1]-1, fourCoordinates[2]+1, fourCoordinates[3]+1);

	}
		
	/*
	 * Static method to output a BufferedImage to a specified directory.
	 * 
	 * */
	public static void outputFile(BufferedImage b, String filePath, String imageName, String imageType) {
		File outputFile = new File(filePath + imageName + "." + imageType);
		try {
			ImageIO.write(b, imageType, outputFile);
		} catch (IOException e) {
			System.out.println("Error: Outputting image to filesystem.");
			e.printStackTrace();
		}
	}
	
	/*
	 * Returns a specified portion of the imagePixelArray as a 
	 * 2D Integer Array
	 * 
	 * */
	public static Integer[][] getFeatureAsIntArray(int[] boundaryArr){
		int width = boundaryArr[2] - boundaryArr[0];
		int height = boundaryArr[3] - boundaryArr[1];
		
		Integer[][] intArr = new Integer[width][height];
		
		for (int y = boundaryArr[1]; y < boundaryArr[3]; y++) {
		    for (int x = boundaryArr[0]; x < boundaryArr[2]; x++) {
		    	if (imagePixelArray[x][y].isNoticable()) {
		    		intArr[x-boundaryArr[0]][y-boundaryArr[1]] = 1;
		    	}
		    	else intArr[x-boundaryArr[0]][y-boundaryArr[1]] = 0;
		    	
		    	System.out.print(intArr[x-boundaryArr[0]][y-boundaryArr[1]]+" ");
		    }
	    	System.out.println();

		}	
		return intArr;
	}
	
	
	// all child classes need their own way of implementing findNoticablePixels()
	protected abstract void findNoticablePixels();
	
	// all child classes need their own way of implementing findFeatures()
	protected abstract void findFeatures();
	
}


