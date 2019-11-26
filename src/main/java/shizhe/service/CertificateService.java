package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Certificate;
import shizhe.dao.DatadictDao;
import shizhe.dao.CertificateDao;
import shizhe.dao.SchoolDao;

import java.util.List;

@Service("CertificateService")
public class CertificateService {
    @Autowired
    CertificateDao certificateDao;
    @Autowired
    DatadictDao datadictDao;
    @Autowired
    SchoolDao schoolDao;
    // 查询
    public Certificate selectById(int id){
        Certificate certificate=certificateDao.selectById(id);
        return certificate;
    }
    public List<Certificate> selectByCondition(String userId){
        List<Certificate> certificateList=certificateDao.selectByCondition(userId);
        return certificateList;
    }

    // 新增
    public Long insertCertificate(Certificate certificate){
        return certificateDao.insertCertificate(certificate);
    }
    // 修改
    public Long updateCertificate(Certificate certificate){
        return certificateDao.updateByUserId(certificate);
    }
}
