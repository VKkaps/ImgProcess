package com.servlets;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;

import com.image_processing.letters.EnglishAlphabet.DualParallelRecursiveImpl;
import com.image_processing.letters.EnglishAlphabet.SequentialRecursiveImpl;


/**
 * Servlet implementation class addImage
 */

@MultipartConfig
public class ProcessImageServlet extends HttpServlet {
	
	private String str = null;
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        BufferedImage imBuff = ImageIO.read(fileContent);

        // Choose implementation here
        SequentialRecursiveImpl s = new SequentialRecursiveImpl(imBuff);
		s.boxFeaturesInImage();
		str = s.getIdentifiedText();

        String base64String = encodeToString(imBuff, "jpg");
        response.setContentType("text/html");
        PrintWriter out1 = response.getWriter();
        out1.append(base64String);
        out1.close();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {

        res.setContentType("text/html");
        PrintWriter out1 = res.getWriter();
        out1.append(str);
        out1.close();
	}
	

	public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            imageString = Base64.encodeBase64String(imageBytes);
 
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
	
}




