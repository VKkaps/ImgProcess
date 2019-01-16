package com.image_processing.letters.EnglishAlphabet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.image_processing.core.AbstractProcessImage;
import com.image_processing.core.Feature;
import com.image_processing.core.Pixel;

public class SequentialRecursiveImpl extends AbstractProcessImage{
	
	private List<Pixel> feature = new ArrayList<Pixel>();	
	private Map<Integer, Feature> mapFeatures = new HashMap<Integer, Feature>();
	private int mapPointer;
	private Queue<Pixel> noticableEdgePixelsQueue;
	private List<Pixel> filteredPixList = new ArrayList<>();	
	
	private int findTime;
	private int initTime;
	private int findFeaturesTime;
	

	public SequentialRecursiveImpl(BufferedImage b) {
		super(b);
		findNoticablePixels();
		initializeNeighborPixels();
		findFeatures();
		boxFeatures(b, mapFeatures);
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
		    	
		    	/*For each Pixel in image, determine if it is noticable by passing in 
		    	 * the Image averageRGBPixelvalue.
		    	 * 
		    	 * If it is noticable, add it to the noticablePix list.
		    	 * */
		    	
		    	imagePixelArray[x][y].initializeIsNoticable(averageRGBPixelvalue);
		    	if (imagePixelArray[x][y].isNoticable()) noticablePixList.add(imagePixelArray[x][y]);
		    }
		}
		
        final long endTime = System.currentTimeMillis();
        findTime = Math.toIntExact(endTime - startTime);

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
			
			
			if (p.determineIfEdgePixel()) {
				filteredPixList.add(p);
			}

		}
		
		
		Collections.sort(filteredPixList);
		
		System.out.println("before: " + noticablePixList.size());
		
		noticablePixList = filteredPixList;

		System.out.println("after:" + noticablePixList.size());
		
		noticableEdgePixelsQueue = new LinkedList<Pixel>(noticablePixList);
		
		System.out.println("afterq: " + noticableEdgePixelsQueue.size());
		
        final long endTime = System.currentTimeMillis();
        initTime = Math.toIntExact(endTime - startTime);

        System.out.println("initializeNeighborPixels execution time: " + initTime + " ms");
        

	}

	
		
	


	/*
	 * Take a queue of noticable edge pixels and traverse thru them grouping
	 * them into features using a recursive method "preorderTraversal".
	 * 
	 * */
	@Override
	protected void findFeatures() {
		System.out.println("Number of noticable pixels: " + noticableEdgePixelsQueue.size() + " pixels");
        final long startTimeOut = System.currentTimeMillis();
		try {
			while (!noticableEdgePixelsQueue.isEmpty()) {
				preorderTraversal(noticableEdgePixelsQueue.remove());
				
				if (feature.size()>10) mapFeatures.put(mapPointer, new Feature(feature)); //, rawImage
				mapPointer++;
				feature = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			
			System.out.println("\nStack overflow error!! -vfk: ");
			
			e.printStackTrace();
			//System.exit(1);
		}
        final long endTimeOut = System.currentTimeMillis();
        findFeaturesTime = Math.toIntExact(endTimeOut - startTimeOut);
        System.out.println("Number of Features: " + mapFeatures.size() + " features");
        System.out.println("findFeatures execution time: " + findFeaturesTime + " ms");	
	}
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels
	 * If a current noticable pixel has a neighboring noticable pixel add current 
	 * noticable pixel to a growing pixel list, which is a Feature.  Then, go thru
	 * Recursive process starting with the current noticable pixel's right neighbor
	 * Pixel.
	 */
	
	private void preorderTraversal(Pixel p) {

		if(p !=  null && !feature.contains(p) && p.isEdgePixel()) {  
			feature.add(p);
			noticableEdgePixelsQueue.remove(p);

			preorderTraversal(p.getRight());
			preorderTraversal(p.getBottom());
			preorderTraversal(p.getTop());
			preorderTraversal(p.getLeft());

		}
	}

	
		
	
	////////////GETTERS/////////////
	
	public int getFindTime() {
		return findTime;
	}
	
	public int getInitTime() {
		return initTime;
	}
	
	public int getFindFeaturesTime() {
		return findFeaturesTime;
	}
	
	public int getPixels() {
		return filteredPixList.size();
	}
	
	public int getFeatures() {
		return mapFeatures.size();
	}
		
}






