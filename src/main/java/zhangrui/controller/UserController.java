package zhangrui.controller;

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
            userDao.save(user);
        }catch (Exception e){
            return "插入"+user.getName()+"失败" + e.toString();
        }
        return "插入"+user.getName()+"成功";
    }

    @Autowired
    private UserDao userDao;
}
