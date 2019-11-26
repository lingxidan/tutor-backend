package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Contact;

import java.util.List;

@Repository
public interface ContactDao {
    // 查询
    Contact selectById(@Param("id") int id);
    List<Contact> selectByCondition(@Param("userId") String userId);

    // 新增
    Long insertContact(Contact contact);
    // 修改
    Long updateByUserId(Contact contact);
}