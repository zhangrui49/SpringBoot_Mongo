package zhangrui.dao;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import zhangrui.model.User;

/**
 * Created by zhangrui on 2016/8/16.
 */
@Transactional
public interface UserDao extends MongoRepository<User,String> {
    User findByName(String name);
}
