package com.image_processing.core;

public class Pixel {

	private int rVal;
	private int gVal;
	private int bVal;
	
	private int pixelRGBAverage;
	
	private final int xCoor;
	private final int yCoor;	
		
	private boolean isNoticable;
	private boolean isSurronded;
	
	
	private Pixel left = null;
	private Pixel right = null;
	private Pixel top = null;
	private Pixel bottom = null;
	

	//Constructor with individual ints
 	public Pixel(int r, int g, int b, int X, int Y){
		rVal = r;
		gVal = g;
		bVal = b;
		xCoor=X;
		yCoor=Y;
		isNoticable=false;
		isSurronded=false;
		setrgbAverage();
	}
	

	//Constructor with an int array
	public Pixel(int[] pix, int X, int Y){
		rVal = pix[0];
		gVal = pix[1];
		bVal = pix[2];
		xCoor=X;
		yCoor=Y;
		isNoticable=false;
		isSurronded=false;
		setrgbAverage();
	}
	
	
	private void setrgbAverage() { 
		pixelRGBAverage = (rVal + gVal + bVal) / 3;		
	}

	
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
	
	public Pixel getLeft() {
		return left;
	}


	public void setLeft(Pixel left) {
		this.left = left;
	}


	public Pixel getRight() {
		return right;
	}


	public void setRight(Pixel right) {
		this.right = right;
	}


	public Pixel getTop() {
		return top;
	}


	public void setTop(Pixel top) {
		this.top = top;
	}


	public Pixel getBottom() {
		return bottom;
	}


	public void setBottom(Pixel bottom) {
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
		
		if (this.left!=null && this.right!=null && this.top!=null && this.bottom != null) isSurronded = true;
		else isSurronded = false;
	}

}
