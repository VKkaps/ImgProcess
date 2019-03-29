package com.image_processing.core;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

public class Feature {

	private Integer[][] featureIntArray;
	private List<Pixel> featureGroup;  //ArrayList of Pixels in a Feature sorted in X direction
	private int[] boundaryArr = new int[4];  //4 outer most points around the Feature (for Boxing purposes)
	private int featureWidth;
	private int featureHeight;
	private BufferedImage featureImage = null;  //Used to save Feature jpg image to a absolute file location

	
	////////////new//////////////////
	private double[] topViewPercentages;
	private double[] bottomViewPercentages;
	private double[] rightViewPercentages;
	private double[] leftViewPercentages;
	private double averageEdgePercentage;
	
	private int topLargeChange = 0;
	private int bottomLargeChange = 0;
	private int leftLargeChange = 0;
	private int rightLargeChange = 0;
	
	private int topTransitions = 0;
	private int bottomTransitions = 0;
	private int leftTransitions = 0;
	private int rightTransitions = 0;
	
	private boolean hasPixelInMiddle = false;
	private double d = 0.0;
	
	String letter = "_";

	
/////////////////////////////////////////////////////////////////////////////////
	

 	public Feature(List<Pixel> featureGroup) {
		this.featureGroup = featureGroup;
		init();
	}
	
	public Feature(List<Pixel> featureGroup, BufferedImage rawImage, int index, String[] stringArr) {
		this.featureGroup = featureGroup;
		init();
		saveFeature(rawImage, index, stringArr);
	}

	private void init() {
		Collections.sort(featureGroup); //Sort featureGroup by X coordinate
		findBoundaryOfFeature();
		createFeatureIntegerArray();
		findTiers();
		findMiddle();
		//findQuarter();
		findPercentOfPixelsInUpperHalf();
		identifyFeatureNew();
		//printPercentages();
		//System.out.println(hasPixelInMiddle);
		//System.out.println(letter);
	}
	
	private void findMiddle() {
		if (featureWidth>4) {
			int x = (featureIntArray.length/2)+1;
			Integer[] arr = featureIntArray[x];
			int index1 = arr.length/2;
			int index2 = arr.length/2 + 1;
			int index3 = arr.length/2 + 2;
			
			if (arr[index1]==1 || arr[index2]==1 || arr[index3]==1) {
				hasPixelInMiddle=true;
			}
		}
		else hasPixelInMiddle=true;


	}
	
	private boolean hasPixelsInMiddle() {

			int x = (featureIntArray.length/2)+1;
			Integer[] arr = featureIntArray[x];
			int y = arr.length/2;
			
			int index1 = y-1;
			int index2 = y;
			int index3 = y+1;
			
			if (arr[index1]==1 || arr[index2]==1 || arr[index3]==1) {
				return true;
			}
			else return false;
		
	}
	
	private void findQuarter() {
		int x = (featureIntArray.length/4)*3;
		Integer[] arr = featureIntArray[x];
		int index1 = arr.length/2;
		int index2 = arr.length/2 + 1;
		int index3 = arr.length/2 + 2;
		
		if (arr[index1]==1 || arr[index2]==1 || arr[index3]==1) {
			hasPixelInMiddle=true;
		}

	}
	
	private void findPercentOfPixelsInUpperHalf() {
		int half = featureHeight/2;
		int count1=0;
		int count2=0;
		for (int x=0; x<featureWidth; x++) {
			for (int y=0; y<half; y++) {
				if (featureIntArray[x][y]==1) count1++;
			}
		}
		for (int x=0; x<featureWidth; x++) {
			for (int y=half; y<featureHeight; y++) {
				if (featureIntArray[x][y]==1) count2++;
			}
		}
		
		d = round((double)count1/(double)count2,2);
		
	}
	

