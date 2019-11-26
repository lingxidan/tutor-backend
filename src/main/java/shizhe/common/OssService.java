package shizhe.common;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.ServiceException;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OssService {

    public static void main(String[] args){
//        uploadFile("key", "/Users/developer/Documents/intelij-javaee/pollutantsurvey-backend/upload/temp/3abaadba-8f9d-43bc-b492-aee1eddf6c541.jpg");
//        getAllBuckets(ossClient);
        getUrl(getOssClient(), "fileName");
        // 关闭OSSClient。
    }

    public static OSSClient getOssClient(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com/";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI0jKAFcP3DXXi";
        String accessKeySecret = "tOASq3fDuEXa8MVMdfkra7yqukfQqu";

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    public static boolean uploadFile(String objKey, String path){
        OSSClient ossClient = getOssClient();
        String bucketName = "jianju-nongchang";
        PutObjectRequest put = new PutObjectRequest(bucketName, objKey, new File(path));
        try {
            PutObjectResult putResult = ossClient.putObject(put);
            System.out.println("PutObject:" + "UploadSuccess");
            System.out.println("ETag " +  putResult.getETag());
            System.out.println("RequestId " + putResult.getRequestId());
        } catch (ClientException e) {
            // 本地异常如网络异常等
            e.printStackTrace();
            return false;
        } catch (ServiceException e) {
            // 服务异常
            System.out.println("RequestId " + e.getRequestId());
            System.out.println("ErrorCode " + e.getErrorCode());
            System.out.println("HostId "+ e.getHostId());
            return false;
        }
        ossClient.shutdown();
        return true;

    }

    public static boolean uploadFile(String objKey, File file){
        OSSClient ossClient = getOssClient();
        String bucketName = "jianju-nongchang";
        PutObjectRequest put = new PutObjectRequest(bucketName, objKey, file);
        try {
            PutObjectResult putResult = ossClient.putObject(put);
            System.out.println("PutObject:" + "UploadSuccess");
            System.out.println("ETag " +  putResult.getETag());
            System.out.println("RequestId " + putResult.getRequestId());
        } catch (ClientException e) {
            // 本地异常如网络异常等
            e.printStackTrace();
            return false;
        } catch (ServiceException e) {
            // 服务异常
            System.out.println("RequestId " + e.getRequestId());
            System.out.println("ErrorCode " + e.getErrorCode());
            System.out.println("HostId "+ e.getHostId());
            return false;
        }
        ossClient.shutdown();
        return true;

    }

    public static boolean uploadStream(String objKey, InputStream inputStream){
        OSSClient ossClient = getOssClient();
        String bucketName = "jianju-nongchang";
        PutObjectRequest put = new PutObjectRequest(bucketName, objKey, inputStream);
        try {
            PutObjectResult putResult = ossClient.putObject(put);
            System.out.println("PutObject:" + "UploadSuccess");
            System.out.println("ETag " +  putResult.getETag());
            System.out.println("RequestId " + putResult.getRequestId());
        } catch (ClientException e) {
            // 本地异常如网络异常等
            e.printStackTrace();
            return false;
        } catch (ServiceException e) {
            // 服务异常
            System.out.println("RequestId " + e.getRequestId());
            System.out.println("ErrorCode " + e.getErrorCode());
            System.out.println("HostId "+ e.getHostId());
            return false;
        }
        ossClient.shutdown();
        return true;

    }

    public static List<String> uploadFiles(List<MultipartFile> files){
        OSSClient ossClient = getOssClient();
        List<String> urls = new ArrayList<>();
        String bucketName = "jianju-nongchang";
        for (MultipartFile file : files){
            try {
                SimpleDateFormat tempDate = new SimpleDateFormat("yyyy/MM/dd/HH/");
                String datetime = tempDate.format(new Date());
                String extension = file.getOriginalFilename();
                extension =  FileUtils.getFileExtension(extension);
                String objKey = datetime + UUID.randomUUID().toString() + "." + extension;

                PutObjectRequest put = new PutObjectRequest(bucketName, objKey, file.getInputStream());
                PutObjectResult putResult = ossClient.putObject(put);
                System.out.println("PutObject:" + "UploadSuccess");
                System.out.println("ETag " +  putResult.getETag());
                System.out.println("RequestId " + putResult.getRequestId());

                urls.add(objKey);

            } catch (ClientException | IOException e) {
                // 本地异常如网络异常等
                System.out.println("local error");
                e.printStackTrace();
                System.out.println("本地异常");
                return null;
            } catch (ServiceException e) {
                // 服务异常
                System.out.println("RequestId " + e.getRequestId());
                System.out.println("ErrorCode " + e.getErrorCode());
                System.out.println("HostId "+ e.getHostId());
                e.printStackTrace();
                return null;
            }
        }

        ossClient.shutdown();
        return urls;

    }



    public static URL getUrl(OSSClient ossClient, String objectName){
        String bucketName = "jianju-nongchang";
        long now = System.currentTimeMillis();
        Long ex = 3600L * 1000L * 24L * 365L * 100L + now;
        Date expiration = new Date(ex);
        URL url = ossClient.generatePresignedUrl(bucketName, objectName, expiration);
        System.out.println("url:" + url.toString());
        return url;
    }

    public static void downloadObject(){

    }

    public static void createBucket(OSSClient ossClient, String bucketName){
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
// 设置存储空间的权限为公共读，默认是私有读写。
//        createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
// 设置存储空间的存储类型为低频访问类型，默认是标准类型。
//        createBucketRequest.setStorageClass(StorageClass.IA);
        try {
            ossClient.createBucket(createBucketRequest);
        }catch (OSSException e){
            System.out.println("resourceType:" + e.getResourceType());
            System.out.println("message:" + e.getMessage());
        }

    }

    public static List<Bucket> getAllBuckets(OSSClient ossClient){
        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(" - " + bucket.getName());
            System.out.println(" - " + bucket.getLocation());
            System.out.println(" - " + bucket.getExtranetEndpoint());
            System.out.println(" - " + bucket.getIntranetEndpoint());
        }
        return buckets;
    }
}
