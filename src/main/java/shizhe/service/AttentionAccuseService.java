package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Accusation;
import shizhe.bean.Attention;
import shizhe.dao.AccusationDAO;
import shizhe.dao.AttentionDAO;

import java.util.List;
//import shizhe.dao_bak.InterestDao;


@Service("AttentionService")
public class AttentionAccuseService {
    @Autowired
    AttentionDAO attentionDAO;
    @Autowired
    AccusationDAO accusationDAO;

    public List<Attention> selectAttentionByCondition(Integer userId,
                                             Integer collectType,
                                             Integer collectId){
        return attentionDAO.selectByCondition(userId,collectType, collectId);
    }

    // 新增
    public int insertAttention(Attention attention){
        return attentionDAO.insert(attention);
    }

    // 删除
    public int deleteAttention(int id){
        return attentionDAO.deleteByPrimaryKey(id);
    }

    public List<Accusation> selectAccuseByCondition(Integer userId,
                                                    Integer accuseType,
                                                    Integer accuseId,
                                                    Integer accuseResult){
        return accusationDAO.selectByCondition(userId,accuseType,accuseId,accuseResult);
    }

    // 新增
    public int insertAccuse(Accusation accusation){
        accusation.setAccuseResult(0);
        return accusationDAO.insert(accusation);
    }

    // 更新
    public int updateAccuse(Integer id,Integer result){
        return accusationDAO.update(id,result);
    }
    // 删除
    public int deleteAccuse(Integer id){
        return accusationDAO.deleteByPrimaryKey(id);
    }
}
