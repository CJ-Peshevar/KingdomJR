package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Resources {
	public static boolean LoadFromJar = true;

	private static Map<String, Image> imageCache = new HashMap<String, Image>();
	private static Image emptyImage;

	// The static prints the current absolute path as a debug helper. It will tell us which folder
	// the application is looking in when it's looking for files (i.e. relative paths). The static
	// block here is executed when the type is initialized, so we don't even have to create an
	// instance of Resources or call a method manually.
	static{
		determineCurrentDirectory();

		// Make a fallback image so we know when an image is missing.
		loadEmptyImage();
	}

	private static void determineCurrentDirectory(){
		Path currentRelativePath = Paths.get("");
		System.out.println(String.format("The current relative path is '%s'.", currentRelativePath.toAbsolutePath()));
	}

	private static void loadEmptyImage(){
		emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics g = emptyImage.getGraphics();
		g.setColor(Color.magenta);
		g.fillRect(0, 0, 1, 1);
		g.dispose();
	}

	public static Image loadImage(String fileName){
		try {
			return loadImageInternal(fileName);
		}
		catch (IOException e) {
			System.out.println(String.format("Cannot load image '%s'. Reason: %s", fileName, e));
		}

		return null;
	}

	public static Image loadImage(String category, String fileName){
		String key = String.format("%s/%s", category, fileName);

		try {
			return loadImageInternal(key);
		}
		catch (IOException e) {
			System.out.println(String.format("Cannot load image '%s' from category '%s'. Reason: %s", fileName, category, e));
		}

		return null;
	}

	public static Image loadImage(String category, String subCategory, String fileName){
		String key = String.format("%s/%s/%s", category, subCategory, fileName);

		try {
			return loadImageInternal(key);
		}
		catch (IOException e) {
			System.out.println(String.format("Cannot load image '%s' from category '%s/%s'. Reason: %s", fileName, category, subCategory, e));
		}

		return null;
	}

	private static Image loadImageInternal(String key) throws IOException{
		// Don't load images multiple times, because that would be inefficient.
		if (imageCache.containsKey(key)){
			return imageCache.get(key);
		}

		Image image = null;

		if (LoadFromJar){
			URL url = Resources.class.getResource(String.format("/img/%s", key));

			if (url != null){
				image = Toolkit.getDefaultToolkit().getImage(url);
			}
		}
		else {
			String path = String.format("./img/%s", key);
			System.out.println(String.format("Loading image from path '%s'.", path));

			image = ImageIO.read(new File(path));
		}

		imageCache.put(key, image);
		return image;
	}

	public static Image loadImageOrFallback(String category, String fileName){
		Image image = loadImage(category, fileName);
		return image != null ? image : emptyImage;
	}

	public static Image loadImageOrFallback(String category, String subCategory, String fileName){
		Image image = loadImage(category, subCategory, fileName);
		return image != null ? image : emptyImage;
	}
}