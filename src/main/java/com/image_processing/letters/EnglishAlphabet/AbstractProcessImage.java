package com.image_processing.letters.EnglishAlphabet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.image_processing.core.Pixel;

public abstract class AbstractProcessImage {
	

	protected BufferedImage rawImage = null;
	protected final int imageWidth;
	protected final int imageHeight; 
	protected Pixel[][] imagePixelArray;
	protected int averageRGBPixelvalue;
	protected List<Pixel> noticablePixList = new ArrayList<Pixel>();;
	Graphics2D g2d;
	Color neon = new Color(58, 255, 20);	
	
	
	
	public AbstractProcessImage(BufferedImage b) {
		rawImage = b;
		imageWidth = rawImage.getWidth();
		imageHeight = rawImage.getHeight();
		imagePixelArray = new Pixel[imageWidth][imageHeight];
		initImagePixelArray();  // Load Pixels into above array
		findAverageRGBPixelValueForImage();
		findNoticablePixels();
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
	 * Initializes the field 'noticablePixList'.  A pixel is determined to be noticable if 
	 * it's average RGB value is less than (averageRGBPixelvalue - x), where x is a
	 * arbitrary int value.
	 * 
	 * Note, for loop values are offset (1 instead of 0) to prevent ArrayOutOfBounds errors.
	 * 
	 * */
	
	private void findNoticablePixels() {
		final long startTime = System.currentTimeMillis();
		
		for (int y = 1; y < imageHeight-1; y++) {
		    for (int x = 1; x < imageWidth-1; x++) {
		    	/*For each Pixel in image, determine if it is noticable by passing in the
		    	 * Image averageRGBPixelvalue.
		    	 * 
		    	 * If it is noticable add it to the noticablePix list
		    	 * */
		    	imagePixelArray[x][y].initializeIsNoticable(averageRGBPixelvalue);
		    	if (imagePixelArray[x][y].isNoticable()) noticablePixList.add(imagePixelArray[x][y]);
		    }
		}
		
        final long endTime = System.currentTimeMillis();

        System.out.println("findNoticablePixels execution time: " + (endTime - startTime) + " ms");      
	}
	

	
	/*
	 * 
	 *	boundaryArr[0] = firstX;
	 *	boundaryArr[1] = firstY;
	 *	boundaryArr[2] = lastX;
	 *  boundaryArr[3] = lastY;
	 * 
	 * 
	 * */
	
	public void drawNeonBox(BufferedImage b, int[] boundary) {
		g2d = b.createGraphics();
		g2d.setColor(neon);
		g2d.drawLine(boundary[0]-1, boundary[1]-1, boundary[2]+1, boundary[1]-1);
		g2d.drawLine(boundary[0]-1, boundary[3]+1, boundary[2]+1, boundary[3]+1);
		g2d.drawLine(boundary[0]-1, boundary[1]-1, boundary[0]-1, boundary[3]+1);
		g2d.drawLine(boundary[2]+1, boundary[1]-1, boundary[2]+1, boundary[3]+1);

	}
	
	public static void outputFile(BufferedImage b, String filePath, String imageName, String imageType) {
		File outputFile = new File(filePath + imageName + "." + imageType);
		try {
			ImageIO.write(b, imageType, outputFile);
		} catch (IOException e) {
			System.out.println("Error: Outputting image to filesystem.");
			e.printStackTrace();
		}
	}
	
	
	
	// all child classes need their own way of implementing findFeatures()
	protected abstract void findFeatures();
	
}


