package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Contact;
import shizhe.dao.ContactDao;
import shizhe.dao.DatadictDao;
import shizhe.dao.SchoolDao;

import java.util.List;

@Service("ContactService")
public class ContactService {
    @Autowired
    ContactDao contactDao;
    @Autowired
    DatadictDao datadictDao;
    @Autowired
    SchoolDao schoolDao;
    // 查询
    public Contact selectById(int id){
        Contact contact=contactDao.selectById(id);
        return contact;
    }
    public List<Contact> selectByCondition(String userId){
        List<Contact> contactList=contactDao.selectByCondition(userId);
        return contactList;
    }

    // 新增
    public Long insertContact(Contact contact){
        return contactDao.insertContact(contact);
    }
    // 修改
    public Long updateContact(Contact contact){
        return contactDao.updateByUserId(contact);
    }
}