	private void identifyFeatureNew() {
		// C curved, left side
		// C,c,G,Q,S,s,8
		// e,O,o
		if (leftViewPercentages[3]>=0.02 && leftViewPercentages[4]>=0.08){
			
			if (rightLargeChange>=2 && hasPixelInMiddle==false && topViewPercentages[0]<0.42) {
				letter = "c";
			}
			else if (leftTransitions==1 && rightTransitions==3 && hasPixelInMiddle==true
					&& d>=1.0 && rightLargeChange==2){
			letter = "e";
			}
			else if (topTransitions<2 && bottomTransitions==1 && leftTransitions==1 
					&& rightTransitions==1 && topViewPercentages[2]>0.1){
				letter = "O";
			}
			else if (topTransitions<2 && leftTransitions==1 && rightTransitions==1 
					&& topViewPercentages[1]>0.13 && rightLargeChange<1){
				letter = "o";
			}
			else if (leftTransitions==1 && rightTransitions>=2 && hasPixelInMiddle==true
						&& d<0.99){
				letter = "G";
			}
			else if (hasPixelInMiddle==false && leftTransitions==1 && rightTransitions>=2 && bottomViewPercentages[2]>0.24){
				letter = "Q";
			}
			else if (leftTransitions==3 && rightTransitions==3 && rightLargeChange==0
					&& hasPixelInMiddle==true){
				letter = "8";
			}
			else if (leftTransitions>=2 && rightTransitions>=2 && leftLargeChange>0
					&& rightLargeChange>0 && topViewPercentages[0]<0.54){
				letter = "s";
			}

		}
		
		//Column, left side
		// B,D,E,F,H,I,J,K,L,M,N,P,R,T,b,h,i,j,k,l,m,n,p,r,,u
		if (leftViewPercentages[0]>0.6) {
			letter = "leftColumn";
			if (hasPixelInMiddle==false && rightViewPercentages[1]>0.02) {
				letter = "D";
			}
			else if (hasPixelInMiddle==false && bottomTransitions>0 && topViewPercentages[2] <= 0.16) {
				letter = "J";
			}
			else if (hasPixelInMiddle==false && rightViewPercentages[3]>0.03 && topViewPercentages[2] <= 0.16) {
				letter = "b";
			}
			if (leftViewPercentages[0]>0.65 && rightViewPercentages[3]>0.2 && rightViewPercentages[4]>0.2) {
				letter = "K";
			}
			if (hasPixelInMiddle==true) {
				if (rightLargeChange<2 && rightTransitions==3) {
					letter = "B";
				}
				else if(rightTransitions==2 && bottomLargeChange>0 && 
						rightViewPercentages[4]>0.26 && topViewPercentages[1]<0.1) {
					letter = "R";
				}
				else if(rightTransitions==2 || rightTransitions==1 && bottomLargeChange>0 && bottomViewPercentages[4]<0.05) {
					letter = "P";
				}
			}
			if (leftViewPercentages[0]>0.65 && rightViewPercentages[0]>0.65
					&& topViewPercentages[0]>0.45 && bottomViewPercentages[0]>0.45) {
				if (topViewPercentages[0]>0.8 && rightLargeChange>2
						&& bottomLargeChange>=2) {
					letter = "F";
				}
				else if (topViewPercentages[0]>0.8 && rightLargeChange>2
						&& bottomLargeChange<2) {
					letter = "E";
				}
				else if(topLargeChange>=2 && bottomLargeChange>=2 && bottomViewPercentages[1] < 0.05) {
					letter = "H";
				}
				else if(topLargeChange==0 && bottomLargeChange==0 && rightLargeChange<3) {
					letter = "I";
				}
				else if(rightLargeChange>0 && topLargeChange >0 && topViewPercentages[1]<0.06) {
					letter = "L";
				}
				else if (bottomLargeChange>=2 && leftLargeChange>=1) {
					letter = "T";
				}
				else if (hasPixelInMiddle==false && bottomTransitions==1 && bottomLargeChange<2) {
					letter = "U";
				}
				else if (bottomLargeChange>=2 && leftTransitions>0) {
					letter = "f";
				}
				else if (topViewPercentages[1]>0.05 && rightViewPercentages[4]>0.02 && topTransitions<3) {
					letter = "h";
				}
				else if (hasPixelInMiddle==false && bottomTransitions>0 
						&& topViewPercentages[2] <= 0.16 && rightViewPercentages[3]<0.03) {
					letter = "J";
				}
				else letter = "turd";
			}	
		}
		
		// Falling, edge left side  OR Rising, edge right side
		if (leftViewPercentages[4]>0.15 && rightViewPercentages[3]>0.12
				&& topTransitions==1 && bottomTransitions==1 
				&& rightLargeChange<2 && topViewPercentages[2]<0.10) {
			if (!hasPixelsInMiddle()) letter = "v";
		}
		else if (bottomTransitions>=2 && leftViewPercentages[4]>0.2 && leftViewPercentages[3]<0.03) {
			letter = "w";
		}
		// Rising, edge left side
		if (leftViewPercentages[3]>0.25 && rightViewPercentages[4]>0.20 
				&& topTransitions==1 && bottomTransitions>=1 && leftTransitions<2) {
			letter = "A";
		}
		if (leftViewPercentages[3] > 0.41 && rightViewPercentages[3] > 0.41 &&
				topViewPercentages[0] > 0.6 && bottomViewPercentages[0] > 0.8) {
			letter = "z";
		}
		if (leftViewPercentages[3] > 0.15 && leftViewPercentages[4] > 0.15
				&& rightViewPercentages[3] > 0.15 && rightViewPercentages[4] > 0.15
				&& bottomViewPercentages[0]<0.6) {
			if (hasPixelsInMiddle()) letter = "x";
		}
		if (rightTransitions>=2 && leftTransitions>3 && topViewPercentages[1]>0.07) {
			letter = "3";
		}

	}

