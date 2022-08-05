package test;

import com.sun.imageio.plugins.jpeg.JPEGImageWriter;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Shawn
 * @title: ImageDemo
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/3/24
 */
public class ImageDemo {
    public static void main(String[] args) throws IOException {
        File out = new File("E:\\Workspace\\IdeaWorkspace\\studyDemo\\src\\test\\java\\test\\image.png");
        //将图片写入ImageIO流
        try {
            //BufferedImage img = ImageIO.read(out);
            Image src2 = Toolkit.getDefaultToolkit().getImage("E:\\Workspace\\IdeaWorkspace\\studyDemo\\src\\test\\java\\test\\image.png");
            BufferedImage imageSrc = toBufferedImage(src2);
            //将图片写出到指定位置（复制图片）
            OutputStream ops = new FileOutputStream(new File("E:\\Workspace\\IdeaWorkspace\\studyDemo\\src\\test\\java\\test\\image1.png"));
            ImageIO.write(imageSrc, "png", ops);
        } catch (IOException e) {
            e.printStackTrace();
        }



       // Image src2 = Toolkit.getDefaultToolkit().getImage("image.png");
        File file = new File("\\aaa.png");
//        BufferedImage bu = ImageIO.read(file);
//        BufferedImage imageSrc = getBufferedImage("E:\\Workspace\\IdeaWorkspace\\studyDemo\\src\\test\\java\\test\\image.png");
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("../test"));
//        ImageOutputStream ios  =  ImageIO.createImageOutputStream(bos);
//        JPEGImageWriter imageWriter  =  (JPEGImageWriter) ImageIO.getImageWritersBySuffix("jpg").next();
//        IIOMetadata imageMetaData = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(imageSrc),null);
//        JPEGImageWriteParam jpegParams = (JPEGImageWriteParam) imageWriter.getDefaultWriteParam();
//        jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
//        jpegParams.setCompressionQuality(1.0f);
//
//        imageWriter.setOutput(ios);
//        bos.close();
//        imageWriter.write(imageMetaData,new IIOImage(imageSrc,null,null),null);
//        ios.close();
//        imageWriter.dispose();
    }

    // 这里是直接根据url读取图片
    public static BufferedImage toBufferedImage(Image  image) throws MalformedURLException {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null),
                    image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
        // Copy image to buffered image
        Graphics2D g = bimage.createGraphics();

        // 增加透明度解决png透明图片会变黑的问题
        bimage = g.getDeviceConfiguration().createCompatibleImage(image.getWidth(null), image.getHeight(null), Transparency.TRANSLUCENT);
        g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }
}
