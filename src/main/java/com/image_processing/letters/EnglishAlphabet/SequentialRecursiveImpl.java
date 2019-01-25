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


/*
 * 	SequentialRecursiveImpl is a class designed to operate purely sequentially for
 *  processing an Image.  
 * 
 * */
public class SequentialRecursiveImpl extends AbstractProcessImage{
	
	//Image is divided into 4 quadrants.  Each quadrant has its own features (letters) which are contained in these HashMaps
	private Map<Integer, Feature> mapFeatures = new HashMap<Integer, Feature>();
	
	//noticable, edge Pixel Queues for Parallelism processing purposes
	private Queue<Pixel> Core1noticableEdgePixelsQueue;
	
	//This list is used to store solely noticable, edge Pixels as opposed to all noticable Pixels in an image.
	private List<Pixel> edgePixList = new ArrayList<>();	
	
	// Fields needed for external testing/timing purposes
	private int findTime;
	private int initTime;
	private int sortTime;
	private int findFeaturesTime;
	

	public SequentialRecursiveImpl(BufferedImage b) {
		super(b);
		findNoticablePixels(); 
		initializeNeighborPixels();
		sortAndInitQueues();
		findFeatures();  
		//findAverageFeatureSize();
	}
	
	
	/*
	 * Initializes the parent field 'noticablePixList'.  A pixel is determined to be noticable if 
	 * it's average RGB value is less than (averageRGBPixelvalue - x) where x is a
	 * arbitrary int value, or the Pixel RGBAverage < 30. 
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

        System.out.println("\nClass: SequentialRecursiveImpl");             
        System.out.println("findNoticablePixels execution time: " + (endTime - startTime) + " ms");      
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
			
			/* Creates new List of noticable Edge Pixels.  Edge Pixels are what are important
			*  for building/finding Features in an image.  This optimizes performance.  If you used 
			*  every pixel in an image, the program would use too much memory, run for too long, and
			*  most likely be consumed with StackOverflow errors.
			*/
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
		
		Core1noticableEdgePixelsQueue = new LinkedList<Pixel>(noticablePixList);

		final long endTimeOut = System.currentTimeMillis();
        sortTime = Math.toIntExact(endTimeOut - startTimeOut);
        System.out.println("sortAndInitQueues execution time: " + sortTime  + " ms");	
        System.out.println("Number of noticable edge pixels: " + noticablePixList.size() + " pixels");
	}

	
	/*
	 * Take a queue of noticable edge pixels and traverse thru them grouping
	 * them into features using a recursive method "preorderTraversal".
	 * 
	 * */
	@Override
	protected void findFeatures() {
		final long startTimeOut = System.currentTimeMillis();
		
		int mapPointer=0;
		ArrayList<Pixel> feature = new ArrayList<Pixel>();	// Start with an empty arraylist, and create new one every time recursive traversal ends.
		try {
			while (!Core1noticableEdgePixelsQueue.isEmpty()) {
				preorderTraversal(Core1noticableEdgePixelsQueue.remove(), feature);
				
				if (feature.size()>20) {
					mapFeatures.put(mapPointer, new Feature(feature)); //, rawImage
					mapPointer++;
				}
				feature = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getMessage());
			//System.exit(1);
		}

        System.out.println("Number of Features: " + mapFeatures.size() + " features");
        
	    final long endTimeOut = System.currentTimeMillis();
	    findFeaturesTime = Math.toIntExact(endTimeOut - startTimeOut);
	    System.out.println("findFeatures execution time: " + findFeaturesTime  + " ms");
	}
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels.  Essentially builds Features via recursion.
	 * If a current noticable pixel has a neighboring noticable pixel add current 
	 * noticable pixel to a growing pixel list, which is a Feature.  Then, go thru
	 * Recursive process starting with the current noticable pixel's right neighbor
	 * Pixel.
	 */
	private void preorderTraversal(Pixel p, ArrayList<Pixel> feature) {

		if(p !=  null && !feature.contains(p) && p.isEdgePixel()) {  
			feature.add(p);
			Core1noticableEdgePixelsQueue.remove(p);

			preorderTraversal(p.getRight(), feature);
			preorderTraversal(p.getBottom(), feature);
			preorderTraversal(p.getTop(), feature);
			preorderTraversal(p.getLeft(), feature);

		}
	}
	
	
	
	
	////////////GETTERS/////////////

	public void boxFeaturesInImage(BufferedImage b) {
		boxFeatures(b, mapFeatures);
	}

	private void findAverageFeatureSize() {
		System.out.println("Average area of Feature in pixels: " + getAverageFeatureSize());
	}
		
	private int getAverageFeatureSize() {
		// mapFeatures1 = new HashMap<Integer, Feature>();
		Feature f = null;
		int ave=0;
		for (int i=0; i<mapFeatures.size(); i++) {
			f = mapFeatures.get(i);
			ave += f.getBoundaryArrSize();
		}
		ave = ave / mapFeatures.size();
		return ave;
	}
	
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
		return mapFeatures.size();
	}
}