	private void identifyFeature() {

		if (leftViewPercentages[0] < 0.6) {

			/*
			 * 
			 * c,e
			 * C,G,O,Q
			 * 
			 * */
			if (averageEdgePercentage <= 0.6 && leftTransitions==1) {
				if (topTransitions==1 && bottomTransitions==1 && rightTransitions==1 && 
						leftViewPercentages[3] > 0.14) {
					letter = "O";
				}
				else if (topTransitions==1 && bottomTransitions==2 && rightTransitions==2) {
					letter = "Q";
				}
				else if (rightViewPercentages[0] < 0.7 && rightViewPercentages[0] > 0.3 && rightTransitions>1) {
					letter = "C";
				}
				else if (leftTransitions==1 && rightTransitions==1 && bottomTransitions==1 
						&& rightViewPercentages[4]>0.15 && bottomLargeChange<=1) {
					letter = "X";
				}
				else if(topTransitions == 1 && bottomLargeChange>1) {
					letter = "Y";
				}
			}
			
			
			
			/*
			 * handle 4,a,z,Z
			 * */
			else if (averageEdgePercentage <= 0.6) {
				
				// a
				if (leftViewPercentages[3] < 0.35 && bottomViewPercentages[0] < 0.66 &&
						topViewPercentages[4] < 0.7 && leftTransitions > 0 && rightLargeChange == 0
						&& rightTransitions == 0) {
					letter = "a";
				}
				
				else if(leftViewPercentages[3] > 0.25 && rightViewPercentages[4] > 0.25
						&& leftViewPercentages[4] < 0.1){
					letter = "A";
				}
				
				else if(leftTransitions>=2 && rightTransitions>=2) {
					letter = "S";
				}
				
				else if(bottomViewPercentages[3]>0.25 && bottomViewPercentages[4]>0.25 && bottomTransitions != 3) {
					letter = "V";
				}
				
				else if(bottomTransitions == 3) {
					letter = "W";
				}
				else if(topTransitions == 1 && bottomLargeChange>1) {
					letter = "Y";
				}
				
				// z or Z
				else if (leftViewPercentages[3] > 0.41 && rightViewPercentages[3] > 0.41 &&
						topViewPercentages[0] > 0.6 && bottomViewPercentages[0] > 0.8) {
					letter = "Z";
				}
				else if (leftViewPercentages[3] > 0.24 && rightViewPercentages[3] < 0.15) {
					letter = "4";
				}
				else if (leftTransitions==3 && rightTransitions==3 &&
						leftLargeChange==0 && rightLargeChange==0) {
					letter = "8";
				}
				else if (rightTransitions==3 && leftTransitions!=1 && rightLargeChange==0) {
					letter = "3";
				}
				else if (rightTransitions==1 && topTransitions==1 && leftTransitions > 1) {
					letter = "9";
				}
			}
			
			else if (averageEdgePercentage < 0.7 && averageEdgePercentage > 0.5) {
				// z or Z
				if (leftViewPercentages[3] > 0.41 && rightViewPercentages[3] > 0.41 &&
						topViewPercentages[0] > 0.6 && bottomViewPercentages[0] > 0.8) {
					letter = "Z";
				}
				else if (topTransitions==2 && rightViewPercentages[0]>0.44
						&& leftViewPercentages[0]<0.62) {
					letter = "d";
				}
			}
		

			
			
		}
		else if (leftViewPercentages[0] >= 0.6) {
			//A, W
			if(leftViewPercentages[3] > 0.25 && rightViewPercentages[4] > 0.25){
				letter = "A";
			}
			else if(bottomTransitions == 3 && leftViewPercentages[4]>0.05) {
				letter = "W";
			}
			// 1
			// b,h,j,l,u
			// B,D,E,F,H,I,J,L,M,N,U,P,R,T
			if (rightTransitions==0) {
				
				if (topTransitions==0) {
					if (bottomLargeChange==2) {
						letter = "T";
					}
					else if (bottomViewPercentages[1] > 0.07 && topLargeChange==1) {
						letter = "j";
					}
					else if (leftTransitions==2 && topLargeChange==1 && leftViewPercentages[1] > 0.02) {
						letter = "J";
					}
					else if (leftTransitions==1 && bottomLargeChange>2 && leftViewPercentages[1] > 0.02) {
						letter = "J";
					}
					else if (topLargeChange==1) {
						letter = "L";
					}
					else if (leftTransitions >= 1 && topViewPercentages[1] > 0.07) {
						letter = "1.";
					}
					else if (leftTransitions < 1) {
						letter = "l";
					}
				}
				else if (topTransitions==1) {		
					if (topLargeChange==2 && bottomTransitions==1 && rightViewPercentages[3] > 0.09) {
						letter = "U";
					}
					else if (topLargeChange==2 && bottomLargeChange==2) {
						letter = "H";
					}
					else if (topLargeChange==2 && bottomTransitions==2) {
						letter = "u";
					}
					else if (leftTransitions ==2 && topViewPercentages[1] > 0.07 && bottomLargeChange == 1) {
						letter = "1.";
					}
					else if (bottomLargeChange==3 || bottomLargeChange==1 && 
							leftViewPercentages[0]>0.59 && rightViewPercentages[0]>0.66) {
						letter = "N";
					}
					else if (bottomTransitions==3) {
						letter = "M";
					}
					else if (bottomTransitions==1 && bottomViewPercentages[1] > 0.08 &&
							rightViewPercentages[3] > 0.04 && rightViewPercentages[3] < 0.22) {
						letter = "J";
					}
					else if (leftTransitions == 2) {
						letter = "l";
					}
					
				}
				else if (topTransitions==2 && rightViewPercentages[0]>0.44
						&& leftViewPercentages[0]<0.62) {
					letter = "d";
				}
				else if (topLargeChange>0 && topTransitions==2 || topTransitions==3 && bottomTransitions != 3) {
					letter = "h";
				}
				
			}
			else if (rightTransitions > 0) {
				if (rightTransitions==1) {
					if (topLargeChange==2 && bottomLargeChange==2) {
						letter = "H";
					}
					else if (bottomTransitions==3 && topTransitions==2) {
						letter = "u";
					}
					else if (rightViewPercentages[3]>0.18) {
						letter = "K";
					}
					else if (topLargeChange>0 && topViewPercentages[0] < 0.62) {
						letter = "b";
					}
					else if (topTransitions==0 && bottomLargeChange==2) {
						letter = "T";
					}
					else if (bottomTransitions==3 && bottomLargeChange==2) {
						letter = "M";
					}
					else if (leftTransitions==1 && rightViewPercentages[0] > 0.7) {
						letter = "I";
					}
					else if (rightViewPercentages[3] > 0.13 && rightViewPercentages[0]<0.57) {
						letter = "D";
					}
					else if (rightViewPercentages[0] < 0.7 && topLargeChange==0 && rightLargeChange==1) {
						letter = "P";
					}
				}
				else if (rightTransitions==2) {
					if (topLargeChange==1 && bottomTransitions==0 && leftTransitions<1) {
						letter = "L";
					}
					else if (rightViewPercentages[0] < 0.7 && topLargeChange==0 && rightLargeChange==1) {
						letter = "P";
					}
					else if (leftLargeChange < 1 && rightLargeChange <= 1 && 
							bottomLargeChange<2 && topTransitions<1){
						letter = "R";
					}
					else if (leftLargeChange < 1 && rightLargeChange <= 1 && 
							bottomLargeChange<2 && topTransitions>=1 && rightViewPercentages[4] > 0.1){
						letter = "k";
					}
					else if (rightLargeChange==3 && bottomLargeChange==2) {
						letter = "F";
					}
					else if (topTransitions==0 && bottomLargeChange==2) {
						letter = "T";
					}
				}
				else if (rightLargeChange==3 && bottomLargeChange==2) {
					letter = "F";
				}
				else if (rightLargeChange>=4) {
					letter = "E";
				}
				else if (rightTransitions==3) {
					//B
					if (bottomViewPercentages[1] >= 0.06) {
						letter = "B";
					}					
				}				
			}
		}
	}
	
