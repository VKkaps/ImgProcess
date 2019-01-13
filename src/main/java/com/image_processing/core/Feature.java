package com.image_processing.core;

import java.awt.image.BufferedImage;
import java.util.List;

public class Feature {

	private List<Pixel> featureGroup;  //List of Pixels in a Feature
	private int[] boundaryArr = new int[4];  //4 outer most points around the Feature (for Boxing purposes)
	BufferedImage featureImage = null;  //Used to save Feature jpg image to a absolute file location
	
	
	public Feature(List<Pixel> group) {
		featureGroup = group;
		findBoundary();
	}
	
	public Feature(List<Pixel> group, BufferedImage rawImage) {
		featureGroup = group;
		findBoundary();
		saveFeature(rawImage);
	}

	
	/*Optional:  Export Feature as a jpg image to an absolute path directory*/
	private void saveFeature(BufferedImage rawImage) {
		featureImage = rawImage.getSubimage(boundaryArr[0], boundaryArr[1], (boundaryArr[2] - boundaryArr[0]), (boundaryArr[3] - boundaryArr[1]));
		AbstractProcessImage.outputFile(featureImage, "C:/sample_images/Features/", "feature "
				+ boundaryArr[0] + ", " + boundaryArr[1], "jpg");
		System.out.println("Feature images saved to C:/sample_images/Features/");
		
	}

	private void findBoundary() {

		int firstX = featureGroup.get(0).getXcoor();
		int firstY = featureGroup.get(0).getYcoor();

		int lastX = featureGroup.get(0).getXcoor();
		int lastY = featureGroup.get(0).getYcoor();
		
		for (Pixel p : featureGroup) {
			if (p.getXcoor() < firstX) firstX = p.getXcoor();
			if (p.getYcoor() < firstY) {
				firstY = p.getYcoor();
			}
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
		
	public Pixel[][] getFeaturePixelsAs2DArray() {
		return (Pixel[][]) featureGroup.toArray();
		
	}
	
}



