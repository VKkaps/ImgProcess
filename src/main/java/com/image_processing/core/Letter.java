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
	private ArrayList<String> temp = new ArrayList<String>();
	Integer[][] copy;
	private ArrayList<Integer> verticalTransitionPoints = new ArrayList<Integer>();	
		
	boolean b = false;
	LinkedList<Character> cArr = new LinkedList<Character>();
	Queue<Character> queue = null; 
	
	int c_curve = 0;
	int D_curve = 0;
	int A_edge = 0;
	int flat = 0;
	int column = 0;
	int corner = 0;
	
	private double leftUpper_dXdY = 0.0;
	private double leftLower_dXdY = 0.0;
	
	private double rightUpper_dXdY = 0.0;
	private double rightLower_dXdY = 0.0;
	
	private double topUpper_dXdY = 0.0;
	private double topLower_dXdY = 0.0;
	
	private double bottomUpper_dXdY = 0.0;
	private double bottomLower_dXdY = 0.0;
	
	int oneTop = 0;
	int oneBottom = 0;
	int oneLeft = 0;
	int oneRight = 0;
	
	String letter = "_";
	private double percentMatch = 0.0;
	double[] tempD = null;

	
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
		generateCircularSeqCharacterList();
		classify();
		
		identifyLetter();

		System.out.println(letter + ", " + percentMatch);
		
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
		System.out.println("\n");
	}
	
	
	private void generateCircularSeqCharacterList() {
		
		int firstX = 0;
		
		for (int x=0; x<featureWidth;x++) {
			if (featureIntArray[x][featureHeight/2]==5) {
				firstX = x;
				break;
			}
		}
		
		recursiveIt(firstX, featureHeight/2);
		
		featureIntArray[firstX][featureHeight/2+1]=2;
		

		for (int x=0; x<featureWidth;x++) {
			if (featureIntArray[x][featureHeight/2]==1) {
				firstX = x;
				break;
			}
		}
		
		//newRecursivetest(firstX, featureHeight/2);
		
		
		for (int y=0;y<featureHeight;y++) {
			for (int x=0;x<featureWidth;x++) {
				if (featureIntArray[x][y]==1) {
					if (featureIntArray[x-1][y-1]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x][y-1]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x+1][y-1]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x-1][y]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x][y]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x+1][y]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x-1][y+1]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x][y+1]==8) {
						featureIntArray[x][y]=7;
					}
					else if (featureIntArray[x+1][y+1]==8) {
						featureIntArray[x][y]=7;
					}
				}
			}
		}
		
		
		
		for (int y=0;y<featureHeight;y++) {
			for (int x=0;x<featureWidth;x++) {
				if (featureIntArray[x][y]!=2) {
					featureIntArray[x][y]=0;
				}
			}
		}
		
		printIntegerArray();
		System.out.println(featureWidth + ", " + featureHeight);
	}
			
	
	
	public void recursiveIt(int x, int y) {
		
		//top
		if (featureIntArray[x][y-1]==5) {
			cArr.add('t');
			featureIntArray[x][y]=2;
			recursiveIt(x, y-1);
		}
		
		//right
		if (featureIntArray[x+1][y]==5) {
			cArr.add('r');
			featureIntArray[x][y]=2;
			recursiveIt(x+1, y);
		}
		
		//left
		if (featureIntArray[x-1][y]==5) {
			cArr.add('l');
			featureIntArray[x][y]=2;
			recursiveIt(x-1, y);
		}
		
		//bottom
		if (featureIntArray[x][y+1]==5) {
			cArr.add('b');
			featureIntArray[x][y]=2;
			recursiveIt(x, y+1);
		}

	}

	
	
	
	
	
	private void classify() {
		//queue = new LinkedList<>(cArr);

		LinkedList<Character> cArr1 = new LinkedList<Character>(cArr);
		LinkedList<Character> cArr2 = new LinkedList<Character>(cArr);
		LinkedList<Character> cArr3 = new LinkedList<Character>(cArr);
		LinkedList<Character> cArr4 = new LinkedList<Character>(cArr);
		
		
		// flat check
		for (int i=0;i<cArr1.size()-4;i++) {
			if (cArr1.get(i)=='r') {
				if (cArr1.get(i+1)=='r') {
					if (cArr1.get(i+2)=='r') {
						if (cArr1.get(i+3)=='r') {
							flat++;
							i+=4;
						}
					}
				}
			}
			else if (cArr1.get(i)=='l') {
				if (cArr1.get(i+1)=='l') {
					if (cArr1.get(i+2)=='l') {
						if (cArr1.get(i+3)=='l') {
							flat++;
							i+=4;
						}
					}
				}
			}
		}
		
		//column check
		for (int i=0;i<cArr2.size()-4;i++) {
			if (cArr2.get(i)=='t') {
				if (cArr2.get(i+1)=='t') {
					if (cArr2.get(i+2)=='t') {
						if (cArr2.get(i+3)=='t') {
							column++;
							i+=4;
						}
					}
				}
			}
			else if (cArr2.get(i)=='b') {
				if (cArr2.get(i+1)=='b') {
					if (cArr2.get(i+2)=='b') {
						if (cArr2.get(i+3)=='b') {
							column++;
							i+=4;
						}
					}
				}
			}
		}
		
		//A-edge
		for (int i=0;i<cArr3.size()-4;i++) {
			if (cArr3.get(i)=='t') {
				if (cArr3.get(i+1)=='t') {
					if (cArr3.get(i+2)=='t') {
						if (cArr3.get(i+3)=='r') {
							if (cArr3.get(i+4)=='t') {
								A_edge++;
								i+=4;
							}
						}
						else if (cArr3.get(i+3)=='l') {
							if (cArr3.get(i+4)=='t') {	
								A_edge++;
								i+=4;
							}
						}
					}
				}
			}
			else if (cArr3.get(i)=='b') {
				if (cArr3.get(i+1)=='b') {
					if (cArr3.get(i+2)=='b') {
						if (cArr3.get(i+3)=='r') {
							if (cArr3.get(i+4)=='b') {
								A_edge++;
								i+=4;
							}
						}
						else if (cArr3.get(i+3)=='l') {
							if (cArr3.get(i+4)=='b') {	
								A_edge++;
								i+=4;
							}
						}
					}

				}
			}
		}	
		
		//c-curve check
		for (int i=0;i<cArr4.size()-4;i++) {
			if (cArr3.get(i)=='l') {
				if (cArr3.get(i+1)=='l') {
					if (cArr3.get(i+2)=='l') {
						if (cArr3.get(i+3)=='t') {
							if (cArr3.get(i+4)=='l') {
								c_curve++;
								i+=4;
							}
						}
						else if (cArr3.get(i+3)=='b') {
							if (cArr3.get(i+4)=='l') {	
								c_curve++;
								i+=4;
							}
						}
					}
				}
			}
			else if (cArr3.get(i)=='r') {
				if (cArr3.get(i+1)=='r') {
					if (cArr3.get(i+2)=='r') {
						if (cArr3.get(i+3)=='t') {
							if (cArr3.get(i+4)=='r') {
								c_curve++;
								i+=4;
							}
						}
						else if (cArr3.get(i+3)=='b') {
							if (cArr3.get(i+4)=='r') {	
								c_curve++;
								i+=4;
							}
						}
					}
				}
			}
			
		}
		
		
		
		//corner check
		for (int i=0;i<cArr4.size()-6;i++) {
			if (cArr3.get(i)=='b') {
				if (cArr3.get(i+1)=='b') {
						if (cArr3.get(i+2)=='r') {
							if (cArr3.get(i+3)=='r') {
								corner++;
							}
						}
						else if (cArr3.get(i+2)=='l') {
							if (cArr3.get(i+3)=='l') {
								corner++;
							}
						}
				
				}
			}	
			
			else if (cArr3.get(i)=='r') {
				if (cArr3.get(i+1)=='r') {
						if (cArr3.get(i+2)=='t') {
							if (cArr3.get(i+3)=='t') {
								corner++;
							}
						}
						else if (cArr3.get(i+2)=='b') {
							if (cArr3.get(i+3)=='b') {
								corner++;
							}
						}
				}
			}	
			
			else if (cArr3.get(i)=='l') {
				if (cArr3.get(i+1)=='l') {
					if (cArr3.get(i+2)=='t') {
						if (cArr3.get(i+3)=='t') {
							corner++;
						}
					}
				else if (cArr3.get(i+3)=='b') {
					if (cArr3.get(i+4)=='b') {
						corner++;
					}
				}
				}
			}
			
			else if (cArr3.get(i)=='t') {
				if (cArr3.get(i+1)=='t') {
					if (cArr3.get(i+2)=='l') {
						if (cArr3.get(i+3)=='l') {
							corner++;
						}
					}
					else if (cArr3.get(i+2)=='r') {
						if (cArr3.get(i+3)=='r') {
							corner++;
						}
					}
				}
			}
			
			double ctemp = ((double) c_curve / (double) cArr.size())*100 ;
			double Atemp = ((double) A_edge / (double) cArr.size())*100 ;
			double ftemp = ((double) flat / (double) cArr.size())*100 ;
			double coltemp = ((double) column / (double) cArr.size())*100 ;
			
			double c = round(ctemp,2);
			double A = round(Atemp,2);
			double f = round(ftemp,2);
			double col = round(coltemp,2);
			
			tempD = new double[] {c, A, f, col, corner, verticalTransitionPoints.size()}; 
			
			
			
		}			
					
					

		
		
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

				checkMatch(tempD);
				
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
			printLetterInfo();
			if (0.0<=leftUpper_dXdY && leftUpper_dXdY<0.4 && 
					-0.4<=leftLower_dXdY && leftLower_dXdY<=0.0) {
				letter = "B";
			}
			else letter = "8";
		}
		
		
	}
	
	private void checkMatch(double[] arr) {
		
		double[] K = new double[] {0.94, 0.94, 1.89, 4.72, 4.0, 2.0};
		double[] M = new double[] {0.74, 5.19, 2.22, 9.63, 7.0, 1.0};
		double[] N = new double[] {0.0, 0.0, 1.77, 8.85, 6.0, 1.0};
		double[] E = new double[] {0.0, 0.0, 12.0, 5.0, 12.0, 3.0};
		double[] F = new double[] {0.0, 0.0, 7.89, 6.58, 10, 2.0};
		double[] L = new double[] {0.0, 0.0, 6.67, 10.0, 6.0, 1.0};
			

		for (int i=0;i<6;i++) {
			if (arr[i]==0.0) arr[i]=0.001;
			if (round((K[i]/arr[i]),4)>1.00) {
				K[i]= 2 - (round((K[i]/arr[i]),4));
			}
			else {
				K[i]= round((K[i]/arr[i]),4);
			}
			if (round((M[i]/arr[i]),4)>1.00) {
				M[i]= 2 - (round((M[i]/arr[i]),4));
			}
			else {
				M[i]= round((M[i]/arr[i]),4);
			}
			if (round((N[i]/arr[i]),4)>1.00) {
				N[i]= 2 - (round((N[i]/arr[i]),4));
			}
			else {
				N[i]= round((N[i]/arr[i]),4);
			}
			if (round((E[i]/arr[i]),4)>1.00) {
				E[i]= 2 - (round((E[i]/arr[i]),4));
			}
			else {
				E[i]= round((E[i]/arr[i]),4);
			}
			if (round((F[i]/arr[i]),4)>1.00) {
				F[i]= 2 - (round((F[i]/arr[i]),4));
			}
			else {
				F[i]= round((F[i]/arr[i]),4);
			}
			if (round((L[i]/arr[i]),4)>1.00) {
				L[i]= 2 - (round((L[i]/arr[i]),4));
			}
			else {
				L[i]= round((L[i]/arr[i]),4);
			}
		}
		
		double aveK = 0.0;
		double aveM = 0.0;
		double aveN = 0.0;
		double aveE = 0.0;
		double aveF = 0.0;
		double aveL = 0.0;
		
		
		Map<Double, String> map = new HashMap<Double, String>();
		
		double[] d = new double[6];
		
		for (int i=0;i<5;i++) {
			if (K[i]>500.0) K[i]=0;
			aveK+=K[i];
		}
		aveK = round(aveK/6,2);
		d[0] = aveK;
		map.put(aveK, "K");
		
		for (int i=0;i<4;i++) {
			if (M[i]>500.0) M[i]=0;
			aveM+=M[i];
		}
		aveM = round(aveM/6,2);
		d[1] = aveM;
		map.put(aveM, "M");
		
		for (int i=0;i<4;i++) {
			if (N[i]>500.0) N[i]=0;
			aveN+=N[i];
		}
		aveN = round(aveN/6,2);
		d[2] = aveN;
		map.put(aveN, "N");
		
		for (int i=0;i<4;i++) {
			if (E[i]>500.0) E[i]=0;
			aveE+=E[i];
		}
		aveE = round(aveE/6,2);
		d[3] = aveE;
		map.put(aveE, "E");
		
		for (int i=0;i<4;i++) {
			if (F[i]>500.0) F[i]=0;
			aveF+=F[i];
		}
		aveF = round(aveF/6,2);
		d[4] = aveF;
		map.put(aveF, "F");
		
		for (int i=0;i<4;i++) {
			if (L[i]>500.0) L[i]=0;
			aveL+=L[i];
		}
		aveL = round(aveL/6,2);
		d[5] = aveL;
		map.put(aveL, "L");
		
		double highest = 0.0;
		for (int i=0;i<d.length;i++) {
			if (d[i]>highest) highest=d[i];
		}
		
		letter = map.get(highest);
		percentMatch = highest;
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
	}
	
	private void printIntegerArray() {
		for (int y = 0; y < featureHeight; y++) {
			for (int x = 0; x < featureWidth; x++) {
				System.out.print(featureIntArray[x][y]+" ");
			}
			System.out.println();
		}	
	}
	
	
}
