	private void printPercentages() {
		System.out.print("\nTop: [");
		System.out.println(topViewPercentages[0] + "," + topViewPercentages[1] + "," +
				topViewPercentages[2] + "," + topViewPercentages[3] + "," + topViewPercentages[4] + "]");
		
		System.out.print("Bottom: [");
		System.out.println(bottomViewPercentages[0] + "," + bottomViewPercentages[1] + "," +
				bottomViewPercentages[2] + "," + bottomViewPercentages[3] + "," + bottomViewPercentages[4] + "]");
		
		System.out.print("Right: [");
		System.out.println(rightViewPercentages[0] + "," + rightViewPercentages[1] + "," +
				rightViewPercentages[2] + "," + rightViewPercentages[3] + "," + rightViewPercentages[4] + "]");
		
		System.out.print("Left: [");
		System.out.println(leftViewPercentages[0] + "," + leftViewPercentages[1] + "," +
				leftViewPercentages[2] + "," + leftViewPercentages[3] + "," + leftViewPercentages[4] + "]");
		
		System.out.println("topLargeChange: " + topLargeChange);
		System.out.println("topTransitions: " + topTransitions);
		
		System.out.println("bottomLargeChange: " + bottomLargeChange);
		System.out.println("bottomTransitions: " + bottomTransitions);
		
		System.out.println("leftLargeChange: " + leftLargeChange);
		System.out.println("leftTransitions: " + leftTransitions);
		
		System.out.println("rightLargeChange: " + rightLargeChange);
		System.out.println("rightTransitions: " + rightTransitions);
		
		System.out.println("aveEdge: " + averageEdgePercentage);
	}
	
