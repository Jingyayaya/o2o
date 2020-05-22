package com.science.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String separator=System.getProperty("file.separator");
    private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1);
    private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r=new Random();
    private static Logger logger= LoggerFactory.getLogger(ImageUtil.class);

    /**
     * Transfer CommonsMultipartFile into File
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr){
        //randomly get a name that is not duplicated.
        String realFileName = getRandomFileName();
        // Get the file extension such as png, jpg etc.
        String extension = getFileExtension(fileName);
        // If the target address doesn't exist, automatically make a directory
        makeDirPath(targetAddr);

        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is :" + relativeAddr);
        File dest = new File(PathUtil.getImagBasePath() + relativeAddr);
        logger.debug("current complete addr is :" + PathUtil.getImagBasePath() + relativeAddr);
        logger.debug("basePath is :" + basePath);
        String filepath=basePath + "watermark.jpg";
        filepath.replace("/",separator);

        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(filepath)), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            throw new RuntimeException("failure：" + e.toString());
        }
        return relativeAddr;
    }

    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImagBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * Get the extension of the file
     * @param
     * @return
     */
    private static String getFileExtension(String fileName) {

        return fileName.substring(fileName.lastIndexOf("."));
    }
    public static String getRandomFileName() {
        // Randomly get a number with 5 digits
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws Exception {

        Thumbnails.of(new File("D:\\wjy\\Baylor\\images\\panda.jpg"))
                .size(200,200).watermark(Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f)
        .outputQuality(0.8f).toFile("D:\\wjy\\Baylor\\images\\pandanew.jpg");

    }
}
