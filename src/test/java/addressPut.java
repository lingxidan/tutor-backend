
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import shizhe.bean.Address;
import shizhe.dao.DatadictDao;
import shizhe.entity.TextToShow;

import java.io.*;
import java.sql.SQLException;

public class addressPut {
    static DatadictDao addressDao;
//    static FileService fileService;
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\简巨科技\\文件\\转正申请书-张泽丹.docx";
        String newfilePath = "D:\\简巨科技\\文件\\转正申请书-张泽丹.pdf";
        TextToShow convert = new TextToShow(new File(filePath), new File(newfilePath));
        convert.word2pdf(filePath,newfilePath);
//        String imgPath = transformToImg(filePath);
//        System.out.println(imgPath);
//        TextToShow convert = new TextToShow(new File(filePath), new File(imgPath));
//        boolean success = convert.convert();
//        System.out.println("文本转图片：" + (success ? "成功" : "失败"));
//        System.out.println((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));
//        String path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\trade.json";
//        BufferedReader br = new BufferedReader(
//                new FileReader(path));
//
//        String line = "";
//        StringBuilder data= new StringBuilder();
//        while ((line = br.readLine()) != null) {
//            // 一次读入一行数据
//            data.append(line);
//        }
////        System.out.println(line);
//        JSONObject jobj = JSON.parseObject(data.toString());
//        JSONArray links = jobj.getJSONArray("zpData");
//        System.out.println(links);
////        String path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\province.json";
////        try {
////            try {
////                readFromFile(path);
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
    }

    public static String transformToImg(String filePath) throws IOException {
        //创建写入流对象
        String file_name = filePath.substring(0, filePath.lastIndexOf('.'));
        String imgPath = file_name+".jpg";
//        BufferedOutputStream outputStream =new BufferedOutputStream(new FileOutputStream(imgPath));
//        //输入流对象
//        BufferedReader inputStream = new BufferedReader(new FileReader(filePath)) ;//new FileInputStream("D:/ddddd.txt");
//        String str = null;
//        while((str=inputStream.readLine()) !=null){
//            byte[] bs = str.getBytes();
////            byte a = (byte) str;
//            outputStream.write(bs);
//        }
//        outputStream.close();
//        inputStream.close();
        return imgPath;
    }
    public static void readFromFile(String path) throws IOException, SQLException {
        BufferedReader br = new BufferedReader(
                new FileReader(path));
        String line = br.readLine();
            JSONObject jobj = JSON.parseObject(line);
            JSONArray links = jobj.getJSONArray("data");
        System.out.println(links);
            for (int i = 0 ; i < links.size();i++){
                JSONObject key1 = (JSONObject)links.get(i);
                Address addr=new Address();
                addr.setCode((String)key1.get("code"));
                addr.setName((String)key1.get("name"));
                addr.setLevel((Integer)key1.get("level"));
                addr.setPcode((String)key1.get("pcode"));
//                addressDao.insert(addr);
//                String name = (String)key1.get("name");
//                String url = (String)key1.get("url");
//                System.out.println(name);
//                System.out.println(url);
            }
//            Object user_id = responseJson.get("user_id");
//            Object username = responseJson.get("username");
//            Object name = responseJson.get("name");
//            Object age = responseJson.get("age");
//            Object professional = responseJson.get("professional");
//            Object city = responseJson.get("city");
//            Object sex = responseJson.get("sex");
//            String sql = "insert into user_info values (?,?,?,?,?,?,?)";
//            Object [] params = {user_id,username,name,age,professional,city,sex};
//            QueryRunner qr = JDBCUtil.getQueryRunner();
//            qr.update(sql,params);


        br.close();
    }
}
