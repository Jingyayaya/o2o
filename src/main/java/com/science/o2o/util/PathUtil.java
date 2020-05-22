package com.science.o2o.util;

public class PathUtil {
    private static String separator=System.getProperty("file.separator");
    public static String getImagBasePath(){
        String os=System.getProperty("os.name");
        String basePath="";
        if(os.toLowerCase().startsWith("win")){
            basePath="D:/wjy/Baylor/images";
        }
        else{
            basePath="/home/javaweb/image/";
        }
        basePath=basePath.replace("/", separator);
        return basePath;
    }
    public static String getShopImagePath(long shopId){
        String imagePath="/upload/item/shop/"+shopId+"/";
        return imagePath.replace("/", separator);
    }
}
