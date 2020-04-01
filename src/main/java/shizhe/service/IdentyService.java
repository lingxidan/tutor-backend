package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.RecrIdentity;
import shizhe.bean.VolIdentity;
import shizhe.dao.RecrIdentityDAO;
import shizhe.dao.VolIdentityDAO;

import java.util.List;

@Service("IdentyService")
public class IdentyService {
    @Autowired
    RecrIdentityDAO recrIdentityDAO;
    @Autowired
    VolIdentityDAO volIdentityDAO;
    // 招募者身份认证
    public Integer applyRecrIdenty(RecrIdentity recrIdentity){
        recrIdentityDAO.applyRecrIdenty(recrIdentity);
        int id = recrIdentity.getId();
        return id;
    }
    // 招募者身份认证
    public List<RecrIdentity> selectRecrIdentys(int recrId){
        List<RecrIdentity> identities = recrIdentityDAO.selectIdentys(recrId);
        return identities;
    }
    // 招募者身份认证
    public List<RecrIdentity> selectAllRecrIdentys(int result){
        List<RecrIdentity> identities = recrIdentityDAO.selectAllIdentys(result);
        return identities;
    }
    // 招募者身份认证结果
    public Boolean updateRecrIdenty(int id,String describe,int result){
        RecrIdentity recrIdentity = new RecrIdentity();
        recrIdentity.setDescribe(describe);
        recrIdentity.setResult(result);
        recrIdentity.setId(id);
        Long res = recrIdentityDAO.updateIdenty(recrIdentity);
        return res == 1;
    }
    // 招募者最新身份认证
    public RecrIdentity getLasrRecrIdenty(int recrId){
        RecrIdentity recrIdentity = recrIdentityDAO.selectLastIdentity(recrId);
        return recrIdentity;
    }


    // 志愿者身份认证
    public Integer applyVolIdenty(VolIdentity volIdentity){
        volIdentityDAO.applyRecrIdenty(volIdentity);
        int id = volIdentity.getId();
        return id;
    }
    // 志愿者身份认证
    public List<VolIdentity> selectVolIdentys(int volId){
        List<VolIdentity> identities = volIdentityDAO.selectIdentys(volId);
        return identities;
    }
    // 志愿者身份认证
    public List<VolIdentity> selectAllVolIdentys(Integer result){
        List<VolIdentity> identities = volIdentityDAO.selectAllIdentys(result);
        return identities;
    }
    // 志愿者身份认证结果
    public Boolean updateVolIdenty(int id,String describe,int result){
        VolIdentity volIdentity = new VolIdentity();
        volIdentity.setDescribe(describe);
        volIdentity.setResult(result);
        volIdentity.setId(id);
        Long res = volIdentityDAO.updateIdenty(volIdentity);
        return res == 1;
    }
    // 志愿者最新身份认证
    public VolIdentity getLasrVolIdenty(int volId){
        VolIdentity volIdentity = volIdentityDAO.selectLastIdentity(volId);
        return volIdentity;
    }
}
