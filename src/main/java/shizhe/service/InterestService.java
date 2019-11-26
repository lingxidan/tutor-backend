package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Interest;
import shizhe.dao.InterestDao;

import java.util.List;

@Service("InterestService")
public class InterestService {
    @Autowired
    InterestDao interestDao;
    public List<Interest> selectByCondition(String userId,
                                            String type){
        List<Interest> interestList =interestDao.selectByCondition(userId,type);
        return interestList;
    }

    // 新增
    public int insertInterest(Interest interest){
        return interestDao.insert(interest);
    }

    // 删除
    public int deleteInterest(int interestId){
        return interestDao.deleteByPrimaryKey(interestId);
    }
}
