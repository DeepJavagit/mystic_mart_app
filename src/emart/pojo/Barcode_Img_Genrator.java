/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import javax.swing.SpringLayout;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 *
 * @author Acer
 */
public class Barcode_Img_Genrator {
    
     public static void CreateImage(String Image_name, String myString){
         try{
             Code128Bean code128 = new Code128Bean();
             code128.setHeight(15f);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             BitmapCanvasProvider canvas;
             canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
             code128.generateBarcode(canvas, myString);
             canvas.finish();
             String userid = System.getProperty("user.dir");
             System.out.println("user dir is"+userid);
             FileOutputStream fos = new FileOutputStream(userid+"\\Barcode\\"+Image_name);
             fos.write(baos.toByteArray());
             fos.flush();
             fos.close();
            
         }catch(Exception ex){  
             System.out.println("Exception in Barcode genrator"+ex.getMessage());
         }
     }
}
