package com.image_processing.core;

import java.util.List;

public class Feature {

	private List<Pixel> featureGroup;  //List of Pixels in a Feature
	private int[] boundaryArr = new int[4];  //4 outer most points around the Feature (for Drawing purposes)
	private Pixel topMostPix;
	
	public Feature(List<Pixel> group) {
		featureGroup = group;
		findBoundary();
	}

	private void findBoundary() {

		int firstX = featureGroup.get(0).getXcoor();
		int firstY = featureGroup.get(0).getYcoor();

		int lastX = featureGroup.get(0).getXcoor();
		int lastY = featureGroup.get(0).getYcoor();
		
		int i=0;
		int hold=0;
		for (Pixel p : featureGroup) {
			if (p.getXcoor() < firstX) firstX = p.getXcoor();
			if (p.getYcoor() < firstY) {
				firstY = p.getYcoor();
				hold=i;
			}
			if (p.getXcoor() > lastX) lastX = p.getXcoor();
			if (p.getYcoor() > lastY) lastY = p.getYcoor();
			i++;
		}
		
		topMostPix = featureGroup.get(hold);
		//topMostPix.printPixelRGB();

		boundaryArr[0] = firstX;
		boundaryArr[1] = firstY;
		boundaryArr[2] = lastX;
		boundaryArr[3] = lastY;
	
	}
	
	public List<Pixel> getFeatureGroup() {
		return featureGroup;
	}

	public int[] getBoundaryArr() {
		return boundaryArr;
	}
	
	
	public boolean isExternal() {

//		if (topMostPix.getBottom()==null || topMostPix.getRight()==null || topMostPix.getNoticableRB()==null) {
//			return false;
//		}
		
		 return true;	
	}
	
	
	public Pixel[][] getFeaturePixelsAs2DArray() {
		return (Pixel[][]) featureGroup.toArray();
		
	}
	
}



