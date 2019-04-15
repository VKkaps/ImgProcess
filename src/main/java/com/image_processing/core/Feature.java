package com.image_processing.core;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.image_processing.letters.EnglishAlphabet.PercentageCheck;;

public class Feature {

	private Integer[][] featureIntArray; //2D Integer Array: 1 for Noticable, 0 for not noticable
	private List<Pixel> featureGroup;  //ArrayList of Pixels in a Feature sorted in X direction
	private int[] boundaryArr = new int[4];  //4 outer most points around the Feature (for Boxing purposes)
	
	private int featureWidth;
	private int featureHeight;
	
	private BufferedImage featureImage = null;  //Auxilary - used to save Feature jpg image to a absolute file location

	private Boolean hasLoop = false;
	private Boolean hasUpperLoop = false;
	private Boolean hasLowerLoop = false;
	private int numOfLoops = 0;
	Integer[][] copy = null;
	private ArrayList<Integer> verticalTransitionPoints = new ArrayList<Integer>();	
		
	CircularLinkedList<Character> circularArr = new CircularLinkedList<Character>();
	LinkedList<Character> cArr = new LinkedList<Character>();
	
	LinkedList<Character> directionLL = new LinkedList<Character>();
	
	// top, bottom, left, right
	private double[] firstQuarter = null;
	private double[] secondQuarter = null;
	private double[] threeQuarter = null;
	private double[] fourthQuarter = null;
	
	private HashMap<Integer,double[]> sectionHMap = new HashMap<Integer,double[]>();
	
	double percentStraight=0.0;
	
	
	double curved_Percentage=0.0;
	double sharp_Percentage=0.0;
	double column_Percentage=0.0;
	double flat_Percentage=0.0;
	double corner_Percentage=0.0;
	double fourFive_Percentage=0.0;
	
	double[] percentageArr = null;
	
	private double leftUpper_dXdY = 0.0;
	private double leftLower_dXdY = 0.0;
	
	private double rightUpper_dXdY = 0.0;
	private double rightLower_dXdY = 0.0;
	
	private double topUpper_dXdY = 0.0;
	private double topLower_dXdY = 0.0;
	
	private double bottomUpper_dXdY = 0.0;
	private double bottomLower_dXdY = 0.0;
	
	char letter = '_';
	StringBuilder percentMatch = new StringBuilder();
	

	
/////////////////////////////////////////////////////////////////////////////////
	

 	public Feature(List<Pixel> featureGroup) {
		this.featureGroup = featureGroup;
		init();
	}
	