	/*Optional:  Export Feature as a jpg image to an absolute path directory*/
	private void saveFeature(BufferedImage rawImage, int index, String[] stringArr) {
		int firstX = boundaryArr[0]-2;
		int lastX = boundaryArr[2]+2;
		int firstY = boundaryArr[1]-2;
		int lastY = boundaryArr[3]+2;
		
		featureImage = rawImage.getSubimage(firstX, firstY, (lastX - firstX), (lastY - firstY));
		AbstractProcessImage.outputFile(featureImage, "C:/sample_images/Features/", 
				stringArr[index], "jpg");
	}
	
	
	/*
	 * Find outer-most X, coordinates of the feature.  Used to box Features.
	 * */
	private void findBoundaryOfFeature() {
		
		//firstX
		boundaryArr[0] = featureGroup.get(0).getXcoor();
		//lastX
		boundaryArr[2] = (featureGroup.get(featureGroup.size()-1).getXcoor()+1);

		int first = featureGroup.get(0).getYcoor();
		int last = featureGroup.get(0).getYcoor();
		
		for (Pixel p : featureGroup) {
			if (p.getYcoor() < first) {
				first = p.getYcoor();
			}
			if (p.getYcoor() > last) last = p.getYcoor();
		}
		
		boundaryArr[1] = first;
		boundaryArr[3] = last+1;
		
		featureWidth = boundaryArr[2] - boundaryArr[0];
		featureHeight = boundaryArr[3] - boundaryArr[1];
	}
		
