package com.tecsoon.www.common;
    
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
    
public class FileContentTypeCheck {
	private final static Map<String, String> FILE_CONTENTTYPE_MAP = new HashMap<String, String>();
        
    private FileContentTypeCheck() {
    }
    
    static {
        getAllFileType();//初始化文件类型信息    
    }
        
    /**
     * 常见文件头信息 
     */    
    private static void getAllFileType() {
        FILE_CONTENTTYPE_MAP.put("jpg", "FFD8FF"); //JPEG (jpg)
        FILE_CONTENTTYPE_MAP.put("jpeg", "FFD8FF");
        FILE_CONTENTTYPE_MAP.put("jpe", "FFD8FF");
        FILE_CONTENTTYPE_MAP.put("jfif", "FFD8FF");
        FILE_CONTENTTYPE_MAP.put("png", "89504E47");//PNG (png)
        FILE_CONTENTTYPE_MAP.put("gif", "47494638");//GIF (gif)
        FILE_CONTENTTYPE_MAP.put("tif", "49492A00");//TIFF (tif)
        FILE_CONTENTTYPE_MAP.put("bmp", "424D"); //Windows Bitmap (bmp)
        FILE_CONTENTTYPE_MAP.put("dib", "424D");
        FILE_CONTENTTYPE_MAP.put("dbx", "CFAD12FEC5FD746F");//Outlook Express (dbx)
        FILE_CONTENTTYPE_MAP.put("pst", "2142444E");//Outlook (pst)
        FILE_CONTENTTYPE_MAP.put("doc", "D0CF11E0");//MS Excel 注意：word 和 excel的文件头一样
        FILE_CONTENTTYPE_MAP.put("docx", "504B030414"); //MS Excel 注意：word 和 excel的文件头一样
        FILE_CONTENTTYPE_MAP.put("wpd", "FF575043"); //WordPerfect (wpd)
        FILE_CONTENTTYPE_MAP.put("pdf", "255044462D312E");//Adobe Acrobat (pdf)
        FILE_CONTENTTYPE_MAP.put("qdf", "AC9EBD8F");//Quicken (qdf)
    }
    
//    public static void main(String[] args) throws Exception    
//    {
//        File f = new File("d://1 - 副本.txt");
//        String fileType = FileTypeMap.getDefaultFileTypeMap().getContentType("d://a");
//        if (f.exists())
//        {
//            String filetype1 = getImageFileType(f);
//            System.out.println(filetype1);
//            String filetype2 = getFileByFile(f);
//            System.out.println(filetype2);
//        }
//    }
    
    /**
     * 获取图片文件实际类型,若不是图片则返回null
     */    
    public final static String getImageFileType(File imageFile) {
        if (isImage(imageFile)) {
            try {
                ImageInputStream iis = ImageIO.createImageInputStream(imageFile);
                Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
                if (!iter.hasNext()) {
                    return null;
                }
                ImageReader reader = iter.next();
                iis.close();
                return reader.getFormatName().toLowerCase();
            } catch (IOException e) {
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
    
    /**
     * 获取文件类型,包括图片,若格式不是已配置的,则返回null
     */    
    public final static String getFileByFile(File file) {
        String filetype = null;
        byte[] b = new byte[50];
        try {
            InputStream is = new FileInputStream(file);
            is.read(b);
            filetype = getFileTypeByStream(b);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filetype;
    }
        
    /**
     * getFileTypeByStream
     */    
    private final static String getFileTypeByStream(byte[] b) {
        String filetypeHex = String.valueOf(getFileHexString(b));
        Iterator<Entry<String, String>> entryiterator = FILE_CONTENTTYPE_MAP.entrySet().iterator();
        while (entryiterator.hasNext()) {
            Entry<String,String> entry =  entryiterator.next();
            String fileTypeHexValue = entry.getValue();
            if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {
                return entry.getKey();
            }
        }
        return null;
    }
        
    /**
     * 判断文件是否为图片
     */  
    private static final boolean isImage(File file) {
        boolean flag = false;
        try {
            BufferedImage bufreader = ImageIO.read(file);
            int width = bufreader.getWidth();
            int height = bufreader.getHeight();
            if (width == 0 || height == 0) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (IOException e) {
            flag = false;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
      
    /**
     * getFileHexString
     */    
    private final static String getFileHexString(byte[] b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (b == null || b.length <= 0) {
            return null;
        }
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}