	private void init() {
		findBoundaryOfFeature();
		createFeatureIntegerArray();
		loopDetection();
		slopeDetection();
		
		findExternalEdgeofFeature();
		generateDirectionList();
		breakDirectionListIntoFourSections();
		edgeClassifier();
		identifyLetter();
		
		
		//printDirectionList();
		//printFeatureInfo();
		//printIntegerArray();
		//sectionPrint();
		
		System.out.println(letter);
	}

	
	private void identifyLetter() {

		
		if (numOfLoops==0) {
			// 43 total
			
			
			char[] chArr = new char[4];
			chArr = PercentageCheck.zeroLoop(sectionHMap);

			for (int i=1;i<chArr.length;i++) {
				percentMatch.append(chArr[i]);
			}
			
			
			letter = chArr[0];

		}
		else if (numOfLoops==1) {
			
			char[] chArr = new char[4];
			chArr = PercentageCheck.oneLoop(sectionHMap);

			for (int i=1;i<chArr.length;i++) {
				percentMatch.append(chArr[i]);
			}
			

			letter = chArr[0];

		}
		else if (numOfLoops==2) {
			// 2 total:
			// B and 8
			// potentially g...
			char[] chArr = new char[4];
			chArr = PercentageCheck.twoLoop(sectionHMap);

			for (int i=1;i<chArr.length;i++) {
				percentMatch.append(chArr[i]);
			}


			letter = chArr[0];
		}
	}
	
	
	private void edgeClassifier() {

		int c_curve = 0;
		int A_edge = 0;
		int fourFive = 0;
		int corner = 0;
		
		
		int rowMargin = featureWidth/4;
		int colMargin = featureHeight/4;
		
		int rCount=0;
		int count=0;
		// right flat check
		for (int i=0;i<directionLL.size();i++) {
			if (directionLL.get(i)=='r') {
				count++;
			}
			else if (directionLL.get(i)!='r') {
				if (count>=rowMargin) {
					rCount+=count;
				}
				count=0;
			}
		}


		int lCount=0;
		count=0;
		// left flat check
		for (int i=0;i<directionLL.size();i++) {
			if (directionLL.get(i)=='l') {
				count++;
			}
			else if (directionLL.get(i)!='l') {
				if (count>=rowMargin) {
					lCount+=count;
				}
				count=0;
			}
		}


		int tCount=0;
		count=0;
		// top column check
		for (int i=0;i<directionLL.size();i++) {
			if (directionLL.get(i)=='t') {
				count++;
			}
			else if (directionLL.get(i)!='t') {
				if (count>=colMargin) {
					tCount+=count;
				}
				count=0;
			}
		}


		int bCount=0;
		count=0;
		// bottom column check
		for (int i=0;i<directionLL.size();i++) {
			if (directionLL.get(i)=='b') {
				count++;
			}
			else if (directionLL.get(i)!='b') {
				if (count>=colMargin) {
					bCount+=count;
				}
				count=0;
			}
		}

		double colPercentage = (double)(tCount+bCount)/(double)featureHeight;
		double rowPercentage = (double)(lCount+rCount)/(double)featureWidth;

		//A-edge
		for (int i=0;i<circularArr.size()-4;i++) {
			if (directionLL.get(i)=='r') {
				if (directionLL.get(i+1)=='t') {
					if (directionLL.get(i+2)=='t') {
						if (directionLL.get(i+3)=='t') {
							if (directionLL.get(i+4)=='r') {
								A_edge++;
							}
						}
						else if (directionLL.get(i+3)=='r') {
							A_edge++;
						}
					}
				}
				else if (directionLL.get(i+1)=='b') {
					if (directionLL.get(i+2)=='b') {
						if (directionLL.get(i+3)=='b') {
							if (directionLL.get(i+4)=='r') {
								A_edge++;
							}
						}
						else if (directionLL.get(i+3)=='r') {
							A_edge++;
						}
					}
				}
			}
			else if (directionLL.get(i)=='l') {
				if (directionLL.get(i+1)=='t') {
					if (directionLL.get(i+2)=='t') {
						if (directionLL.get(i+3)=='t') {
							if (directionLL.get(i+4)=='l') {
								A_edge++;
							}
						}
						else if (directionLL.get(i+3)=='l') {
							A_edge++;
						}
					}
				}
				else if (directionLL.get(i+1)=='b') {
					if (directionLL.get(i+2)=='b') {
						if (directionLL.get(i+3)=='b') {
							if (directionLL.get(i+4)=='l') {
								A_edge++;
							}
						}
						else if (directionLL.get(i+3)=='l') {
							A_edge++;
						}
					}
				}
			}
		}	
		
		//c-curve check
		for (int i=0;i<circularArr.size()-4;i++) {
			if (directionLL.get(i)=='t') {
				if (directionLL.get(i+1)=='r') {
					if (directionLL.get(i+2)=='r') {
						if (directionLL.get(i+3)=='r') {
							if (directionLL.get(i+4)=='t') {
								c_curve++;
							}
						}
						else if (directionLL.get(i+3)=='t') {
							c_curve++;
						}
					}
				}
				else if (directionLL.get(i+1)=='l') {
					if (directionLL.get(i+2)=='l') {
						if (directionLL.get(i+3)=='l') {
							if (directionLL.get(i+4)=='t') {
								c_curve++;
							}
						}
						else if (directionLL.get(i+3)=='t') {
							c_curve++;
						}
					}
				}
			}
			else if (directionLL.get(i)=='b') {
				if (directionLL.get(i+1)=='r') {
					if (directionLL.get(i+2)=='r') {
						if (directionLL.get(i+3)=='r') {
							if (directionLL.get(i+4)=='b') {
								c_curve++;
							}
						}
						else if (directionLL.get(i+3)=='b') {
							c_curve++;
						}
					}
				}
				else if (directionLL.get(i+1)=='l') {
					if (directionLL.get(i+2)=='l') {
						if (directionLL.get(i+3)=='l') {
							if (directionLL.get(i+4)=='b') {
								c_curve++;
							}
						}
						else if (directionLL.get(i+3)=='b') {
							c_curve++;
						}
					}
				}
			}
		}
		
		
		
		//corner check
		for (int i=0;i<circularArr.size()-3;i++) {
			if (directionLL.get(i)=='b') {
				if (directionLL.get(i+1)=='b') {
					if (directionLL.get(i+2)=='r') {
						if (directionLL.get(i+3)=='r') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='l') {
						if (directionLL.get(i+3)=='l') {
							corner++;
						}
					}	
				}
			}	
			
			else if (directionLL.get(i)=='r') {
				if (directionLL.get(i+1)=='r') {
					if (directionLL.get(i+2)=='t') {
						if (directionLL.get(i+3)=='t') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='b') {
						if (directionLL.get(i+3)=='b') {
							corner++;
						}
					}
				}
			}	
			
			else if (directionLL.get(i)=='l') {
				if (directionLL.get(i+1)=='l') {
					if (directionLL.get(i+2)=='t') {
						if (directionLL.get(i+3)=='t') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='b') {
						if (directionLL.get(i+3)=='b') {
							corner++;
						}
					}
				}
			}
			
			else if (directionLL.get(i)=='t') {
				if (directionLL.get(i+1)=='t') {
					if (directionLL.get(i+2)=='l') {
						if (directionLL.get(i+3)=='l') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='r') {
						if (directionLL.get(i+3)=='r') {
							corner++;
						}
					}
				}
			}
		}
		
		//45 degree angle check
		for (int i=0;i<directionLL.size()-3;i++) {
			
			if (directionLL.get(i)=='r') {
				if (directionLL.get(i+1)=='t') {
					if (directionLL.get(i+2)=='r') {
						fourFive++;
					}
				}
				else if (directionLL.get(i+1)=='b') {
					if (directionLL.get(i+2)=='r') {
						fourFive++;
					}
				}
			}
			else if (directionLL.get(i)=='l') {
				if (directionLL.get(i+1)=='t') {
					if (directionLL.get(i+2)=='l') {
						fourFive++;
					}
				}
				else if (directionLL.get(i+1)=='b') {
					if (directionLL.get(i+2)=='l') {
						fourFive++;
					}
				}
			}
		}
		
		//corner check
		for (int i=0;i<directionLL.size()-3;i++) {
			
			if (directionLL.get(i)=='r') {
				if (directionLL.get(i+1)=='r') {
					if (directionLL.get(i+2)=='t') {
						if (directionLL.get(i+3)=='t') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='b') {
						if (directionLL.get(i+3)=='b') {
							corner++;
						}
					}
				}
			}
			else if (directionLL.get(i)=='l') {
				if (directionLL.get(i+1)=='l') {
					if (directionLL.get(i+2)=='t') {
						if (directionLL.get(i+3)=='t') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='b') {
						if (directionLL.get(i+3)=='b') {
							corner++;
						}
					}
				}
			}
			else if (directionLL.get(i)=='t') {
				if (directionLL.get(i+1)=='t') {
					if (directionLL.get(i+2)=='r') {
						if (directionLL.get(i+3)=='r') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='l') {
						if (directionLL.get(i+3)=='l') {
							corner++;
						}
					}
				}
			}
			else if (directionLL.get(i)=='b') {
				if (directionLL.get(i+1)=='b') {
					if (directionLL.get(i+2)=='r') {
						if (directionLL.get(i+3)=='r') {
							corner++;
						}
					}
					else if (directionLL.get(i+2)=='l') {
						if (directionLL.get(i+3)=='l') {
							corner++;
						}
					}
				}
			}
		}
		

		double Atemp = (double)(A_edge*5) / (double) directionLL.size();
		double Ctemp = (double)(c_curve*5) / (double) directionLL.size();
		double fourFivetemp = (double)(fourFive*3) / (double) directionLL.size();
		double cornertemp = (double)(corner*4) / (double) directionLL.size();

		
		
		curved_Percentage = round(Ctemp,2);
		sharp_Percentage=round(Atemp,2);
		fourFive_Percentage = round(fourFivetemp,2);
		column_Percentage= round(colPercentage,2);
		flat_Percentage = round(rowPercentage,2);
		corner_Percentage = round(cornertemp,2);
		
//		System.out.println(
//				"Curved: " + curved_Percentage + 
//				"\nSharp: " + sharp_Percentage + 
//				"\n45: " + fourFive_Percentage + 
//				"\nCorner: " + corner_Percentage +
//				"\nColumn: " + column_Percentage + 
//				"\nFlat: " + flat_Percentage
//				);
		
			
		percentageArr = new double[] {curved_Percentage, sharp_Percentage, 
				fourFive_Percentage, corner_Percentage, flat_Percentage, column_Percentage}; 
	
		sectionHMap.put(4, percentageArr);
	}

	
	private void breakDirectionListIntoFourSections() {
		int size = directionLL.size()/4;
		
		int start = 0;
		int quarter = size;
		int half = size*2;
		int threeQ = size*3;
		
		char[] firstSection = new char[quarter-start];
		char[] secondSection = new char[half-quarter];
		char[] thirdSection = new char[threeQ-half];
		char[] fourthSection = new char[directionLL.size()-threeQ];
		
		for (int i=0;i<firstSection.length;i++) {
			firstSection[i]=directionLL.get(i);
		}
		for (int i=0;i<secondSection.length;i++) {
			secondSection[i]=directionLL.get(i+firstSection.length);
		}
		for (int i=0;i<thirdSection.length;i++) {
			thirdSection[i]=directionLL.get(i+firstSection.length+secondSection.length);
		}
		for (int i=0;i<fourthSection.length;i++) {
			fourthSection[i]=directionLL.get(i+firstSection.length+secondSection.length+thirdSection.length);
		}

		firstQuarter = findDirectionAve(firstSection);
		secondQuarter = findDirectionAve(secondSection);
		threeQuarter = findDirectionAve(thirdSection);
		fourthQuarter = findDirectionAve(fourthSection);
		
		sectionHMap.put(0, firstQuarter);
		sectionHMap.put(1, secondQuarter);
		sectionHMap.put(2, threeQuarter);
		sectionHMap.put(3, fourthQuarter);
	}
	
