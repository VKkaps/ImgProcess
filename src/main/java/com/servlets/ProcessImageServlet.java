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

import com.image_processing.letters.EnglishAlphabet.SequentialRecursiveImpl;


/**
 * Servlet implementation class addImage
 */

@MultipartConfig
public class ProcessImageServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        BufferedImage imBuff = ImageIO.read(fileContent);

        // Choose implementation here
		new SequentialRecursiveImpl(imBuff).boxFeaturesInImage(imBuff);

     
        String base64String = encodeToString(imBuff, "jpg");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.append(base64String);
        out.close();
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




