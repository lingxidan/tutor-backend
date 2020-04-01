package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Certificate;
import shizhe.dao.CertificateDAO;
import shizhe.dao.DatadictDAO;
//import shizhe.dao_bak.CertificateDao;
//import shizhe.dao_bak.SchoolDao;

import java.util.ArrayList;
import java.util.List;

@Service("CertificateService")
public class CertificateService {
    @Autowired
    CertificateDAO certificateDao;
//    @Autowired
//    SchoolDao schoolDao;

    public List<Certificate> selectByCondition(String userId){
        return certificateDao.selectByCondition(userId);
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