	private double[] findDirectionAve(char[] chArr) {
		int top =0;
		int bottom = 0;
		int left = 0;
		int right = 0;
		
		for (char ch : chArr) {
			if (ch=='t') {
				top++;
			}
			else if (ch=='b') {
				bottom++;
			}
			else if (ch=='l') {
				left++;
			}
			else if (ch=='r') {
				right++;
			}
		}
		double t = round((double) top / (double) chArr.length,3);
		double b = round((double) bottom / (double) chArr.length,3);
		double l = round((double) left / (double) chArr.length,3);
		double r = round((double) right / (double) chArr.length,3);
		
		double[] dArr = new double[]{t,b,l,r};
		
		return dArr;
		
	}
	
	private void generateDirectionList() {
		
		int firstX = 0;
		
		for (int x=0; x<featureWidth;x++) {
			if (featureIntArray[x][featureHeight/2]==5) {
				firstX = x;
				break;
			}
		}
		
		circularArr.insertAtBeginning('s');
		
		recursiveIt(firstX, featureHeight/2);
		
		featureIntArray[firstX][featureHeight/2+1]=2;
		circularArr.deleteFromPosition(0);

		if (circularArr.searchByIndex(circularArr.size()-1).item=='b') {
			if (circularArr.searchByIndex(circularArr.size()-2).item=='t') {
				circularArr.deleteFromPosition(circularArr.size()-1);
			}
		}
		
		//rotateCircularListToFirstTransition();

		for (int y=0;y<featureHeight;y++) {
			for (int x=0;x<featureWidth;x++) {
				if (featureIntArray[x][y]!=2) {
					featureIntArray[x][y]=0;
				}
			}
		}
		
		for (int i=0;i<circularArr.size();i++) {
			directionLL.add(circularArr.searchByIndex(i).item);
		}
	}
	
