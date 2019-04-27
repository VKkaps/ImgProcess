package com.image_processing.letters.EnglishAlphabet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import com.image_processing.core.AbstractProcessImage;
import com.image_processing.core.Letter;
import com.image_processing.core.Pixel;


/*
 * 	SequentialRecursiveImpl is a class designed to operate purely sequentially for
 *  processing an Image.  
 * 
 * */
public class BinaryImageImpl extends AbstractProcessImage{
	
	//Image is divided into 4 quadrants.  Each quadrant has its own features (letters) which are contained in these HashMaps
	private Map<Integer, Letter> mapFeatures = new HashMap<Integer, Letter>();
	
	private TreeMap<Integer, LinkedList<Integer>> orgMap = null;
	
	//noticable, edge Pixel Queues for Parallelism processing purposes
	private Queue<Pixel> Core1noticableEdgePixelsQueue;
	
	//This list is used to store solely noticable, edge Pixels as opposed to all noticable Pixels in an image.
	private List<Pixel> edgePixList = new ArrayList<>();	
	
	// Fields needed for external testing/timing purposes
	private int findTime;
	private int initTime;
	private int sortTime;
	private int findFeaturesTime;
	

	private int featureWidth = 0;
	private int featureHeight = 0;
	
	
	private double[] topViewPercentages;
	private double[] bottomViewPercentages;
	private double[] rightViewPercentages;
	private double[] leftViewPercentages;
	
	private int[] i;
	
	private StringBuilder str = new StringBuilder();
	
	int index=0;


	public BinaryImageImpl(BufferedImage b) {
		super(b);
		run();
	}
	
	
	public void run() {
		findNoticablePixels(); 
		initializeNeighborPixels();
		sortAndInitQueues();
		findFeatures();
		identifyLetters();
		organizeLetters();
		index=0;
	}


