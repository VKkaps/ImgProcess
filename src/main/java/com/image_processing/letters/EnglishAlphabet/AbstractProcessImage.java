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
	protected List<Pixel> noticablePixList;
	Graphics2D g2d;
	
	
	public AbstractProcessImage(BufferedImage b) {
		rawImage = b;
		imageWidth = rawImage.getWidth();
		imageHeight = rawImage.getHeight();
		imagePixelArray = new Pixel[imageWidth][imageHeight];
		initImagePixelArray();
		findnoticablePixels();
	}

	
	/*
	 * Initialize object field 'imagePixelArray', which is a 2-D array of type 'Pixel'
	 * */	
	private void initImagePixelArray() {
		for (int y = 0; y < imageHeight; y++) {
		    for (int x = 0; x < imageWidth; x++) {
		    	imagePixelArray[x][y] = new Pixel((rawImage.getRaster().getPixel(x, y, new int[3])), x, y);
		    }
		}	
	}
	
	/*
	 * Initializes the field 'noticablePixList'.  A pixel is determined to be noticable if it's average RGB value 
	 * is greater than the the total image RGB average value.
	 * 
	 * */
	
	private void findnoticablePixels() {
		noticablePixList = new ArrayList<Pixel>();
		int averageRGBPixelvalue = findImageAverageRGBPixelvalue();
		
		for (int y = 1; y < imageHeight-1; y++) {
		    for (int x = 1; x < imageWidth-1; x++) {
		    	imagePixelArray[x][y].initializeIsNoticable(averageRGBPixelvalue);
		    	if (imagePixelArray[x][y].isNoticable()) noticablePixList.add(imagePixelArray[x][y]);
		    }
		}
	}
	
	private int findImageAverageRGBPixelvalue() {
		
		int rgbSum=0;
		
		for (Pixel[] p: imagePixelArray) {
		    for (Pixel currentPixel: p) {
		    	rgbSum += currentPixel.getrgbAverage();
		    }
		}

		return ((rgbSum) / ((rawImage.getWidth())*(rawImage.getHeight())));		
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
		g2d.setColor(new Color(58, 255, 20));  //neon
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

