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
	private boolean isEdgePixel=false;
	
	private Pixel noticableLeft = null;
	private Pixel noticableRight = null;
	private Pixel noticableTop = null;
	private Pixel noticableBottom = null;
	

	private Pixel noticableLT = null;
	private Pixel noticableRT = null;
	private Pixel noticableLB = null;
	private Pixel noticableRB = null;
	

	//Constructor with individual RGB ints
 	public Pixel(int r, int g, int b, int X, int Y){
		rVal = r;
		gVal = g;
		bVal = b;
		xCoor=X;
		yCoor=Y;
		setrgbAverage();
	}	

	//Constructor with an RGB int array
	public Pixel(int[] pix, int X, int Y){
		rVal = pix[0];
		gVal = pix[1];
		bVal = pix[2];
		xCoor=X;
		yCoor=Y;
		setrgbAverage();
	}
	
	
////////////////////////Methods///////////////////////////////
	
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
	
	/*Every user selected image is going to have a slightly different RGB average.
	 * If the current Pixel RGB is 30 levels less than the average Image RGB value or
	 * if it is less than 30 levels total, it is considered 'noticable'.
	 * 
	 * */
	public void initializeIsNoticable(int imageAverageRGBvalue) {
		if (pixelRGBAverage < imageAverageRGBvalue-30 || pixelRGBAverage < 30) setIsNoticable(true);
		else setIsNoticable(false);		
	}
	
	
	public boolean isNoticable() {
		return isNoticable;
	}

	public void setIsNoticable(boolean isNoticable) {
		this.isNoticable = isNoticable;
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
	
	public void determineEdgePixel() {
		if (noticableLeft==null || noticableRight==null || noticableTop==null || noticableBottom==null 
				|| noticableLT==null || noticableRT==null || noticableLB==null || noticableRB==null) {
			isEdgePixel = true;
		}
		else isEdgePixel = false;
	}
	
	public boolean isEdgePixel() {
		return isEdgePixel;
	}

}
