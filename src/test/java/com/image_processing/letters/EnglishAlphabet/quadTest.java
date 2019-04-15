/**
 * 
 */
package com.image_processing.letters.EnglishAlphabet;

import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import mockit.*;



/**
 * @author kapustinv
 *
 */
public class quadTest {
	
	private BufferedImage testImage = null;
	private QuadParallelRecursiveImpl seq = null;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		try {
			testImage = ImageIO.read(new File("C:\\sample_images\\testImages\\JUnit\\ARIAL16.jpg")); 
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		seq = new QuadParallelRecursiveImpl(testImage);
		seq.run();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		assertEquals("Number of expected Features: 26, Number of Found"
				+ " Features: " + seq.getNumberOfFeaturesInImage(), 26, seq.getNumberOfFeaturesInImage());
	}

}