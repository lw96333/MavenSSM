package com.one.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
//��ͼƬת��Ϊ����ͼ
public class ResizeImage {
      /**
     * @Description: ȡ��ͼƬ����
     * @param Ҫת����ͼ����ļ���,���Ǵ��ͼ����ļ���·�� 
     * @date 2017��5��7��10:48:27
     */
    public BufferedImage zoomImage(BufferedImage im, int toWidth , int toHeight) {
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);
        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        return result;
    }
    /**
     * 
     * @Description: ȡ��ͼƬ����
     * @param Ҫת����ͼ����ļ���,���Ǵ��ͼ����ļ���·�� 
     * @date 2017��5��7��10:48:27
     */
    public BufferedImage getImageList(String ImgList, String[] type) throws IOException{
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        for(String s : type) {
            map.put(s,true);
        }
       BufferedImage imageList = null;
        File file = null;
            file = new File(ImgList);
            try{
                if(file.length() != 0 && map.get(getExtension(file.getName())) != null ){
                    imageList = javax.imageio.ImageIO.read(file);
                }
            }catch(Exception e){
                imageList = null;
            }

        return imageList;
    }

    /**
     * ��ͼƬд��������
     * @param im
     * @param path     eg: C://home// ͼƬд����ļ��е�ַ
     * @param fileName DCM1987.jpg  д��ͼƬ������
     * @date 2017��5��7��10:48:27
     */

    public boolean writeToDisk(BufferedImage im, String path, String fileName) {
        File f = new File(path + fileName);
        String fileType = getExtension(fileName);
        if (fileType == null)
            return false;
        try {
            ImageIO.write(im, fileType, f);
            im.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    /**
     * 
     * @Description: ����ͼƬ
     * @param String path , BufferedImage im, String fileFullPath 
     * @date 2017��5��7��10:48:27
     */
    public boolean writeHighQuality(String path , BufferedImage im, String fileFullPath) throws IOException {
            //return true;
            FileOutputStream newimage = null;
        try {
           // ������ļ���
            newimage = new FileOutputStream(fileFullPath+path);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
            // ѹ������ 
            jep.setQuality(1f, true);
            encoder.encode(im, jep);
           //��JPEG����
            newimage.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 
     * @Description: ȡ�ļ����ĺ�׺
     * @param String fileName ��ʽ�磺cn1100000213EA_1_xnl.jpg
     * @date 2017��5��7��10:48:27
     */
    public String getExtension(String fileName) {
        try {
            return fileName.split("\\.")[fileName.split("\\.").length - 1];
        } catch (Exception e) {
            return null;
        }
    }
}