	/*
	 * Initializes the parent field 'noticablePixList'.  A pixel is determined to be noticable if 
	 * it's average RGB value is less than (averageRGBPixelvalue - x) where x is a
	 * arbitrary int value, or the Pixel RGBAverage < 30. 
	 * 
	 * Note, for loop values are offset (1 instead of 0) to prevent ArrayOutOfBounds errors.
	 * 
	 * */
	public void findNoticablePixels() {
		final long startTime = System.currentTimeMillis();

		for (int y = 1; y < imageHeight-1; y++) {
		    for (int x = 1; x < imageWidth-1; x++) {
		    	
		    	/*For each Pixel in image, determine if it is noticable by passing in 
		    	 * the Image averageRGBPixelvalue.
		    	 * 
		    	 * If it is noticable, add it to the noticablePix list.
		    	 * */
		    	
		    	if (imageBinaryArray[x][y]==1) {
		    		imagePixelArray[x][y].setIsNoticable();
		    		noticablePixList.add(imagePixelArray[x][y]);
		    	}
		    }
		}
		
        final long endTime = System.currentTimeMillis();
        findTime = Math.toIntExact(endTime - startTime);

       // System.out.println("\nClass: SequentialRecursiveImpl");             
    //    System.out.println("findNoticablePixels execution time: " + (endTime - startTime) + " ms");      
	}
	
	
	/* For each pixel, check if neighbor pixels (left, right , top, and bottom) are noticable
	 *  or not.  If so, initialize this noticable neighbor pixel in the current pixel.
	 */
	public void initializeNeighborPixels() {
        final long startTime = System.currentTimeMillis();
        
		int leftX;
		int rightX;
		int topY;
		int bottomY;
		
		for (Pixel p : noticablePixList) {
			
			leftX = p.getXcoor()-1;
			rightX = p.getXcoor()+1;
			topY = p.getYcoor()-1;
			bottomY = p.getYcoor()+1;		
			
			if (imagePixelArray[leftX][p.getYcoor()].isNoticable()) {
				p.setLeft(imagePixelArray[leftX][p.getYcoor()]);
			}
			if (imagePixelArray[rightX][p.getYcoor()].isNoticable()) {
				p.setRight(imagePixelArray[rightX][p.getYcoor()]);
			}
			if (imagePixelArray[p.getXcoor()][topY].isNoticable()) {
				p.setTop(imagePixelArray[p.getXcoor()][topY]);
			}
			if (imagePixelArray[p.getXcoor()][bottomY].isNoticable()) {
				p.setBottom(imagePixelArray[p.getXcoor()][bottomY]);
			}
			
			
			if (imagePixelArray[leftX][topY].isNoticable()) {
				p.setNoticableLT(imagePixelArray[leftX][topY]);
			}
			if (imagePixelArray[rightX][topY].isNoticable()) {
				p.setNoticableRT(imagePixelArray[rightX][topY]);
			}
			if (imagePixelArray[leftX][bottomY].isNoticable()) {
				p.setNoticableLB(imagePixelArray[leftX][bottomY]);
			}
			if (imagePixelArray[rightX][bottomY].isNoticable()) {
				p.setNoticableRB(imagePixelArray[rightX][bottomY]);
			}
			
			/* Creates new List of noticable Edge Pixels.  Edge Pixels are what are important
			*  for building/finding Features in an image.  This optimizes performance.  If you used 
			*  every pixel in an image, the program would use too much memory, run for too long, and
			*  most likely be consumed with StackOverflow errors.
			*/
//			if (p.determineIfEdgePixel()) {
//				edgePixList.add(p);
//			}

		}
		

        final long endTime = System.currentTimeMillis();
        initTime = Math.toIntExact(endTime - startTime);

    //    System.out.println("initializeNeighborPixels execution time: " + initTime + " ms"); 
	}
	
	
	/*
	 * Sort edgePixList
	 * 
	 * */
	public void sortAndInitQueues() {
		final long startTimeOut = System.currentTimeMillis();
		
		//Sort edgePixList by X coordinate
		Collections.sort(noticablePixList);
		//noticablePixList = edgePixList;
		
		Core1noticableEdgePixelsQueue = new LinkedList<Pixel>(noticablePixList);

		final long endTimeOut = System.currentTimeMillis();
        sortTime = Math.toIntExact(endTimeOut - startTimeOut);
    //    System.out.println("sortAndInitQueues execution time: " + sortTime  + " ms");	
    //    System.out.println("Number of noticable edge pixels: " + noticablePixList.size() + " pixels");
	}

	
	/*
	 * Take a queue of noticable edge pixels and traverse thru them grouping
	 * them into features using a recursive method "preorderTraversal".
	 * 
	 * */
	public void findFeatures() {
		final long startTimeOut = System.currentTimeMillis();
		

		int mapPointer=0;
		ArrayList<Pixel> Letter = new ArrayList<Pixel>();	// Start with an empty arraylist, and create new one every time recursive traversal ends.
		Letter f = null;
		try {
			while (!Core1noticableEdgePixelsQueue.isEmpty()) {
				preorderTraversal(Core1noticableEdgePixelsQueue.remove(), Letter);
				if (Letter.size()>20) {
					f = new Letter(Letter);//, rawImage, index, alphabet); //, rawImage, index);
					mapFeatures.put(mapPointer, f); 
					mapPointer++;
					index++;
				}
				Letter = new ArrayList<Pixel>();
			}
		} catch (StackOverflowError e) {
			System.out.println("\nStack overflow error!! -vfk: " + e.getMessage());
			//System.exit(1);
		}
		//System.out.println(Letter.size());
		
//		featureWidth = f.getWidthOfFeature();
//		featureHeight = f.getHeightOfFeature();
//		
//		topViewPercentages = f.getTopViewPercentages();
//		bottomViewPercentages = f.getBottomViewPercentages();
//		leftViewPercentages = f.getLeftViewPercentages();
//		rightViewPercentages = f.getRightViewPercentages();
//		
//		 //top  bottom  left  right
//		i = f.getAllChangeAndTransitions();
		

       // System.out.println("Number of Features: " + mapFeatures.size() + " features");

        
	    final long endTimeOut = System.currentTimeMillis();
	    findFeaturesTime = Math.toIntExact(endTimeOut - startTimeOut);
	//    System.out.println("findFeatures execution time: " + findFeaturesTime  + " ms");
	}
	
	
	/*
	 * Iterate thru each Letter that was found and determine which letter it is
	 * 
	 * */
	private void identifyLetters() {
		for (int i=0;i<mapFeatures.size();i++) {
			str.insert(i, mapFeatures.get(i).identifyLetter());
		}
	}
	
