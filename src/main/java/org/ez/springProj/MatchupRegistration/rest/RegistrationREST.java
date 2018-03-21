package org.ez.springProj.MatchupRegistration.rest;
import org.ez.springProj.MatchupRegistration.model.UserModel;
import org.ez.springProj.MatchupRegistration.query.PostgreSQLJDBCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationREST {
    private final static Logger logger = LoggerFactory.getLogger(RegistrationREST.class);
    @Autowired
    PostgreSQLJDBCService postgreJDBC;


    /**
     * add new user to database
     * @param userId
     * @param password
     * @param userName
     * @param calendarId
     * @return registration result
     */
    @ApiOperation(value = "add-user", notes = "add user for the given user's infos")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "userName", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "calendarId", dataType = "String", required = true)
    })
    @RequestMapping(value = "/add-user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<String>> addUser(@RequestParam(name = "userId") String userId,
                                                @RequestParam(name = "password") String password,
                                                @RequestParam(name = "userName") String userName,
                                                @RequestParam(name = "calendarId") String calendarId) {
        List<String> returnList = new ArrayList<String>();
        UserModel user = new UserModel(userId, password, userName, calendarId);
        returnList.add(postgreJDBC.addUser(user));
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }
}
