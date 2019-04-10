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
//将图片转换为略缩图
public class ResizeImage {
      /**
     * @Description: 取得图片对象
     * @param 要转化的图像的文件夹,就是存放图像的文件夹路径 
     * @date 2017年5月7日10:48:27
     */
    public BufferedImage zoomImage(BufferedImage im, int toWidth , int toHeight) {
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);
        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        return result;
    }
    /**
     * 
     * @Description: 取得图片对象
     * @param 要转化的图像的文件夹,就是存放图像的文件夹路径 
     * @date 2017年5月7日10:48:27
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
     * 把图片写到磁盘上
     * @param im
     * @param path     eg: C://home// 图片写入的文件夹地址
     * @param fileName DCM1987.jpg  写入图片的名字
     * @date 2017年5月7日10:48:27
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
     * @Description: 生成图片
     * @param String path , BufferedImage im, String fileFullPath 
     * @date 2017年5月7日10:48:27
     */
    public boolean writeHighQuality(String path , BufferedImage im, String fileFullPath) throws IOException {
            //return true;
            FileOutputStream newimage = null;
        try {
           // 输出到文件流
            newimage = new FileOutputStream(fileFullPath+path);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
            // 压缩质量 
            jep.setQuality(1f, true);
            encoder.encode(im, jep);
           //近JPEG编码
            newimage.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 
     * @Description: 取文件名的后缀
     * @param String fileName 格式如：cn1100000213EA_1_xnl.jpg
     * @date 2017年5月7日10:48:27
     */
    public String getExtension(String fileName) {
        try {
            return fileName.split("\\.")[fileName.split("\\.").length - 1];
        } catch (Exception e) {
            return null;
        }
    }
}
