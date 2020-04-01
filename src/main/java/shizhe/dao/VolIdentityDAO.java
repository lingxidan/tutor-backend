package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.VolIdentity;

import java.util.List;

/**
 * VolIdentityDAO继承基类
 */
@Repository
public interface VolIdentityDAO extends MyBatisBaseDao<VolIdentity, Integer> {
    // 申请认证
    Long applyRecrIdenty(VolIdentity volIdentity);
    // 查询列表
    List<VolIdentity> selectIdentys(@Param("volId") Integer volId);
    // 查询列表
    List<VolIdentity> selectAllIdentys(@Param("result") Integer result);
    // 认证结果
    Long updateIdenty(VolIdentity volIdentity);
    // 认证结果
    VolIdentity selectLastIdentity(@Param("volId") Integer volId);

}