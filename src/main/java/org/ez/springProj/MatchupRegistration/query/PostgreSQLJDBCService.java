package org.ez.springProj.MatchupRegistration.query;

import org.ez.springProj.MatchupRegistration.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class PostgreSQLJDBCService {
    @Autowired
    UserModelRepository repository;

    public String addUser(UserModel user) {
        if(user == null)
            return "Add user failed!";
        repository.save(user);
        return "Add user success: " + user.toString();
    }
}
