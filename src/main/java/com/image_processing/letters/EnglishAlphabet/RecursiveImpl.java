package com.image_processing.letters.EnglishAlphabet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.image_processing.core.AbstractProcessImage;
import com.image_processing.core.Feature;
import com.image_processing.core.Pixel;

public class RecursiveImpl extends AbstractProcessImage{
	
	
	private Map<Integer, Feature> mapFeatures = new HashMap<Integer, Feature>();
	private List<Pixel> feature = new ArrayList<Pixel>();
	private int mapPointer;
	private Queue<Pixel> noticablePixelsQueue;
		
	private List<Pixel> filteredPixList = new ArrayList<>();
	
	

	public RecursiveImpl(BufferedImage b) {
		super(b);
		findNoticablePixels();
		initializeNeighborPixels();
		findFeatures();
		//identifyLetters(f);
	}
	
	
	/*
	 * Initializes the field 'noticablePixList'.  A pixel is determined to be noticable if 
	 * it's average RGB value is less than (averageRGBPixelvalue - x), where x is a
	 * arbitrary int value.
	 * 
	 * Note, for loop values are offset (1 instead of 0) to prevent ArrayOutOfBounds errors.
	 * 
	 * */
	
	protected void findNoticablePixels() {
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

        System.out.println("\nfindNoticablePixels execution time: " + (endTime - startTime) + " ms");      
	}


	/* For each pixel, check if neighbor pixels (left, right , top, and bottom) are noticable
	 *  or not.  If so, initialize this noticable neighbor pixel in the current pixel.
	 */
	
	private void initializeNeighborPixels() {
        final long startTime = System.currentTimeMillis();
        
		int leftX;
		int rightX;
		int topY;
		int bottomY;
		
		for (Pixel p : noticablePixList) {
			
			leftX = p.getXcoor()-1;
			rightX = p.getXcoor()+1;
			topY = p.getYcoor()-1;
			bottomY = p.getYcoor()+1;
			
			
			if (imagePixelArray[leftX][p.getYcoor()].isNoticable()) {
				p.setLeft(imagePixelArray[leftX][p.getYcoor()]);
			}
			if (imagePixelArray[rightX][p.getYcoor()].isNoticable()) {
				p.setRight(imagePixelArray[rightX][p.getYcoor()]);
			}
			if (imagePixelArray[p.getXcoor()][topY].isNoticable()) {
				p.setTop(imagePixelArray[p.getXcoor()][topY]);
			}
			if (imagePixelArray[p.getXcoor()][bottomY].isNoticable()) {
				p.setBottom(imagePixelArray[p.getXcoor()][bottomY]);
			}
			
			
			if (imagePixelArray[leftX][topY].isNoticable()) {
				p.setNoticableLT(imagePixelArray[leftX][topY]);
			}
			if (imagePixelArray[rightX][topY].isNoticable()) {
				p.setNoticableRT(imagePixelArray[rightX][topY]);
			}
			if (imagePixelArray[leftX][bottomY].isNoticable()) {
				p.setNoticableLB(imagePixelArray[leftX][bottomY]);
			}
			if (imagePixelArray[rightX][bottomY].isNoticable()) {
				p.setNoticableRB(imagePixelArray[rightX][bottomY]);
			}
			
			p.determineEdgePixel();
			if (p.isEdgePixel()) {
				filteredPixList.add(p);
			}

		}
				
		noticablePixList = filteredPixList;
		
        final long endTime = System.currentTimeMillis();

        System.out.println("initializeNeighborPixels execution time: " + (endTime - startTime) + " ms");
        

	}


	
	@Override
	protected void findFeatures() {
		noticablePixelsQueue = new LinkedList<Pixel>(noticablePixList);
		System.out.println("Number of noticable pixels: " + noticablePixelsQueue.size() + " pixels");
        final long startTimeOut = System.currentTimeMillis();
		try {
			while (!noticablePixelsQueue.isEmpty()) {
				preorderTraversal(noticablePixelsQueue.remove());
				
				if (feature.size()>10) mapFeatures.put(mapPointer, new Feature(feature)); //, rawImage
				mapPointer++;
				feature = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getMessage());
			//System.exit(1);
		}
        final long endTimeOut = System.currentTimeMillis();

        System.out.println("Number of Features: " + mapFeatures.size() + " features");
        System.out.println("findFeatures execution time: " + (endTimeOut - startTimeOut) + " ms");		
	}
	
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels
	 * If a noticable pixel has a neighboring noticable pixel add pixel to a growing pixel 
	 * list, which is a Feature.
	 */
	
	private void preorderTraversal(Pixel p) {

			if(p !=  null && !feature.contains(p)) {  
				feature.add(p);
				noticablePixelsQueue.remove(p);

					preorderTraversal(p.getRight());
					preorderTraversal(p.getTop());
					preorderTraversal(p.getLeft());
					preorderTraversal(p.getBottom());
			}
	}

	
	
	/*
	 * Draw a Neon box around each Feature.
	 * getBoundaryArr returns an int Array from the Feature of lowest/highest X and Y pixels
	 * */
	
	public BufferedImage boxFeatures() {

		for (Feature f : mapFeatures.values()) {
			drawNeonBox(rawImage, f.getBoundaryArr());
		}	
		return rawImage;
	}
		
}



