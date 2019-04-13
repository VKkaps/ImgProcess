package com.image_processing.core;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Letter {

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
	
	
	double curved_Percentage=0.0;
	double sharp_Percentage=0.0;
	double column_Percentage=0.0;
	double flat_Percentage=0.0;
	double corner_Percentage=0.0;
	
	double[] percentageArr = null;
	
	private double leftUpper_dXdY = 0.0;
	private double leftLower_dXdY = 0.0;
	
	private double rightUpper_dXdY = 0.0;
	private double rightLower_dXdY = 0.0;
	
	private double topUpper_dXdY = 0.0;
	private double topLower_dXdY = 0.0;
	
	private double bottomUpper_dXdY = 0.0;
	private double bottomLower_dXdY = 0.0;
	
	String letter = "_";
	private double percentMatch = 0.0;
	

	
/////////////////////////////////////////////////////////////////////////////////
	

 	public Letter(List<Pixel> featureGroup) {
		this.featureGroup = featureGroup;
		init();
	}
	
	private void init() {
		findBoundaryOfFeature();
		createFeatureIntegerArray();
		loopDetection();
		slopeDetection();
		
		findExternalEdgeofLetter();
		generateDirectionList();
		//printDirectionList();
		newClassify();
		
		//classify();
		identifyLetter();
		System.out.println(percentMatch);
		//sectionPrint();
		//printLetterInfo();
		//printIntegerArray();
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
			
	private void newClassify() {
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
			thirdSection[i]=directionLL.get(i+secondSection.length);
		}
		for (int i=0;i<fourthSection.length;i++) {
			fourthSection[i]=directionLL.get(i+thirdSection.length);
		}
	//	System.out.println();
		
		firstQuarter = findDirectionAve(firstSection);
		secondQuarter = findDirectionAve(secondSection);
		threeQuarter = findDirectionAve(thirdSection);
		fourthQuarter = findDirectionAve(fourthSection);

		compareC();
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
		double t = round((double) top / (double) chArr.length,2);
		double b = round((double) bottom / (double) chArr.length,2);
		double l = round((double) left / (double) chArr.length,2);
		double r = round((double) right / (double) chArr.length,2);
		
		double[] dArr = new double[]{t,b,l,r};
		
		return dArr;
		
	}
	
	private void compareC() {
		double[] first = new double[] {0.313,	0.126,	0.0,	0.494};
		double[] second = new double[] {0.0,	0.312,	0.313,	0.299};
		double[] third = new double[] {0.0,	0.312,	0.313,	0.299};
		double[] fourth = new double[] {0.0,	0.323,	0.308,	0.293};
		

		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(first[i], firstQuarter[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(second[i], secondQuarter[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(third[i], threeQuarter[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourth[i], fourthQuarter[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		
		double aver = (o+t+thr+f)/4;
		
		double percentResult = round(aver,2);
		
		percentMatch=percentResult;
		
	}
	
	private void rotateCircularListToFirstTransition() {
		int newStart = 0;
		char firstChar = circularArr.searchByIndex(newStart).item;
		char nextChar = circularArr.searchByIndex(newStart+1).item;

		while(firstChar==nextChar) {
			
			firstChar = circularArr.searchByIndex(newStart).item;
			firstChar = circularArr.searchByIndex(newStart+1).item;
			
			newStart++;
		}

		LinkedList<Character> Arrtemp = null;

		Arrtemp = new LinkedList<Character>();
		for (int i=0;i<circularArr.size()-newStart;i++) {
			Arrtemp.add(circularArr.searchByIndex(i+newStart).item);
		}
		
		for (int z=0; z<newStart;z++) {
			Arrtemp.add(circularArr.searchByIndex(circularArr.size()-newStart+z).item);
		}
		cArr=Arrtemp;
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

	private void classify() {
		

		int c_curve = 0;
		int A_edge = 0;
		int flat = 0;
		int column = 0;
		int corner = 0;
		int fourFive = 0;

		// flat check
		for (int i=0;i<directionLL.size()-4;i++) {
			
			
			if (directionLL.get(i)=='r') {
				if (directionLL.get(i+1)=='r') {
					if (directionLL.get(i+2)=='r') {
						if (directionLL.get(i+3)=='r') {
							if (directionLL.get(i+4)=='r') {
								flat++;
								i+=5;
							}
						}
					}
				}
			}
			else if (directionLL.get(i)=='l') {
				if (directionLL.get(i+1)=='l') {
					if (directionLL.get(i+2)=='l') {
						if (directionLL.get(i+3)=='l') {
							if (directionLL.get(i+4)=='l') {
								flat++;
								i+=5;
							}
						}
					}
				}
			}
		}
		
		//column check
		for (int i=0;i<circularArr.size()-4;i++) {
			if (directionLL.get(i)=='t') {
				if (directionLL.get(i+1)=='t') {
					if (directionLL.get(i+2)=='t') {
						if (directionLL.get(i+3)=='t') {
							if (directionLL.get(i+4)=='t') {
								column++;
								i+=5;
							}
						}
					}
				}
			}
			else if (directionLL.get(i)=='b') {
				if (directionLL.get(i+1)=='b') {
					if (directionLL.get(i+2)=='b') {
						if (directionLL.get(i+3)=='b') {
							if (directionLL.get(i+4)=='b') {
								column++;
								i+=5;
							}
						}
					}
				}
			}
		}
		
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
			}
			else if (directionLL.get(i)=='r') {
				if (directionLL.get(i+1)=='b') {
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
		for (int i=0;i<circularArr.size()-3;i++) {
			
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
		
		
		double ctemp = ((double) c_curve / (double) directionLL.size())*100 ;
		double Atemp = ((double) A_edge / (double) directionLL.size())*100 ;
		double ftemp = ((double) flat / (double) directionLL.size())*100 ;
		double coltemp = ((double) column / (double) directionLL.size())*100 ;
		double cornertemp = ((double) corner / (double) directionLL.size())*100 ;
		
		curved_Percentage = round(ctemp,2);
		sharp_Percentage=round(Atemp,2);
		column_Percentage= round(coltemp,2);
		flat_Percentage = round(ftemp,2);
		corner_Percentage = round(cornertemp,2);
		
		percentageArr = new double[] {curved_Percentage, sharp_Percentage, 
				flat_Percentage, column_Percentage, corner_Percentage}; 
	}
	
	private void identifyLetter() {

		
		if (numOfLoops==0) {
			// 43 total
			
			// left column
			// K, h, k, m, n, r
			// M, N, i, l, I, E, F, L, H
			// 
			
			if (0.0<=leftUpper_dXdY && leftUpper_dXdY<0.45 && 
					-0.45<=leftLower_dXdY && leftLower_dXdY<=0.0) {

				//checkMatch(percentageArr);
				
				//letter = "leftColumn";
			}
			
			
			// c-shaped left side
			// C, G, c
			
			// curves
			// J, j, S, s, U, a, f, u, 2, 3, 5
			
			// 90 degree angles
			// T, t
			
			// 70 degree
			// V, W, v , w
			
			// X, Y, Z
			// x, y, z
			// 1, 7
			
		}
		else if (numOfLoops==1) {
			
			letter = "1_loop";
			
			// 18 total
			//c-shaped left side
			// O, e, o, 6, 0
			
			//left column
			// D, P, R, b, p
			
			//right column
			// d
			
			//left rising edge
			// A, 4
			
			// misc...
			// Q, a, g, q, 9
			
		}
		else if (numOfLoops==2) {
			// 2 total:
			// B and 8
			// potentially g...
			if (0.0<=leftUpper_dXdY && leftUpper_dXdY<0.4 && 
					-0.4<=leftLower_dXdY && leftLower_dXdY<=0.0) {
				letter = "B";
			}
			else letter = "8";
		}
		
		
	}
	
	private void checkMatch(double[] arr) {
		
		double[] K = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		double[] M = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		double[] N = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		double[] E = new double[] {0.4, 0.5, 10.0, 5.0, 4.0, 14.0}; //
		double[] F = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		double[] L = new double[] {0.7, 0.55, 6.7, 8.8, 2.0, 7.7};
			

		for (int i=0;i<percentageArr.length;i++) {
			K[i]=percentSimilarityBetweenTwoDoubles(arr[i], K[i]);
			M[i]=percentSimilarityBetweenTwoDoubles(arr[i], M[i]);
			N[i]=percentSimilarityBetweenTwoDoubles(arr[i], N[i]);
			E[i]=percentSimilarityBetweenTwoDoubles(arr[i], E[i]);
			F[i]=percentSimilarityBetweenTwoDoubles(arr[i], F[i]);
			L[i]=percentSimilarityBetweenTwoDoubles(arr[i], L[i]);
		}

		double aveK = 0.0;
		double aveM = 0.0;
		double aveN = 0.0;
		double aveE = 0.0;
		double aveF = 0.0;
		double aveL = 0.0;
		
		for (int i=0;i<percentageArr.length;i++) {
			aveK+=K[i];
			aveM+=M[i];
			aveN+=N[i];
			aveE+=E[i];
			aveF+=F[i];
			aveL+=L[i];
		}
		
		aveK = round((aveK/percentageArr.length),2);
		aveM = round((aveM/percentageArr.length),2);
		aveN = round((aveN/percentageArr.length),2);
		aveE = round((aveE/percentageArr.length),2);
		aveF = round((aveF/percentageArr.length),2);
		aveL = round((aveL/percentageArr.length),2);
		
		Map<Double, String> map = new HashMap<Double, String>();
		
		map.put(aveK, "K");
		map.put(aveM, "M");
		map.put(aveN, "N");
		map.put(aveE, "E");
		map.put(aveF, "F");
		map.put(aveL, "L");

		double highest=0.0;
		double[] d = new double[] {aveK, aveM, aveN, aveE, aveF, aveL};

		for (int i=0;i<d.length;i++) {
			if (d[i]>highest) highest=d[i];
		}
		
		letter = map.get(highest);
		percentMatch = highest;
	}

	
	
	
	
	private void findExternalEdgeofLetter() {
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

	private double percentSimilarityBetweenTwoDoubles(double A, double B) {
		double result=0.0;
		if (A==0.0 && B==0.0) {
			result = 1.0;
		}
		else if (B==0.0) {
			result = 0.0;
		}
		else if (A/B<1) {
			result = round((A/B),2);
		}
		else if (A/B>1) {
			result = round((B/A),2);
		}
		else if (A/B==1.0) {
			result = 1.0;
		}

		return result;
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

	private void printLetterInfo() {
		System.out.println(
				"\nFeatureWidth: " + featureWidth +
				", FeatureHeight: " + featureHeight +
				", Number of Loops: " + numOfLoops +
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
		
		System.out.println("Column%: " + column_Percentage
				+ ", Flat%: " + flat_Percentage
				+ ", SharpAngle%: " + sharp_Percentage
				+ ", CurvedAngle%: " + curved_Percentage
				+ ", Corner%: " + corner_Percentage
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

		System.out.println(letter + ", " + percentMatch + "%");
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
						 + fourthQuarter[2] + ", " + fourthQuarter[3]
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
















