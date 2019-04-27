package com.image_processing.core;

/*Class for an individual pixel in a digital image*/

public class Pixel implements Comparable<Pixel>{

	/*8 bit color values (0 - 255) for this Pixel*/
	private int rVal;
	private int gVal;
	private int bVal;
	
	private int pixelRGBAverage;
	
	//Coordinates of Pixel in user-provided Image
	private final int xCoor;
	private final int yCoor;	
		
	//Important Pixel attributes
	private boolean isNoticable=false;
	private boolean isEdgePixel=false;
		
	//Left, Right, Top, Bottom Neighbor Pixels
	private Pixel noticableLeft = null;
	private Pixel noticableRight = null;
	private Pixel noticableTop = null;
	private Pixel noticableBottom = null;
	
	//Corner Neighbor Pixels
	private Pixel noticableLT = null;
	private Pixel noticableRT = null;
	private Pixel noticableLB = null;
	private Pixel noticableRB = null;
	
	private boolean hasBeenProcessed = false;
	

	//Constructor with an RGB int array and coordinates
	public Pixel(int[] pix, int X, int Y){
		rVal = pix[0];
		gVal = pix[1];
		bVal = pix[2];
		xCoor=X;
		yCoor=Y;
		pixelRGBAverage = (rVal + gVal + bVal) / 3;	
	}
	
	
	////////////////////////////Methods///////////////////////////////
	
	
	/*
	 *  Print Pixel information to console.  For troubleshooting purposes.
	 *  
	 *  */
	public void printPixelRGB(){
		System.out.println("[" + xCoor + "," + yCoor + "], " + "(R" + rVal + ", G" + gVal + ", B" + bVal + ") "
				+ "rgb Ave: " + pixelRGBAverage);
		
	}
	
	
	/*Every user selected image is going to have a slightly different RGB average.
	 * If the current Pixel RGB is 30 levels less than the average Image RGB value or
	 * if it is less than 30 levels total, it is considered 'noticable'.
	 * 
	 * */
	public void initializeIsNoticable(int imageAverageRGBvalue) {
		if (pixelRGBAverage < imageAverageRGBvalue-80 || pixelRGBAverage < 50) isNoticable = true;
		else isNoticable = false;		
	}
	
	public void setIsNoticable() {
		isNoticable=true;
	}
	
	
	/* This method is called externally after initializeNeighborPixels method has run.
	 * The purpose is to check all neighbor pixels for a particular pixel, to see if the
	 * particular pixel is an edge or not.
	 * 
	 * */
	public boolean determineIfEdgePixel() {
		if (noticableLeft==null || noticableRight==null || noticableTop==null || noticableBottom==null 
				|| noticableLT==null || noticableRT==null || noticableLB==null || noticableRB==null) {
			isEdgePixel=true;
			return true;
		}
		else {
			isEdgePixel=false;
			return false;
		}
	}
	

	@Override
	public int compareTo(Pixel p) {
		return (this.getXcoor() - p.getXcoor());
	}
	

	
	
///////////////////////////SETTERS&GETTERS///////////////////////////////////
	
	public boolean isNoticable() {
		return isNoticable;
	}
	
	public Pixel getLeft() {
		return noticableLeft;
	}


	public void setLeft(Pixel left) {
		this.noticableLeft = left;
	}


	public Pixel getRight() {
		return noticableRight;
	}


	public void setRight(Pixel right) {
		this.noticableRight = right;
	}


	public Pixel getTop() {
		return noticableTop;
	}


	public void setTop(Pixel top) {
		this.noticableTop = top;
	}


	public Pixel getBottom() {
		return noticableBottom;
	}


	public void setBottom(Pixel bottom) {
		this.noticableBottom = bottom;
	}
	
	public Pixel getNoticableLT() {
		return noticableLT;
	}

	public void setNoticableLT(Pixel noticableLT) {
		this.noticableLT = noticableLT;
	}

	public Pixel getNoticableRT() {
		return noticableRT;
	}

	public void setNoticableRT(Pixel noticableRT) {
		this.noticableRT = noticableRT;
	}

	public Pixel getNoticableLB() {
		return noticableLB;
	}

	public void setNoticableLB(Pixel noticableLB) {
		this.noticableLB = noticableLB;
	}

	public Pixel getNoticableRB() {
		return noticableRB;
	}

	public void setNoticableRB(Pixel noticableRB) {
		this.noticableRB = noticableRB;
	}


	public void setrVal(int rVal) {
		this.rVal += rVal;
	}


	public void setgVal(int gVal) {
		this.gVal += gVal;
	}


	public void setbVal(int bVal) {
		this.bVal += bVal;
	}
	
	public int getrVal() {
		return rVal;
	}

	public int getgVal() {
		return gVal;
	}

	public int getbVal() {
		return bVal;
	}

	public int getXcoor() {
		return xCoor;
	}

	public int getYcoor() {
		return yCoor;
	}
	
	public int getrgbAverage() {
		return pixelRGBAverage;
	}
	
	public boolean isEdgePixel() {
		return isEdgePixel;
	}
	
	public void processed() {
		hasBeenProcessed = true;
	}
	
	public boolean hasBeenProcessed() {
		return hasBeenProcessed;
	}

}