	public void recursiveIt(int x, int y) {
		
		//top
		if (featureIntArray[x][y-1]==5) {
			circularArr.insertAtPosition('t', circularArr.size());
			featureIntArray[x][y]=2;
			recursiveIt(x, y-1);
		}
		
		//right
		if (featureIntArray[x+1][y]==5) {
			circularArr.insertAtPosition('r', circularArr.size());
			featureIntArray[x][y]=2;
			recursiveIt(x+1, y);
		}
		
		//left
		if (featureIntArray[x-1][y]==5) {
			circularArr.insertAtPosition('l', circularArr.size());
			featureIntArray[x][y]=2;
			recursiveIt(x-1, y);
		}
		
		//bottom
		if (featureIntArray[x][y+1]==5) {
			circularArr.insertAtPosition('b', circularArr.size());
			featureIntArray[x][y]=2;
			recursiveIt(x, y+1);
		}
		

		

	}
	
	private void findExternalEdgeofFeature() {
		for (int y=1;y<featureHeight-1;y++) {
			for (int x=1;x<featureWidth-1;x++) {
				if (featureIntArray[x][y]==0) {
					if (featureIntArray[x-1][y]==1 || featureIntArray[x+1][y]==1 ||
							featureIntArray[x][y-1]==1 || featureIntArray[x][y+1]==1) {
						featureIntArray[x][y]=5;
					}
				}
			}
		}
		for (int y=1;y<featureHeight-1;y++) {
			for (int x=1;x<featureWidth-1;x++) {
				if (featureIntArray[x][y]==0) {
					
					if (featureIntArray[x+1][y]==5 && featureIntArray[x][y+1]==5 &&
							featureIntArray[x+1][y+1]==1) {
						featureIntArray[x][y]=5;
					}
					else if (featureIntArray[x-1][y]==5 && featureIntArray[x][y+1]==5 &&
							featureIntArray[x-1][y+1]==1) {
						featureIntArray[x][y]=5;
					}
					else if (featureIntArray[x][y-1]==5 && featureIntArray[x-1][y]==5 &&
							featureIntArray[x-1][y-1]==1) {
						featureIntArray[x][y]=5;
					}
					else if (featureIntArray[x][y-1]==5 && featureIntArray[x+1][y]==5 &&
							featureIntArray[x+1][y-1]==1) {
						featureIntArray[x][y]=5;
					}
					
				}
			}
		}
	}

