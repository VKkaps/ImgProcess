package com.image_processing.letters.EnglishAlphabet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.image_processing.core.AbstractProcessImage;
import com.image_processing.core.Feature;
import com.image_processing.core.Pixel;

public class QuadParallelRecursiveImpl extends AbstractProcessImage{
	
	private List<Pixel> feature1 = new ArrayList<Pixel>();	
	private List<Pixel> feature2 = new ArrayList<Pixel>();	
	private List<Pixel> feature3 = new ArrayList<Pixel>();	
	private List<Pixel> feature4 = new ArrayList<Pixel>();	
	
	private Map<Integer, Feature> mapFeatures1 = new HashMap<Integer, Feature>();
	private Map<Integer, Feature> mapFeatures2 = new HashMap<Integer, Feature>();
	private Map<Integer, Feature> mapFeatures3 = new HashMap<Integer, Feature>();
	private Map<Integer, Feature> mapFeatures4 = new HashMap<Integer, Feature>();
	
	private List<Pixel> noticablePixList1 = new ArrayList<Pixel>();
	private List<Pixel> noticablePixList2 = new ArrayList<Pixel>();
	private List<Pixel> noticablePixList3 = new ArrayList<Pixel>();
	private List<Pixel> noticablePixList4 = new ArrayList<Pixel>();
	
	//4 isolated edge Pixel Queues for Parallelism processing purposes
	private Queue<Pixel> Core1noticableEdgePixelsQueue;
	private Queue<Pixel> Core2noticableEdgePixelsQueue;
	private Queue<Pixel> Core3noticableEdgePixelsQueue;
	private Queue<Pixel> Core4noticableEdgePixelsQueue;
	
	//This list is used to store solely noticable edge Pixels as opposed to all Pixels in an image.
	private List<Pixel> edgePixList = new ArrayList<>();	
	
	// Fields needed for external testing/timing purposes
	private int findTime;
	private int initTime;
	private int sortTime;
	private int findFeaturesTime;
	

	public QuadParallelRecursiveImpl(BufferedImage b) {
		super(b);
		findNoticablePixels();
		initializeNeighborPixels();
		sortAndInitQueues();
		findFeatures();
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
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Future<?> f1 = executorService.submit(this::findNoticablePixels1);
		Future<?> f2 = executorService.submit(this::findNoticablePixels2);
		Future<?> f3 = executorService.submit(this::findNoticablePixels3);
		Future<?> f4 = executorService.submit(this::findNoticablePixels4);
		
		try {
			f1.get();
			f2.get();
			f3.get();
			f4.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
		
		noticablePixList.addAll(noticablePixList1);
		noticablePixList.addAll(noticablePixList2);
		noticablePixList.addAll(noticablePixList3);
		noticablePixList.addAll(noticablePixList4);
		
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
				edgePixList.add(p);
			}

		}
		

        final long endTime = System.currentTimeMillis();
        initTime = Math.toIntExact(endTime - startTime);

