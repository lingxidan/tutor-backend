package shizhe.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Address;
import shizhe.bean.Jobtype;
import shizhe.bean.License;
import shizhe.bean.Trade;
import shizhe.dao.DatadictDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service("AddressService")
public class DatadictService {

    @Autowired
    DatadictDao datadictDao;
    public Long insertAddress() throws IOException {
        String path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\province.json";
        BufferedReader br = new BufferedReader(
                new FileReader(path));
        String line = br.readLine();
        JSONObject jobj = JSON.parseObject(line);
        JSONArray links = jobj.getJSONArray("data");
        for (int i = 0 ; i < links.size();i++){
            JSONObject key1 = (JSONObject)links.get(i);
            Address addr=new Address();
            addr.setCode((String)key1.get("code"));
            addr.setName((String)key1.get("name"));
            addr.setLevel((Integer)key1.get("level"));
            addr.setPcode((String)key1.get("pcode"));
            datadictDao.insertAddress(addr);
        }
        br.close();

        path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\city.json";
        br = new BufferedReader(
                new FileReader(path));
        line = br.readLine();
        jobj = JSON.parseObject(line);
        links = jobj.getJSONArray("data");
        for (int i = 0 ; i < links.size();i++){
            JSONObject key1 = (JSONObject)links.get(i);
            Address addr=new Address();
            addr.setCode((String)key1.get("code"));
            addr.setName((String)key1.get("name"));
            addr.setLevel((Integer)key1.get("level"));
            addr.setPcode((String)key1.get("pcode"));
            datadictDao.insertAddress(addr);
        }
        br.close();
        path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\county.json";
        br = new BufferedReader(
                new FileReader(path));
        line = br.readLine();
        jobj = JSON.parseObject(line);
        links = jobj.getJSONArray("data");
        for (int i = 0 ; i < links.size();i++){
            JSONObject key1 = (JSONObject)links.get(i);
            Address addr=new Address();
            addr.setCode((String)key1.get("code"));
            addr.setName((String)key1.get("name"));
            addr.setLevel((Integer)key1.get("level"));
            addr.setPcode((String)key1.get("pcode"));
            datadictDao.insertAddress(addr);
        }
        br.close();
        return 1L;
    }

    public Long deleteAddress(){
        datadictDao.deleteAddress();
        return 1L;
    }

    public List<Address> selectAddress(int level, String pcode){
        return datadictDao.selectAddress(level,pcode);
//        return 1L;
    }

    public Long insertTrade() throws IOException {
        String path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\trade.json";
        BufferedReader br = new BufferedReader(
                new FileReader(path));
        String line = "";
        StringBuilder data= new StringBuilder();
        while ((line = br.readLine()) != null) {
            // 一次读入一行数据
            data.append(line);
        }
        JSONObject jobj = JSON.parseObject(data.toString());
        JSONArray links = jobj.getJSONArray("zpData");
        for (int i = 0 ; i < links.size();i++){
            JSONObject key1 = (JSONObject)links.get(i);
            Trade trade=new Trade();
            trade.setCode(key1.get("code").toString());
            trade.setName((String)key1.get("name"));
            trade.setPcode("1");
            datadictDao.insertTrade(trade);

            JSONArray subLinks = key1.getJSONArray("subLevelModelList");
            if(subLinks!=null) {
                for (int j = 0; j < subLinks.size(); j++) {
                    JSONObject key2 = (JSONObject) subLinks.get(j);
                    Trade tradeSub = new Trade();
                    tradeSub.setCode(key2.get("code").toString());
                    tradeSub.setName((String) key2.get("name"));
                    tradeSub.setPcode(trade.getCode());
                    datadictDao.insertTrade(tradeSub);
                }
            }
        }
        br.close();
        return 1L;
    }

    public Long deleteTrade(){
        datadictDao.deleteTrade();
        return 1L;
    }

    public List<Trade> selectTrade(){
        return datadictDao.selectTrade();
//        return 1L;
    }