	/*
	 * Loads a 2D Integer Array comprised with the same size as the feature.
	 * int value of 1 means noticable, int value of 0 means not noticable
	 * 
	 * */
	private void createFeatureIntegerArray() {
		featureIntArray = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
	}
	
	
	public void findTiers() {
		findTopTierPixels();
		findBottomTierPixels();
		findLeftTierPixels();
		findRightTierPixels();
		findAverageEdgePercentage();
	}
	
	private void findTopTierPixels() {
		int [] topTier = new int[featureWidth];
		int index = 0;
		
		for(int x=0; x<featureWidth; x++) {
			for (int y=0; y<featureHeight; y++) {
				if(featureIntArray[x][y]==1) {
					topTier[x] = index;
					break;
				}
				index++;
			}
			index=0;
		}
		
		topViewPercentages = determineTopFlatCurveColumnPercentagesY(topTier);
		
	}
	
	private void findBottomTierPixels() {
		int[] bottomTier = new int[featureWidth];
		int index = 0;
		
		for(int x=0; x<featureWidth; x++) {
			for (int y=featureHeight-1; y>-1; y--) {
				if(featureIntArray[x][y]==1) {
					bottomTier[x] = featureHeight-index;
					break;
				}
				index++;
			}
			index=0;
		}
		
		bottomViewPercentages = determineBottomFlatCurveColumnPercentagesY(bottomTier);
		
	}
	
	private void findLeftTierPixels() {
		int[] leftTier = new int[featureHeight];
		int index = 0;
		
		for(int y=0; y<featureHeight; y++) {
			for (int x=0; x<featureWidth; x++) {
				if(featureIntArray[x][y]==1) {
					leftTier[y] = index;
					break;
				}
				index++;
			}
			index=0;
		}
		
		leftViewPercentages = determineLeftFlatCurveRowPercentagesX(leftTier);
		
	}
	
	private void findRightTierPixels() {
		int[] rightTier = new int[featureHeight];
		int index = 0;
		
		for(int y=0; y<featureHeight; y++) {
			for (int x=featureWidth-1; x>-1; x--) {
				if(featureIntArray[x][y]==1) {
					rightTier[y] = featureWidth-index;
					break;
				}
				index++;
			}
			index=0;
		}
		
		rightViewPercentages = determineRightFlatCurveRowPercentagesX(rightTier);
		
	}
	
	
	
	private double[] determineTopFlatCurveColumnPercentagesY(int[] deltaY) {
		int curr;
		int next;
		int total = deltaY.length;
		
		int row=0;
		int upwardCurve=0;
		int downwardCurve=0;
		int upwardEdge=0;
		int downwardEdge=0;
		
		boolean neg = false;
		boolean pos = false;
		
		
		
		for (int i=0; i<deltaY.length-1; i++) {
			next = deltaY[i+1];
			curr = deltaY[i];
			int change = next - curr;
			
			int currentState = (int) Math.signum(change);
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;
			
			if (pos == true && neg == true) {
				topTransitions++;
				neg = false;
				pos = false;
			}
			
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;
			
			
			int thresh = (int)(0.3*featureHeight)+1;

			//System.out.println(change);
			if (change == 0) row++;
			else if (change == -1) upwardCurve++;
			else if (change == 1)  downwardCurve++;
			else if (-thresh < change && change < -1) upwardEdge++;
			else if (1 < change && change < thresh) downwardEdge++;	
			else topLargeChange++;
		}
		//System.out.println("Toptransitions: " + topTransitions);
		double rowPercentage = round((double)row/(double)total,2);
		double upwardCurvePercentage = round((double)upwardCurve/(double)total,2);
		double downwardCurvePercentage = round((double)downwardCurve/(double)total,2);
		double upwardEdgePercentage = round((double)upwardEdge/(double)total,2);
		double downwardEdgePercentage = round((double)downwardEdge/(double)total,2);
		
		double[] percentages = new double[] {rowPercentage, upwardCurvePercentage,
				downwardCurvePercentage, upwardEdgePercentage, downwardEdgePercentage};
		
		return percentages;
	}
	
