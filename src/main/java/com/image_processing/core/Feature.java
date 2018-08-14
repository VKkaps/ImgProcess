package com.image_processing.core;

import java.util.List;

public class Feature {

	private List<Pixel> featureGroup;
	private int[] boundaryArr = new int[4];
	
	public Feature(List<Pixel> group) {
		featureGroup = group;
		findBoundary();
	}

	private void findBoundary() {

		int firstX = featureGroup.get(0).getXcoor();
		int firstY = featureGroup.get(0).getYcoor();

		int lastX = featureGroup.get(0).getXcoor();
		int lastY = featureGroup.get(0).getYcoor();
		
		
		for (Pixel p : featureGroup) {
			if (p.getXcoor() < firstX) firstX = p.getXcoor();
			if (p.getYcoor() < firstY) firstY = p.getYcoor();
			if (p.getXcoor() > lastX) lastX = p.getXcoor();
			if (p.getYcoor() > lastY) lastY = p.getYcoor();
		}
		
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
	
}



