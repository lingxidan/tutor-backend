package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.RecrIdentity;
import shizhe.bean.VolIdentity;

import java.util.List;

/**
 * RecrIdentityDAO继承基类
 */
@Repository
public interface RecrIdentityDAO extends MyBatisBaseDao<RecrIdentity, Integer> {
    // 申请认证
    Long applyRecrIdenty(RecrIdentity recrIdentity);
    // 查询列表
    List<RecrIdentity> selectIdentys(@Param("recrId") Integer recrId);
    // 查询列表
    List<RecrIdentity> selectAllIdentys(@Param("result") Integer result);
    // 认证结果
    Long updateIdenty(RecrIdentity recrIdentity);
    // 认证结果
    RecrIdentity selectLastIdentity(@Param("recrId") Integer recrId);
}