	private double[] determineBottomFlatCurveColumnPercentagesY(int[] deltaY) {
		int curr;
		int next;
		int total = deltaY.length;
		
		int row=0;
		int upwardCurve=0;
		int downwardCurve=0;
		int upwardEdge=0;
		int downwardEdge=0;
		
		boolean neg = false;
		boolean pos = false;

		for (int i=0; i<deltaY.length-1; i++) {
			next = deltaY[i+1];
			curr = deltaY[i];
			int change = next - curr;
			
			
			int currentState = (int) Math.signum(change);
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;
			
			if (pos == true && neg == true) {
				bottomTransitions++;
				neg = false;
				pos = false;
			}
			
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;
			
			int thresh = (int)(0.3*featureHeight)+1;
			
			//System.out.println(change);
			if (change == 0) row++;
			else if (change == -1) upwardCurve++;
			else if (change == 1)  downwardCurve++;
			else if (-5 < change && change < -1) upwardEdge++;
			else if (1 < change && change < 5) downwardEdge++;	
			else bottomLargeChange++;
		}
		//System.out.println("Bottomtransitions: " + bottomTransitions);
		double rowPercentage = round((double)row/(double)total,2);
		double upwardCurvePercentage = round((double)upwardCurve/(double)total,2);
		double downwardCurvePercentage = round((double)downwardCurve/(double)total,2);
		double upwardEdgePercentage = round((double)upwardEdge/(double)total,2);
		double downwardEdgePercentage = round((double)downwardEdge/(double)total,2);
		
		double[] percentages = new double[] {rowPercentage, upwardCurvePercentage,
				downwardCurvePercentage, upwardEdgePercentage, downwardEdgePercentage};
		
		return percentages;
	}
	
	private double[] determineLeftFlatCurveRowPercentagesX(int[] deltaX) {
		int curr;
		int next;
		int total = deltaX.length;
		
		int column=0;
		int upwardCurve=0;
		int downwardCurve=0;
		int upwardEdge=0;
		int downwardEdge=0;
		
		boolean neg = false;
		boolean pos = false;

		for (int i=0; i<deltaX.length-1; i++) {
			next = deltaX[i+1];
			curr = deltaX[i];
			int change = next - curr;
			
			int currentState = (int) Math.signum(change);
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;
			
			if (pos == true && neg == true) {
				leftTransitions++;
				neg = false;
				pos = false;
			}
			
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;			

			int thresh = (int)(0.3*featureWidth)+1;
			
			System.out.println(thresh);
			if (change == 0) column++;
			else if (-thresh < change && change < -1) upwardCurve++;
			else if (1 < change && change < thresh)  downwardCurve++;
			else if (change == -1) upwardEdge++;
			else if (change == 1) downwardEdge++;	
			else leftLargeChange++; 
		}
		//System.out.println("Lefttransitions: " + leftTransitions);
		double columnPercentage = round((double)column/(double)total,2);
		double upwardCurvePercentage = round((double)upwardCurve/(double)total,2);
		double downwardCurvePercentage = round((double)downwardCurve/(double)total,2);
		double upwardEdgePercentage = round((double)upwardEdge/(double)total,2);
		double downwardEdgePercentage = round((double)downwardEdge/(double)total,2);
		
		double[] percentages = new double[] {columnPercentage, upwardCurvePercentage,
				downwardCurvePercentage, upwardEdgePercentage, downwardEdgePercentage};
		
		return percentages;
	}
	
