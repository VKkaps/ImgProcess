package com.image_processing.core;

/*Class for an individual pixel in a digital image*/


public class Pixel {

	/*8 bit color values (0 - 255) for this Pixel*/
	private int rVal;
	private int gVal;
	private int bVal;
	
	private int pixelRGBAverage;
	
	private final int xCoor;
	private final int yCoor;	
		
	private boolean isNoticable=false;
	private boolean isSurronded=false;
	
	
	private Pixel left = null;
	private Pixel right = null;
	private Pixel top = null;
	private Pixel bottom = null;
	

	//Constructor with individual color ints, and x,y coordinates
 	public Pixel(int r, int g, int b, int X, int Y){
		rVal = r;
		gVal = g;
		bVal = b;
		xCoor=X;
		yCoor=Y;
		setrgbAverage();
	}
	

	//Constructor with an int array, and x,y coordinates
	public Pixel(int[] pix, int X, int Y){
		rVal = pix[0];
		gVal = pix[1];
		bVal = pix[2];
		xCoor=X;
		yCoor=Y;
		setrgbAverage();
	}
	
	
	// Find the average RGB value of the pixel
	private void setrgbAverage() { 
		pixelRGBAverage = (rVal + gVal + bVal) / 3;		
	}

	// Console print Pixel information.  For troubleshooting purposes.
	public void printPixelRGB(){
		System.out.println("[" + xCoor + "," + yCoor + "], " + "(R" + rVal + ", G" + gVal + ", B" + bVal + ") "
				+ "rgb Ave: " + pixelRGBAverage);
		
	}
	
	public int[] getPixelRGBArray() {
		int[] rgb = {rVal, gVal, bVal};
		return rgb;
	}
	
	
	public void initializeIsNoticable(int imageAverageRGBvalue) {
		if (pixelRGBAverage < imageAverageRGBvalue-25) setIsNoticable(true);
		else setIsNoticable(false);		
	}
	
	
	public boolean isNoticable() {
		return isNoticable;
	}

	public void setIsNoticable(boolean isNoticable) {
		this.isNoticable = isNoticable;
	}	
	
	public Pixel getLeftNeighborPixel() {
		return left;
	}


	public void setLeftNeighborPixel(Pixel left) {
		this.left = left;
	}


	public Pixel getRightNeighborPixel() {
		return right;
	}


	public void setRightNeighborPixel(Pixel right) {
		this.right = right;
	}


	public Pixel getTopNeighborPixel() {
		return top;
	}


	public void setTopNeighborPixel(Pixel top) {
		this.top = top;
	}


	public Pixel getBottomNeighborPixel() {
		return bottom;
	}


	public void setBottomNeighborPixel(Pixel bottom) {
		this.bottom = bottom;
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


	public boolean isSurronded() {
		return isSurronded;
	}


	public void setIsSurronded(boolean isSurronded) {
		
		if (this.left!=null && this.right!=null && this.top!=null && this.bottom != null) this.isSurronded = true;
		else this.isSurronded = false;
	}
	
	public boolean isEdgePixel() {
		if (isSurronded) return false;
		else return true;
	}

}
