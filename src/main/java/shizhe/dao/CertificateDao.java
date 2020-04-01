package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Certificate;

import java.util.List;

/**
 * CertificateDAO继承基类
 */
@Repository
public interface CertificateDAO extends MyBatisBaseDao<Certificate, Integer> {
    // 查询
    List<Certificate> selectByCondition(@Param("userId") String userId);

    // 新增
    Long insertCertificate(Certificate certificate);
    // 修改
    Long updateByUserId(Certificate certificate);
}