	private double[] determineRightFlatCurveRowPercentagesX(int[] deltaX) {
		int curr;
		int next;
		int total = deltaX.length;
		
		int column=0;
		int upwardCurve=0;
		int downwardCurve=0;
		int upwardEdge=0;
		int downwardEdge=0;

		boolean neg = false;
		boolean pos = false;
			
		for (int i=0; i<deltaX.length-1; i++) {
			next = deltaX[i+1];
			curr = deltaX[i];
			int change = next - curr;
			
			int currentState = (int) Math.signum(change);
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;
			
			if (pos == true && neg == true) {
				rightTransitions++;
				neg = false;
				pos = false;
			}
			
			if (currentState==-1) neg=true;
			else if (currentState==1) pos=true;

			int thresh = (int)(0.3*featureWidth)+1;
						
			//System.out.println(change);
			if (change == 0) column++;
			else if (-thresh < change && change < -1) upwardCurve++;
			else if (1 < change && change < thresh)  downwardCurve++;
			else if (change == -1) upwardEdge++;
			else if (change == 1) downwardEdge++;	
			else rightLargeChange++; 
		}
		//System.out.println("Righttransitions: " + rightTransitions);
		double columnPercentage = round((double)column/(double)total,2);
		double upwardCurvePercentage = round((double)upwardCurve/(double)total,2);
		double downwardCurvePercentage = round((double)downwardCurve/(double)total,2);
		double upwardEdgePercentage = round((double)upwardEdge/(double)total,2);
		double downwardEdgePercentage = round((double)downwardEdge/(double)total,2);
		
		double[] percentages = new double[] {columnPercentage, upwardCurvePercentage,
				downwardCurvePercentage, upwardEdgePercentage, downwardEdgePercentage};
		
		return percentages;
	}
	

	
//////////////////GETTERS/////////////////
	
	public List<Pixel> getFeatureGroup() {
		return featureGroup;
	}
	
	public int[] getBoundaryArr() {
		return boundaryArr;
	}

	public int getBoundaryArrSize() {		
		return (featureWidth * featureHeight);	
	}
	
	public int getWidthOfFeature() {
		return featureWidth;
	}
	
	public int getHeightOfFeature() {
		return featureHeight;
	}
	
	public double[] getTopViewPercentages() {
		return topViewPercentages;
	}

	public double[] getBottomViewPercentages() {
		return bottomViewPercentages;
	}

	public double[] getRightViewPercentages() {
		return rightViewPercentages;
	}

	public double[] getLeftViewPercentages() {
		return leftViewPercentages;
	}
	
	private void findAverageEdgePercentage() {
		averageEdgePercentage = round(((topViewPercentages[0] + bottomViewPercentages[0] + leftViewPercentages[0] +
				rightViewPercentages[0])/(double)4),2);
		//System.out.println("Ave Edge %: " + averageEdgePercentage );
	}

	
	public int[] getAllChangeAndTransitions() {
		int[] i = new int[] {topLargeChange,topTransitions,bottomLargeChange,bottomTransitions,
				leftLargeChange,leftTransitions,rightLargeChange,rightTransitions};
		return i;
	}
	
////////////////AUX METHODS///////////////
	
	/*
	 * Optional:  Export Feature as a jpg image to an absolute path directory
	 * 
	 * (BufferedImage b, String filePath, String imageName, String imageType)
	 * */
	private void saveFeature(BufferedImage rawImage, String filename) {
		featureImage = rawImage.getSubimage(boundaryArr[0], boundaryArr[1], (boundaryArr[2] - boundaryArr[0]), (boundaryArr[3] - boundaryArr[1]));
		AbstractProcessImage.outputFile(featureImage, "C:/sample_images/Features/", filename, "jpg");
	}

	/*
	 * round up decimal values to 2 places
	 * */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	
}
















