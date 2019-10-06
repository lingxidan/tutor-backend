package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shizhe.bean.ResumeFile;
import shizhe.bean.School;
import shizhe.dao.DatadictDao;
import shizhe.dao.FileDao;
import shizhe.dao.SchoolDao;
import shizhe.entity.TextToShow;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("FileService")
public class FileService {
    @Autowired
    FileDao resumeFileDao;
    // 查询
    public ResumeFile selectById(int id){
        ResumeFile resumeFile=resumeFileDao.selectById(id);
        return resumeFile;
    }
    public List<ResumeFile> selectByCondition(String userId,
                                       String upDt){
        List<ResumeFile> resumeFileList=resumeFileDao.selectByCondition(userId,upDt);
        return resumeFileList;
    }

    // 新增
    public Long insertFile(ResumeFile resumeFile){
        return resumeFileDao.insertFile(resumeFile);
    }
    // 修改
    public Long updateFile(ResumeFile resumeFile){
        return resumeFileDao.updateFile(resumeFile);
    }
    // 删除
    public Integer deleteFile(int id){
        return resumeFileDao.deleteFile(id);
    }

    public ResumeFile transformToShow(MultipartFile file) throws IOException {
        // 原文件路径、原文件名、原文件后缀名、存储原文件
        String fileName = file.getOriginalFilename();
        String path = "D:/code/git/shizhe_front/static/files/";
        String file_name = fileName.substring(0, fileName.lastIndexOf('.'))+ "_"+new Date().getTime();
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String filePath = path + file_name + suffix;

        File newFile = new File(filePath);
        file.transferTo(newFile);

        // 新文件名、新路径名、新后缀名
        String newSuffix = "";
        boolean success = false;
        if(suffix.equals(".pdf")){
            newSuffix=".pdf";
            success = true;
        }else{
            if(suffix.equals(".txt")){
                newSuffix = ".jpg";
            }
            if(suffix.equals(".doc")||suffix.equals(".docx")){
                newSuffix=".pdf";
            }
            String newFilePath = path + file_name + newSuffix;
            TextToShow convert = new TextToShow(new File(filePath), new File(newFilePath));
            if(newSuffix.equals(".jpg")){
                success = convert.convert();
            }
            if(newSuffix.equals(".pdf")){
                success=convert.word2pdf(filePath, newFilePath);
            }
        }
        String newFilePath = path + file_name + newSuffix;
        ResumeFile resumeFile = new ResumeFile();
        resumeFile.setName(file_name + newSuffix);
        resumeFile.setFilepath(newFilePath);
        resumeFile.setStatus(success?1:-1);
        return resumeFile;
    }
}