    public Long insertJobtype() throws IOException {
        String path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\jobtype.json";
        BufferedReader br = new BufferedReader(
                new FileReader(path));
        String line = "";
        StringBuilder data= new StringBuilder();
        while ((line = br.readLine()) != null) {
            // 一次读入一行数据
            data.append(line);
        }
        JSONObject jobj = JSON.parseObject(data.toString());
        JSONArray links = jobj.getJSONArray("zpData");
        for (int i = 0 ; i < links.size();i++){
            JSONObject key1 = (JSONObject)links.get(i);
            Jobtype jobtype=new Jobtype();
            jobtype.setCode(key1.get("code").toString());
            jobtype.setName((String)key1.get("name"));
            jobtype.setPcode("1");
            datadictDao.insertJobtype(jobtype);

            JSONArray subLinks = key1.getJSONArray("subLevelModelList");
            if(subLinks!=null) {
                for (int j = 0; j < subLinks.size(); j++) {
                    JSONObject key2 = (JSONObject) subLinks.get(j);
                    Jobtype jobtypeSub = new Jobtype();
                    jobtypeSub.setCode(key2.get("code").toString());
                    jobtypeSub.setName((String) key2.get("name"));
                    jobtypeSub.setPcode(jobtype.getCode());
                    datadictDao.insertJobtype(jobtypeSub);

                    JSONArray subSubLinks = key2.getJSONArray("subLevelModelList");
                    if(subSubLinks!=null) {
                        for (int k = 0; k < subSubLinks.size(); k++) {
                            JSONObject key3 = (JSONObject) subSubLinks.get(k);
                            Jobtype jobtypeSubSub = new Jobtype();
                            jobtypeSubSub.setCode(key3.get("code").toString());
                            jobtypeSubSub.setName((String) key3.get("name"));
                            jobtypeSubSub.setPcode(jobtypeSub.getCode());
                            datadictDao.insertJobtype(jobtypeSubSub);
                        }
                    }
                }
            }
        }
        br.close();
        return 1L;
    }

    public Long deleteJobType(){
        datadictDao.deleteTrade();
        return 1L;
    }

    public List<Jobtype> selectJobtype(){
        return datadictDao.selectJobtype();
//        return 1L;
    }

    public Long insertLicense() throws IOException {
        String path="D:\\code\\git\\shizhe\\src\\test\\java\\files\\license.json";
        BufferedReader br = new BufferedReader(
                new FileReader(path));
        String line = "";
        StringBuilder data= new StringBuilder();
        while ((line = br.readLine()) != null) {
            // 一次读入一行数据
            data.append(line);
        }
        JSONObject jobj = JSON.parseObject(data.toString());
        JSONArray links = jobj.getJSONArray("zpData");
        for (int i = 0 ; i < links.size();i++){
            JSONObject key1 = (JSONObject)links.get(i);
            License license=new License();
            license.setName(key1.get("name").toString());
            license.setPname((String)key1.get("parentName"));
            datadictDao.insertLicense(license);

            JSONArray subLinks = key1.getJSONArray("subList");
            if(subLinks!=null) {
                for (int j = 0; j < subLinks.size(); j++) {
                    JSONObject key2 = (JSONObject) subLinks.get(j);
                    License licenseSub = new License();
                    licenseSub.setName(key2.get("name").toString());
                    licenseSub.setPname((String) key2.get("parentName"));
                    datadictDao.insertLicense(licenseSub);

                    JSONArray subSubLinks = key2.getJSONArray("subList");
                    if(subSubLinks!=null) {
                        for (int k = 0; k < subSubLinks.size(); k++) {
                            JSONObject key3 = (JSONObject) subSubLinks.get(k);
                            License licenseSubSub = new License();
                            licenseSubSub.setName(key3.get("name").toString());
                            licenseSubSub.setPname((String) key3.get("parentName"));
                            datadictDao.insertLicense(licenseSubSub);
                        }
                    }
                }
            }
        }
        br.close();
        return 1L;
    }

    public Long deleteLicense(){
        datadictDao.deleteLicense();
        return 1L;
    }

    public List<License> selectLicense(){
        return datadictDao.selectLicense();
//        return 1L;
    }

    public String selectAddressByCode(String code){
        return datadictDao.selectAddressByCode(code);
    }
}
