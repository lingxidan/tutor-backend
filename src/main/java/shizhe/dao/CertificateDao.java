package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Certificate;

import java.util.List;

@Repository
public interface CertificateDao {
    // 查询
    Certificate selectById(@Param("id") int id);
    List<Certificate> selectByCondition(@Param("userId") String userId);

    // 新增
    Long insertCertificate(Certificate certificate);
    // 修改
    Long updateByUserId(Certificate certificate);
}