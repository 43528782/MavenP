package com.DJ.service;

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;  
  
import com.DJ.baseTest.SpringTestCase;  
import com.DJ.domain.User;  
  
public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private UserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
      
    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(16987);  
        logger.debug("²éÕÒ½á¹û:&********&" + user);  
    }  
      
  
}  