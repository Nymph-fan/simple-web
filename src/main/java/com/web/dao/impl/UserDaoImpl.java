package com.web.dao.impl;

import com.web.dao.IUserDao;
import com.web.domain.User;
import com.web.util.XmlUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.text.SimpleDateFormat;

/**
 * @author anyun
 * @date 2017/6/13
 * @time 15:38
 * @description
 */
public class UserDaoImpl implements IUserDao {


    public User find(String userName, String userPwd) {
        try {

            Document document = XmlUtils.getDocument();
            Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"' and @userPwd='"+userPwd+"']");
            if(e==null){
                return null;
            }
            User user = new User();
            user.setId(e.attributeValue("id"));
            user.setEmail(e.attributeValue("email"));
            user.setUserPwd(e.attributeValue("userPwd"));
            user.setUserName(e.attributeValue("userName"));
            String birth = e.attributeValue("birthday");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(sdf.parse(birth));

            return user;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("deprecation")
    public void add(User user) {

        try{
            Document document = XmlUtils.getDocument();
            Element root = document.getRootElement();
            Element user_node = root.addElement("user");  //创建user结点，并挂到root
            user_node.setAttributeValue("id", user.getId());
            user_node.setAttributeValue("userName", user.getUserName());
            user_node.setAttributeValue("userPwd", user.getUserPwd());
            user_node.setAttributeValue("email", user.getEmail());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            user_node.setAttributeValue("birthday", sdf.format(user.getBirthday()));

            XmlUtils.write2Xml(document);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public User find(String userName) {
        try{
            Document document = XmlUtils.getDocument();
            Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"']");
            if(e==null){
                return null;
            }
            User user = new User();
            user.setId(e.attributeValue("id"));
            user.setEmail(e.attributeValue("email"));
            user.setUserPwd(e.attributeValue("userPwd"));
            user.setUserName(e.attributeValue("userName"));
            String birth = e.attributeValue("birthday");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(sdf.parse(birth));

            return user;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
