package org.daistudy.onjava.concurrent.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageDownloader extends Thread {

    private String url;
    private String filename;

    public ImageDownloader(String url, String filename){
        this.url = url;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            File destination = new File(this.filename);
            FileUtils.copyURLToFile(new URL(this.url), destination);
            System.out.println("文件地址：" + destination.getAbsolutePath());
            System.out.println("文件大小：" + destination.length() + " 个字节");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ImageDownloader类中出现IO异常：" + e);
        }
    }

    public static void main(String[] args) {
        ImageDownloader imageDownloader1 = new ImageDownloader("http://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/7acb0a46f21fbe098b8aaf1c67600c338644ade6.jpg", "test/imgs/1.png");
        ImageDownloader imageDownloader2 = new ImageDownloader("http://images0.cnblogs.com/blog/470278/201311/09194040-e3a20cef9f66475cb777de09cae42087.png", "test/imgs/2.png");
        ImageDownloader imageDownloader3 = new ImageDownloader("http://aliyunzixunbucket.oss-cn-beijing.aliyuncs.com/jpg/560728d623252356eb2c99898e38d978.jpg", "test/imgs/3.png");
        ImageDownloader imageDownloader4 = new ImageDownloader("http://images.cnitblog.com/i/521895/201404/151031196825786.jpg", "test/imgs/4.png");
        imageDownloader1.start();
        imageDownloader2.start();
        imageDownloader3.start();
        imageDownloader4.start();
    }
}