	private void loopDetection() {
		
		copy = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
		
		int middle = featureWidth/2;
		
		Integer[] middleArr = copy[middle];
		int curr = 0;
		int next = 0;

		for (int i=0;i<middleArr.length-1;i++) {
			curr = middleArr[i];
			next = middleArr[i+1];
			
			if (next-curr==1) {
				verticalTransitionPoints.add(i+1);
			}
			
		}
		
		int middleOfLoop1=0;
		int middleOfLoop2=0;
		int middleOfLoop3=0;
		int middleOfLoop4=0;
		
		if (verticalTransitionPoints.size()==1) {
			middleOfLoop1=verticalTransitionPoints.get(0)-1;
			
			if (loopDetector(middle, middleOfLoop1, copy)) {
				hasLoop=true;
				numOfLoops++;
				upperOrLowerLoop(middleOfLoop1/2);
			}
						
		}
		else if (verticalTransitionPoints.size()==2) {
			middleOfLoop1=verticalTransitionPoints.get(0)-1;
			middleOfLoop2=verticalTransitionPoints.get(1)-1;
			
			if (loopDetector(middle, middleOfLoop1,copy)) {
				hasLoop=true;
				numOfLoops++;
				upperOrLowerLoop(middleOfLoop1/2);
			}

			copy = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);			
			
			if (copy[middle][middleOfLoop2-1]!=1) {
				if (loopDetector(middle, middleOfLoop2,copy)) {
					hasLoop=true;
					numOfLoops++;
					upperOrLowerLoop((middleOfLoop1 + middleOfLoop2)/2);
				}
			}


		}
		else if (verticalTransitionPoints.size()==3) {
			middleOfLoop1=verticalTransitionPoints.get(0)-1;
			middleOfLoop2=verticalTransitionPoints.get(1)-1;
			middleOfLoop3=verticalTransitionPoints.get(2)-1;
			
			if (loopDetector(middle, middleOfLoop1,copy)) {
				hasLoop=true;
				numOfLoops++;
				upperOrLowerLoop(middleOfLoop1/2);
			}
			copy = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
			

			if (copy[middle][middleOfLoop2-1]!=1) {
				if (loopDetector(middle, middleOfLoop2,copy)) {
					hasLoop=true;
					numOfLoops++;
					upperOrLowerLoop((middleOfLoop1 + middleOfLoop2)/2);
				}
			}
			copy = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
			

			if (copy[middle][middleOfLoop3-1]!=1) {
				if (loopDetector(middle, middleOfLoop3,copy)) {
					hasLoop=true;
					numOfLoops++;
					upperOrLowerLoop((middleOfLoop2 + middleOfLoop3)/2);
				}
			}

		}
		
