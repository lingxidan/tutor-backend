package shizhe.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;

/**
 * 文本转图片类
 * @author YY2924 2014/11/18
 * @version 1.0
 */
public class TextToShow {

    public static final String DOC = "doc";
    public static final String DOCX = "docx";
    public static final String PDF = "pdf";
    public static final String XLS = "xls";
    public static final String XLSX = "xlsx";
    public static final String MP4 = "mp4";
    public static final String PPT = "ppt";
    public static final String PPTX = "pptx";

    // 8 代表word保存成html
    public static final int WORD2HTML = 8;
    // 17代表word保存成pdf
    public static final int WD2PDF = 17;
    public static final int PPT2PDF = 32;
    public static final int XLS2PDF = 0;

    /** 文本文件  */
    private File textFile;
    /** 图片文件 */
    private File imageFile;

    /** 图片 */
    private BufferedImage image;
    /** 图片宽度  */
    private final int IMAGE_WIDTH = 400;
    /** 图片高度 */
    private final int IMAGE_HEIGHT = 600;
    /** 图片类型  */
    private final int IMAGE_TYPE = BufferedImage.TYPE_INT_RGB;

    /**
     * 构造函数
     * @param textFile 文本文件
     * @param imageFile 图片文件
     */
    public TextToShow(File textFile, File imageFile){
        this.textFile = textFile;
        this.imageFile = imageFile;
        this.image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_TYPE);
    }

    /**
     * 将文本文件里文字，写入到图片中保存
     * @return boolean  true，写入成功；false，写入失败
     */
    public boolean convert() {

        //读取文本文件
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(textFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        //获取图像上下文
        Graphics g = createGraphics(image);
        String line;
        //图片中文本行高
        final int Y_LINEHEIGHT = 15;
        int lineNum = 1;
        try {
            while((line = reader.readLine()) != null){
                g.drawString(line, 0, lineNum * Y_LINEHEIGHT);
                lineNum++;
            }
            g.dispose();

            //保存为jpg图片
            FileOutputStream fos = new FileOutputStream(imageFile);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
            encoder.encode(image);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取到图像上下文
     * @param image 图片
     * @return Graphics
     */
    private Graphics createGraphics(BufferedImage image){
        Graphics g = image.createGraphics();
        g.setColor(Color.WHITE); //设置背景色
        g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);//绘制背景
        g.setColor(Color.BLACK); //设置前景色
        g.setFont(new Font("微软雅黑", Font.PLAIN, 12)); //设置字体
        return g;
    }

    public boolean word2pdf(String docfile, String pdffile)
    {
        // 启动word应用程序(Microsoft Office Word 2003)
        ActiveXComponent app =app = new ActiveXComponent("Word.Application");
        try{
            ComThread.InitSTA();
            app.setProperty("Visible", false);
            System.out.println("*****正在转换...*****");
            // 设置word应用程序不可见
            // app.setProperty("Visible", new Variant(false));
            // documents表示word程序的所有文档窗口，（word是多文档应用程序�?
            Dispatch docs = app.getProperty("Documents").toDispatch();
            // 打开要转换的word文件
           /* Dispatch doc = Dispatch.invoke(
                    docs,
                    "Open",
                    Dispatch.Method,
                    new Object[] { docfile, new Variant(false),
                            new Variant(true) }, new int[1]).toDispatch(); */

            Dispatch doc = Dispatch.call(
                    docs,
                    "Open",
                    docfile,
                    false,
                    true).toDispatch();
            // 调用Document对象的saveAs方法,将文档保存为pdf格式
            /*Dispatch.invoke(doc, "ExportAsFixedFormat", Dispatch.Method, new Object[] {
            		pdffile, new Variant(wdFormatPDF) }, new int[1]);*/

            Dispatch.call(doc, "ExportAsFixedFormat", pdffile, WD2PDF);
            // 关闭word文件
            Dispatch.call(doc, "Close", false);
        }
        catch (Exception e)
        {   ComThread.Release();
            e.printStackTrace();
            return false;
        }
        finally
        {
            //关闭word应用程序
            app.invoke("Quit", 0);
            ComThread.Release();
        }
        return true;
    }

}