	private void organizeLetters() {

		orgMap = new TreeMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int totalHeight=0;
		
		for (Letter f : mapFeatures.values()) {
			ll.add(f.getXcoor());
			if (!orgMap.containsKey(f.getYcoor())) {
				orgMap.put(f.getYcoor(), ll);
				ll = new LinkedList<Integer>();
			}
			else {
				ll = orgMap.get(f.getYcoor());
				ll.add(f.getXcoor());
				orgMap.put(f.getYcoor(), ll);
				ll = new LinkedList<Integer>();
			}
			totalHeight+=f.getHeightOfFeature();
		}	
		int aveHeight = totalHeight/mapFeatures.size();

		Set<Integer> s = orgMap.keySet();
		Integer[] yArray = s.stream().toArray(Integer[]::new);
		
		//organize s by size
		LinkedList<Integer> newL = new LinkedList<Integer>();
		HashMap<Integer, List<Integer>> rowMap = new HashMap<Integer, List<Integer>>();
		
		if (yArray.length==1) {
			newL.add(yArray[0]);
			rowMap.put(rowMap.size(), newL);
		}
		else {
			for (int i=0;i<yArray.length-1;i++) {
				if(yArray[i+1]-yArray[i]<aveHeight/2) {
					newL.add(yArray[i]);
					if(i==yArray.length-2) {
						newL.add(yArray[i+1]);
						rowMap.put(rowMap.size(), newL);
					}
				}
				else {
					newL.add(yArray[i]);
					rowMap.put(rowMap.size(), newL);
					newL = new LinkedList<Integer>();
					if(yArray[i+1]-yArray[i]>aveHeight/2) {
						if(i==yArray.length-2) {
							newL.add(yArray[i+1]);
							rowMap.put(rowMap.size(), newL);
						}
					}
				}
			}
		}
		
		List<Letter> list = new ArrayList<Letter>(mapFeatures.values());
		//Sort edgePixList by X coordinate
		Collections.sort(list);
		
		// sorted letters by X  AND  rowMap - which is number is rows
		
		// Map -> row to LettersInRow
		TreeMap<Integer, List<Letter>> rowsOfLettersMap = new TreeMap<Integer, List<Letter>>();
		System.out.println("\nNumber of rows: "+rowMap.size());
		List<Letter> lettersInRow = null;
		
		List<Integer> tempRowY = null;
		for (int i=0;i<rowMap.size();i++) {
			tempRowY = rowMap.get(i);
			for (Integer in : tempRowY) {
				for (Letter l : list) {
					if (l.getYcoor()==in) {
						if (rowsOfLettersMap.get(i)==null) {
							lettersInRow = new LinkedList<Letter>();
							lettersInRow.add(l);
							rowsOfLettersMap.put(i, lettersInRow);
						}
						else {
							lettersInRow = rowsOfLettersMap.get(i);
							lettersInRow.add(l);
							rowsOfLettersMap.put(i, lettersInRow);
						}
					}
				}
			}
			
			
		}
		
		List<Letter> temp = new LinkedList<Letter>();
		str.delete(0, str.length());
		for (int i=0;i<rowsOfLettersMap.size();i++) {
			temp = rowsOfLettersMap.get(i);
			Collections.sort(temp);
			for (Letter l : temp) {
//				System.out.print(l.getLetter());
				str.append(l.getLetter());
			}
//			System.out.print("\n");
			str.append("\n");
		}

		System.out.println(str);		
	}
	
	

	/*
	 * Recursive PreOrder Traversal of noticablePixels.  Essentially builds Features via recursion.
	 * If a current noticable pixel has a neighboring noticable pixel add current 
	 * noticable pixel to a growing pixel list, which is a Letter.  Then, go thru
	 * Recursive process starting with the current noticable pixel's right neighbor
	 * Pixel.
	 */
	public void preorderTraversal(Pixel p, ArrayList<Pixel> Letter) {

		if(p !=  null && !Letter.contains(p)) { 
			Letter.add(p);
			Core1noticableEdgePixelsQueue.remove(p);

			preorderTraversal(p.getRight(), Letter);
			preorderTraversal(p.getBottom(), Letter);
			preorderTraversal(p.getTop(), Letter);
			preorderTraversal(p.getLeft(), Letter);

		}
		
	}
	
	
	
	////////////GETTERS/////////////

	public void boxFeaturesInImage() {
		boxFeatures(mapFeatures);
	}

	public int getFindTime() {
		return findTime;
	}
	
	public int getInitTime() {
		return initTime;
	}
	
	public int getFindFeaturesTime() {
		return findFeaturesTime;
	}
	
	public int getPixels() {
		return edgePixList.size();
	}
	
	public int getFeatures() {
		return mapFeatures.size();
	}
	
	public int getFeatureWidth() {
		return featureWidth;
	}
	
	public int getFeatureHeight() {
		return featureHeight;
	}
	
	public int getNumberOfFeaturesInImage() {
		return mapFeatures.size();
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
	
	public int[] getAllChangeAndTransitions() {
		return i;
	}
	
	
	public String getIdentifiedText() {
		return str.toString();
	}


	@Override
	protected void processImage() {
		// TODO Auto-generated method stub
		
	}
	
}






