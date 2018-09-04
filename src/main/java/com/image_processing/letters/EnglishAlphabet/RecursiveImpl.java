package main.java.com.image_processing.letters.EnglishAlphabet;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import main.java.com.image_processing.core.Feature;
import main.java.com.image_processing.core.Pixel;

public class RecursiveImpl extends AbstractProcessImage{
	
	
	private Map<Integer, Feature> mapFeatures = new HashMap<Integer, Feature>();
	private List<Pixel> feature = new LinkedList<Pixel>();
	private int mapPointer;
	private Queue<Pixel> noticablePixelsQueue;
		
	private List<Pixel> filteredPixList = new LinkedList<>();
	
	

	public RecursiveImpl(BufferedImage b) {
		super(b);
		initializeNeighborPixels();
		findFeatures();
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

        System.out.println("initializeNeighborPixels execution time: " + (endTime - startTime) );
        

	}

	
	
	
	
	@Override
	protected void findFeatures() {
		noticablePixelsQueue = new LinkedList<Pixel>(noticablePixList);

        final long startTimeOut = System.currentTimeMillis();
		try {
			while (!noticablePixelsQueue.isEmpty()) {
				preorderTraversal(noticablePixelsQueue.remove());
		       
				if (feature.size()>10) mapFeatures.put(mapPointer, new Feature(feature));
				mapPointer++;
				feature = new LinkedList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getLocalizedMessage());
			//System.exit(1);
		}
        final long endTimeOut = System.currentTimeMillis();

        System.out.println("findFeatures execution time: " + (endTimeOut - startTimeOut) );		
	}
	
	
	
	/*
	 * Recursive PreOrder Traversal of noticablePixels
	 * If a noticable pixel has a neighboring noticable pixel add pixel to a growing pixel 
	 * list, which is a Feature.
	 */
	
	private void preorderTraversal(Pixel p) {

			if(p !=  null && !feature.contains(p) && p.isEdgePixel()) {
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
		System.out.println("Number of Features: " + mapFeatures.size());

		for (Feature f : mapFeatures.values()) {
			if (f.isExternal()) drawNeonBox(rawImage, f.getBoundaryArr());
		}	
		return rawImage;
	}
	
}