		else if (verticalTransitionPoints.size()==4) {
			middleOfLoop1=verticalTransitionPoints.get(0)-1;
			middleOfLoop2=verticalTransitionPoints.get(1)-1;
			middleOfLoop3=verticalTransitionPoints.get(2)-1;
			middleOfLoop4=verticalTransitionPoints.get(3)-1;
			
			if (loopDetector(middle, middleOfLoop1,copy)) {
				hasLoop=true;
				numOfLoops++;
				upperOrLowerLoop(middleOfLoop1/2);
			}
			copy = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
			

			if (copy[middle][middleOfLoop2-1]!=1) {
				if (loopDetector(middle, middleOfLoop2,copy)) {
					hasLoop=true;
					numOfLoops++;
					upperOrLowerLoop((middleOfLoop1 + middleOfLoop2)/2);
				}
			}
			copy = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
			

			if (copy[middle][middleOfLoop3-1]!=1) {
				if (loopDetector(middle, middleOfLoop3,copy)) {
					hasLoop=true;
					numOfLoops++;
					upperOrLowerLoop((middleOfLoop2 + middleOfLoop3)/2);
				}
			}
			copy = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
			

			
			if (copy[middle][middleOfLoop4-1]!=1) {
				if (loopDetector(middle, middleOfLoop4,copy)) {
					hasLoop=true;
					numOfLoops++;
					upperOrLowerLoop((middleOfLoop3 + middleOfLoop4)/2);
				}
			}

		}

	}

	private boolean loopDetector(Integer x, Integer y, Integer[][] iArr) {
		iArr[x][y]=3;
		
		if (x!=0 && x!=featureWidth-1 && y!=0 && y!=featureHeight-1) {
			if (copy[x+1][y]==0) {
				loopDetector(x+1,y,iArr);
			}
			if (copy[x][y-1]==0) {
				loopDetector(x,y-1,iArr);
			}
			if (copy[x-1][y]==0) {
				loopDetector(x-1,y,iArr);
			}
			if (copy[x][y+1]==0) {
				loopDetector(x,y+1,iArr);
			}
		}


		for (int xL=0;xL<featureWidth;xL++) {
			if (copy[xL][0]==3 || copy[xL][featureHeight-1]==3) return false;
		}
		for (int yL=0;yL<featureHeight;yL++) {
			if (copy[0][yL]==3 || copy[featureWidth-1][yL]==3) return false;
		}
		return true;

	}
	
	private void upperOrLowerLoop(Integer i) {
		//System.out.println(i);
		//System.out.println(featureHeight);
		double div = round((double)i / (double)featureHeight,2);
		//System.out.println(div);
		
		if (div < 0.35) {
			hasUpperLoop=true;
		}
		if (div >= 0.35) {
			hasLowerLoop=true;
		}
		
	}
	
	private void slopeDetection() {
		findLeftSlope();
		findRightSlope();
		findTopSlope();
		findBottomSlope();
	}
	
	private void findLeftSlope() {
		int xMiddle = featureWidth;
		int yStart = 2;
		int yFinish = featureHeight-2;
		
		int[] dXdY_left = new int[yFinish-yStart];
		
		for (int y=yStart;y<yFinish;y++) {
			for (int x=0;x<xMiddle;x++) {
				if (featureIntArray[x][y]==1) {
					//System.out.println(y-yStart);
					dXdY_left[y-yStart]=x;
					break;
				}
			}
		}

		for (int i=0;i<(dXdY_left.length/2);i++) {
			//System.out.print(dXdY_left[i] + " ");
		}
		System.out.println();
		for (int i=(dXdY_left.length/2);i<dXdY_left.length;i++) {
			//System.out.print(dXdY_left[i] + " ");
		}
		
		
		
		int split = dXdY_left.length/2;
		int[] arr1 = new int[split];
		int[] arr2 = new int[dXdY_left.length-split];
		
		for (int i=0;i<arr1.length;i++) {
			arr1[i]=dXdY_left[i];
		}
		for (int i=arr1.length;i<dXdY_left.length;i++) {
			arr2[i-arr1.length]=dXdY_left[i];
		}
		
		double upperSlope = 0.0;
		double lowerSlope = 0.0;
		
		for (int i=0;i<arr1.length-1;i++) {
			upperSlope += arr1[i+1]-arr1[i];
		}
		
		upperSlope = round(upperSlope/arr1.length,2);

		
		for (int i=0;i<arr2.length-1;i++) {
			lowerSlope += arr2[i+1]-arr2[i];
		}
		
		lowerSlope = round(lowerSlope/arr2.length,2);
		
		leftUpper_dXdY = upperSlope;
		leftLower_dXdY = lowerSlope;

	}

	private void findRightSlope() {
		int yStart = 2;
		int yFinish = featureHeight-2;
		
		int[] dXdY_right = new int[yFinish-yStart];
		
		for (int y=yStart;y<yFinish;y++) {
			for (int x=featureWidth-1;x>0;x--) {
				if (featureIntArray[x][y]==1) {
					//System.out.println(y-yStart);
					dXdY_right[y-yStart]=x;
					break;
				}
			}
		}
		
		
		int split = dXdY_right.length/2;
		int[] arr1 = new int[split];
		int[] arr2 = new int[dXdY_right.length-split];
		
		for (int i=0;i<arr1.length;i++) {
			arr1[i]=dXdY_right[i];
		}
		for (int i=arr1.length;i<dXdY_right.length;i++) {
			arr2[i-arr1.length]=dXdY_right[i];
		}
		
		double upperSlope = 0.0;
		double lowerSlope = 0.0;
		
		for (int i=0;i<arr1.length-1;i++) {
			upperSlope += arr1[i+1]-arr1[i];
		}
		
		upperSlope = round(upperSlope/arr1.length,2);

		
		for (int i=0;i<arr2.length-1;i++) {
			lowerSlope += arr2[i+1]-arr2[i];
		}
		
		lowerSlope = round(lowerSlope/arr2.length,2);
		
		rightUpper_dXdY = upperSlope;
		rightLower_dXdY = lowerSlope;

	}
	
	private void findTopSlope() {
		int yMiddle = featureHeight;
		
		if (featureWidth>4) {
			int xStart = 2;
			int xFinish = featureWidth-2;
			
			int[] dYdX_top = new int[xFinish-xStart];
			
			for (int x=xStart;x<xFinish;x++) {
				for (int y=0;y<yMiddle;y++) {
					if (featureIntArray[x][y]==1) {
						//System.out.println(y-yStart);
						dYdX_top[x-xStart]=y;
						break;
					}
				}
			}
			
			
			int split = dYdX_top.length/2;
			int[] arr1 = new int[split];
			int[] arr2 = new int[dYdX_top.length-split];
			
			for (int i=0;i<arr1.length;i++) {
				arr1[i]=dYdX_top[i];
			}
			for (int i=arr1.length;i<dYdX_top.length;i++) {
				arr2[i-arr1.length]=dYdX_top[i];
			}
			
			double leftSlope = 0.0;
			double rightSlope = 0.0;
			
			for (int i=0;i<arr1.length-1;i++) {
				leftSlope += arr1[i+1]-arr1[i];
			}
			
			leftSlope = round(leftSlope/arr1.length,2);

			
			for (int i=0;i<arr2.length-1;i++) {
				rightSlope += arr2[i+1]-arr2[i];
			}
			
			rightSlope = round(rightSlope/arr2.length,2);
			
			topUpper_dXdY = leftSlope;
			topLower_dXdY = rightSlope;
		}
		else {
			topUpper_dXdY = 0.0;
			topLower_dXdY = 0.0;
		}



	}

	private void findBottomSlope() {

		if (featureWidth>4) {
			int xStart = 2;
			int xFinish = featureWidth-2;
			
			int[] dYdX_bottom = new int[xFinish-xStart];
			
			for (int x=xStart;x<xFinish;x++) {
				for (int y=featureHeight-1;y>0;y--) {
					if (featureIntArray[x][y]==1) {
						//System.out.println(y-yStart);
						dYdX_bottom[x-xStart]=y;
						break;
					}
				}
			}
			
			
			int split = dYdX_bottom.length/2;
			int[] arr1 = new int[split];
			int[] arr2 = new int[dYdX_bottom.length-split];
			
			for (int i=0;i<arr1.length;i++) {
				arr1[i]=dYdX_bottom[i];
			}
			for (int i=arr1.length;i<dYdX_bottom.length;i++) {
				arr2[i-arr1.length]=dYdX_bottom[i];
			}
			
			double leftSlope = 0.0;
			double rightSlope = 0.0;
			
			for (int i=0;i<arr1.length-1;i++) {
				leftSlope += arr1[i+1]-arr1[i];
			}
			
			leftSlope = round(leftSlope/arr1.length,2);

			
			for (int i=0;i<arr2.length-1;i++) {
				rightSlope += arr2[i+1]-arr2[i];
			}
			
			rightSlope = round(rightSlope/arr2.length,2);
			
			bottomUpper_dXdY = leftSlope;
			bottomLower_dXdY = rightSlope;
		}
		else {
			bottomUpper_dXdY = 0.0;
			bottomLower_dXdY = 0.0;
		}
		

	}
	

	
	/*
	 * Find outer-most X, coordinates of the feature.  Used to box Features.
	 * Sort by X coor first, then loop to find Y extremes.
	 * */
	private void findBoundaryOfFeature() {
		
		Collections.sort(featureGroup); //Sort featureGroup by X coordinate
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
		
	}
		
	/*
	 * Loads a 2D Integer Array comprised with the same size as the feature.
	 * int value of 1 means noticable, int value of 0 means not noticable
	 * 
	 * */
	private void createFeatureIntegerArray() {
		featureIntArray = AbstractProcessImage.getFeatureAsIntArray(boundaryArr);
		featureWidth = featureIntArray.length;
		featureHeight = featureIntArray[0].length;
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


	private void printFeatureInfo() {
		System.out.println(
				"\nFeatureWidth: " + featureWidth +
				", FeatureHeight: " + featureHeight +
				", Num of Loops: " + numOfLoops +
				", Has Upper Loop: " + hasUpperLoop +
				", Has Lower Loop: " + hasLowerLoop +
				", VerticalTransitions: " + verticalTransitionPoints.size() +
				", LeftUpper dXdY: " + leftUpper_dXdY +
				", LeftLower dXdY: " + leftLower_dXdY +
				", RightUpper dXdY: " + rightUpper_dXdY +
				", RightLower dXdY: " + rightLower_dXdY +
				", TopUpper dXdY: " + topUpper_dXdY +
				", TopLower dXdY: " + topLower_dXdY +
				", BottomUpper dXdY: " + bottomUpper_dXdY +
				", BottomLower dXdY: " + bottomLower_dXdY
				);
		
		System.out.println("Curved%: " + curved_Percentage
				+ ", Sharp%: " + sharp_Percentage
				+ ", Flat%: " + flat_Percentage
				+ ", Column%: " + column_Percentage
				+ ", Corner%: " + corner_Percentage
				+ ", 45deg%: " + fourFive_Percentage
		);
		
		System.out.println("First Section(t,b,l,r): " + firstQuarter[0] + ", " + firstQuarter[1] + ", " +
				 + firstQuarter[2] + ", " + firstQuarter[3] +
				 "\nSecond Section(t,b,l,r): " + secondQuarter[0] + ", " + secondQuarter[1] + ", " +
						 + secondQuarter[2] + ", " + secondQuarter[3] +
				 "\nThird Section(t,b,l,r): " + threeQuarter[0] + ", " + threeQuarter[1] + ", " +
						 + threeQuarter[2] + ", " + threeQuarter[3] +	
				 "\nFourth Section(t,b,l,r): " + fourthQuarter[0] + ", " + fourthQuarter[1] + ", " +
						 + fourthQuarter[2] + ", " + fourthQuarter[3]
		);

		System.out.println("Letter: " + letter + ", " + percentMatch + "%");
		System.out.print("\n");
	}
	
	private void sectionPrint() {
		System.out.println(firstQuarter[0] + ", " + firstQuarter[1] + ", " +
				 + firstQuarter[2] + ", " + firstQuarter[3] +
				 "\n" + secondQuarter[0] + ", " + secondQuarter[1] + ", " +
						 + secondQuarter[2] + ", " + secondQuarter[3] +
				 "\n" + threeQuarter[0] + ", " + threeQuarter[1] + ", " +
						 + threeQuarter[2] + ", " + threeQuarter[3] +	
				 "\n" + fourthQuarter[0] + ", " + fourthQuarter[1] + ", " +
						 + fourthQuarter[2] + ", " + fourthQuarter[3] +
				 "\n" + percentageArr[0] + ", " + percentageArr[1] + ", " +
						 + percentageArr[2] + ", " + percentageArr[3] + ", " +
						 + percentageArr[4] + ", " + percentageArr[5]
		);
	}
	
	private void printIntegerArray() {
		for (int y = 0; y < featureHeight; y++) {
			for (int x = 0; x < featureWidth; x++) {
				System.out.print(featureIntArray[x][y]+" ");
			}
			System.out.println();
		}	
	}
	
	private void printDirectionList() {
		for (char ch : directionLL) {
			System.out.print(ch + ",");
		}
		System.out.println();
	}
	
}
















