package zhangrui.controller;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhangrui.dao.UserDao;
import zhangrui.model.User;

/**
 * Created by zhangrui on 2016/8/16.
 */
@Controller
public class UserController {
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(@RequestBody User user){
        try {
            if(userDao.exists(user.getName())){
                return "insert"+user.getName()+"failed user exist";
            }
            userDao.save(user);
        }catch (Exception e){
            return "insert"+user.getName()+"failed" + e.toString();
        }
        return "insert"+user.getName()+"success";
    }

    @RequestMapping("/deleteOne")
    @ResponseBody
    public String deleteOne(@RequestBody User user){
        try {
            userDao.delete(user);
        }catch (Exception e){
            return "delete"+user.getName()+"failed" + e.toString();
        }
        return "delete"+user.getName()+"success";
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public String deleteAll(){
        try {
            userDao.deleteAll();
        }catch (Exception e){
            return "deleteAll failed" + e.toString();
        }
        return "deleteAll success";
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(String name){
        try {
          return JSON.toJSONString(userDao.findOne(name));
        }catch (Exception e){
            return "find failed"+ e.toString();
        }
       // return "";
    }

    @Autowired
    private UserDao userDao;
}