        System.out.println("initializeNeighborPixels execution time: " + initTime + " ms"); 
	}
	
	
	/*
	 * Sort edgePixList, then split into 4 queues for processing
	 * 
	 * */
	private void sortAndInitQueues() {
		final long startTimeOut = System.currentTimeMillis();
		
		//Sort edgePixList by X coordinate
		Collections.sort(edgePixList);
		noticablePixList = edgePixList;
		
		// Find indexes of noticablePixList so it can be divided into 4 isolated queues for processing
		int quarterIndex = noticablePixList.size()/4;
		int halfIndex = (quarterIndex+1) + quarterIndex;
		int three_quarterIndex = (halfIndex + 1 + quarterIndex);
		
		Core1noticableEdgePixelsQueue = new LinkedList<Pixel>(noticablePixList.subList(0, quarterIndex));
		Core2noticableEdgePixelsQueue = new LinkedList<Pixel>(noticablePixList.subList((quarterIndex+1), halfIndex));
		Core3noticableEdgePixelsQueue = new LinkedList<Pixel>(noticablePixList.subList(halfIndex+1, three_quarterIndex));
		Core4noticableEdgePixelsQueue = new LinkedList<Pixel>(noticablePixList.subList((three_quarterIndex+1), noticablePixList.size()-1));
        
//		for (Pixel p : Core1noticableEdgePixelsQueue) {
//			p.printPixelRGB();
//		}
		
		final long endTimeOut = System.currentTimeMillis();
        sortTime = Math.toIntExact(endTimeOut - startTimeOut);
        System.out.println("sortAndInitQueues execution time: " + sortTime  + " ms");	
        System.out.println("Number of noticable edge pixels: " + noticablePixList.size() + " pixels");
	}

	
	/*
	 * Execute 4 findFeatures methods concurrently.  Main Thread is paused until
	 * executeQuadSearch() completes.
	 *  
	 * findFeature methods have isolated resources, so no need for Synchronization.
	 * 
	 * */
	@Override
	protected void findFeatures() {
		final long startTimeOut = System.currentTimeMillis();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Future<?> f1 = executorService.submit(this::findFeatures1);
		Future<?> f2 = executorService.submit(this::findFeatures2);
		Future<?> f3 = executorService.submit(this::findFeatures3);
		Future<?> f4 = executorService.submit(this::findFeatures4);
		
		try {
			f1.get();
			f2.get();
			f3.get();
			f4.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
		
	    final long endTimeOut = System.currentTimeMillis();
	    findFeaturesTime = Math.toIntExact(endTimeOut - startTimeOut);
	    System.out.println("findFeatures execution time: " + findFeaturesTime  + " ms");	
	}
	

	
//////////CONCURRENT METHODS BELOW/////////////////
	
	
	
	protected void findNoticablePixels1() {

		for (int y = 1; y < imageHeight_middle; y++) {
		    for (int x = 1; x < imageWidth_middle; x++) {
		    	
		    	/*For each Pixel in image, determine if it is noticable by passing in 
		    	 * the Image averageRGBPixelvalue.
		    	 * 
		    	 * If it is noticable, add it to the noticablePix list.
		    	 * */
		    	
		    	imagePixelArray[x][y].initializeIsNoticable(averageRGBPixelvalue);
		    	if (imagePixelArray[x][y].isNoticable()) noticablePixList1.add(imagePixelArray[x][y]);
		    }
		}   
	}
	
	protected void findNoticablePixels2() {

		for (int y = 1; y < imageHeight_middle; y++) {
		    for (int x = imageWidth_middle; x < (imageWidth-1); x++) {
		    	
		    	/*For each Pixel in image, determine if it is noticable by passing in 
		    	 * the Image averageRGBPixelvalue.
		    	 * 
		    	 * If it is noticable, add it to the noticablePix list.
		    	 * */
		    	
		    	imagePixelArray[x][y].initializeIsNoticable(averageRGBPixelvalue);
		    	if (imagePixelArray[x][y].isNoticable()) noticablePixList2.add(imagePixelArray[x][y]);
		    }
		}   
	}
	
	protected void findNoticablePixels3() {

		for (int y = imageHeight_middle; y < (imageHeight-1); y++) {
			for (int x = imageWidth_middle; x < (imageWidth-1); x++) {
		    	
		    	/*For each Pixel in image, determine if it is noticable by passing in 
		    	 * the Image averageRGBPixelvalue.
		    	 * 
		    	 * If it is noticable, add it to the noticablePix list.
		    	 * */
		    	
		    	imagePixelArray[x][y].initializeIsNoticable(averageRGBPixelvalue);
		    	if (imagePixelArray[x][y].isNoticable()) noticablePixList3.add(imagePixelArray[x][y]);
		    }
		}   
	}

	protected void findNoticablePixels4() {

		for (int y = imageHeight_middle; y < (imageHeight-1); y++) {
		    for (int x = 1; x < imageWidth_middle; x++) {
		    	
		    	/*For each Pixel in image, determine if it is noticable by passing in 
		    	 * the Image averageRGBPixelvalue.
		    	 * 
		    	 * If it is noticable, add it to the noticablePix list.
		    	 * */
		    	
		    	imagePixelArray[x][y].initializeIsNoticable(averageRGBPixelvalue);
		    	if (imagePixelArray[x][y].isNoticable()) noticablePixList4.add(imagePixelArray[x][y]);
		    }
		}   
	}
	

	
	/*
	 * Take a queue of noticable edge pixels and traverse thru them grouping
	 * them into features using a recursive method "preorderTraversal".
	 * 
	 * */

	protected void findFeatures1() {
		int mapPointer1=0;
		try {
			while (!Core1noticableEdgePixelsQueue.isEmpty()) {
				preorderTraversal1(Core1noticableEdgePixelsQueue.remove());
				
				if (feature1.size()>20) mapFeatures1.put(mapPointer1, new Feature(feature1)); //, rawImage
				mapPointer1++;
				feature1 = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getMessage());
			//System.exit(1);
		}

        System.out.println("Number of Features in Core1: " + mapFeatures1.size() + " features");
	}
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels
	 * If a current noticable pixel has a neighboring noticable pixel add current 
	 * noticable pixel to a growing pixel list, which is a Feature.  Then, go thru
	 * Recursive process starting with the current noticable pixel's right neighbor
	 * Pixel.
	 */
	
	private void preorderTraversal1(Pixel p) {

		if(p !=  null && !feature1.contains(p) && p.isEdgePixel()) {  
			feature1.add(p);
			Core1noticableEdgePixelsQueue.remove(p);

			preorderTraversal1(p.getRight());
			preorderTraversal1(p.getBottom());
			preorderTraversal1(p.getTop());
			preorderTraversal1(p.getLeft());

		}
	}
	
	
	protected void findFeatures2() {
		int mapPointer2=0;
		try {
			while (!Core2noticableEdgePixelsQueue.isEmpty()) {
				preorderTraversal2(Core2noticableEdgePixelsQueue.remove());
				
				if (feature2.size()>20) mapFeatures2.put(mapPointer2, new Feature(feature2)); //, rawImage
				mapPointer2++;
				feature2 = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getMessage());
			//System.exit(1);
		}

        System.out.println("Number of Features in Core2: " + mapFeatures2.size() + " features");
	}
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels
	 * If a current noticable pixel has a neighboring noticable pixel add current 
	 * noticable pixel to a growing pixel list, which is a Feature.  Then, go thru
	 * Recursive process starting with the current noticable pixel's right neighbor
	 * Pixel.
	 */
	
	private void preorderTraversal2(Pixel p) {

		if(p !=  null && !feature2.contains(p) && p.isEdgePixel()) {  
			feature2.add(p);
			Core2noticableEdgePixelsQueue.remove(p);

			preorderTraversal2(p.getRight());
			preorderTraversal2(p.getBottom());
			preorderTraversal2(p.getTop());
			preorderTraversal2(p.getLeft());

		}
	}
	
	
	protected void findFeatures3() {
		int mapPointer3=0;
		try {
			while (!Core3noticableEdgePixelsQueue.isEmpty()) {
				preorderTraversal3(Core3noticableEdgePixelsQueue.remove());
				
				if (feature3.size()>20) mapFeatures3.put(mapPointer3, new Feature(feature3)); //, rawImage
				mapPointer3++;
				feature3 = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getMessage());
			//System.exit(1);
		}

        System.out.println("Number of Features in Core3: " + mapFeatures3.size() + " features");	
	}
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels
	 * If a current noticable pixel has a neighboring noticable pixel add current 
	 * noticable pixel to a growing pixel list, which is a Feature.  Then, go thru
	 * Recursive process starting with the current noticable pixel's right neighbor
	 * Pixel.
	 */
	
	private void preorderTraversal3(Pixel p) {

		if(p !=  null && !feature3.contains(p) && p.isEdgePixel()) { 
			feature3.add(p);
			Core3noticableEdgePixelsQueue.remove(p);

			preorderTraversal3(p.getRight());
			preorderTraversal3(p.getBottom());
			preorderTraversal3(p.getTop());
			preorderTraversal3(p.getLeft());

		}
	}
	
	
	protected void findFeatures4() {
		int mapPointer4=0;
		try {
			while (!Core4noticableEdgePixelsQueue.isEmpty()) {
				preorderTraversal4(Core4noticableEdgePixelsQueue.remove());
				
				if (feature4.size()>20) mapFeatures4.put(mapPointer4, new Feature(feature4)); //, rawImage
				mapPointer4++;
				feature4 = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getMessage());
			//System.exit(1);
		}

        System.out.println("Number of Features in Core4: " + mapFeatures4.size() + " features");	
	}
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels
	 * If a current noticable pixel has a neighboring noticable pixel add current 
	 * noticable pixel to a growing pixel list, which is a Feature.  Then, go thru
	 * Recursive process starting with the current noticable pixel's right neighbor
	 * Pixel.
	 */
	
	
	private void preorderTraversal4(Pixel p) {

		if(p !=  null && !feature4.contains(p) && p.isEdgePixel()) { 
			feature4.add(p);
			Core4noticableEdgePixelsQueue.remove(p);

			preorderTraversal4(p.getRight());
			preorderTraversal4(p.getBottom());
			preorderTraversal4(p.getTop());
			preorderTraversal4(p.getLeft());

		}
	}
	
	
	
	

	public void boxFeaturesInImage(BufferedImage b) {
		boxFeatures(b, mapFeatures1);
		boxFeatures(b, mapFeatures2);
		boxFeatures(b, mapFeatures3);
		boxFeatures(b, mapFeatures4);
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
		return edgePixList.size();
	}
	
	public int getFeatures() {
		return mapFeatures1.size() + mapFeatures2.size() + mapFeatures3.size() + mapFeatures4.size();
	}
}






