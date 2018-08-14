package com.image_processing.letters.EnglishAlphabet;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.image_processing.core.Feature;
import com.image_processing.core.Pixel;

public class Recursive extends AbstractProcessImage{
	
	
	private Map<Integer, Feature> mapFeatures = new HashMap<Integer, Feature>();
	private List<Pixel> feature = new LinkedList<Pixel>();
	private int mapPointer;
	private Queue<Pixel> noticablePixelsQueue = new LinkedList<Pixel>(noticablePixList);
	

	public Recursive(BufferedImage b) {
		super(b);
		initializeNeighborPixels();
		findFeatures();
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
	
	
	@Override
	protected void findFeatures() {
		
		try {
			while (!noticablePixelsQueue.isEmpty()) {
				preorderTraversal(noticablePixelsQueue.remove());
				if (feature.size()>10) mapFeatures.put(mapPointer, new Feature(feature));
				mapPointer++;
				feature = new LinkedList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("Stack overflow error!! -vfk");
			System.exit(1);
		}
	}
	

	/* For the each pixel, check if neighbor pixels (left, right , top, and bottom) are noticable
	 *  or not.  If so, initialize this noticable neighbor pixel in the current pixel.
	 */
	
	private void initializeNeighborPixels() {
		
		int leftX;
		int rightX;
		int topY;
		int bottomY;
		
		for (Pixel p : noticablePixList) {
			leftX = p.getXcoor()-1;
			rightX = p.getXcoor()+1;
			topY = p.getYcoor()-1;
			bottomY = p.getYcoor()+1;
			
			if (imagePixelArray[leftX][p.getYcoor()].isNoticable()) p.setLeft(imagePixelArray[leftX][p.getYcoor()]);
			if (imagePixelArray[rightX][p.getYcoor()].isNoticable()) p.setRight(imagePixelArray[rightX][p.getYcoor()]);
			if (imagePixelArray[p.getXcoor()][topY].isNoticable()) p.setTop(imagePixelArray[p.getXcoor()][topY]);
			if (imagePixelArray[p.getXcoor()][bottomY].isNoticable()) p.setBottom(imagePixelArray[p.getXcoor()][bottomY]);
		}
		
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

}



