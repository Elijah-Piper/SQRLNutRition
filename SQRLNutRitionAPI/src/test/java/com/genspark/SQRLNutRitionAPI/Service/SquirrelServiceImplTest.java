package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Entity.Meal;
import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.SqrlNutRitionApiApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class, Repository.class}))
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
class SquirrelServiceImplTest {

    @Autowired
    private SquirrelService squirrelService;
    @Autowired
    private UserService userService;

    @Test
    void shouldGetSquirrelsByUsername() {

        Squirrel sqrl1 = new Squirrel();
        sqrl1.setName("Nutter");
        Squirrel sqrl2 = new Squirrel();
        sqrl2.setName("McNutty");

        User user = new User();
        user.setUsername("user123");
        user.addSquirrel(sqrl1);
        user.addSquirrel(sqrl2);
        userService.createUser(user);

        List<Squirrel> found = squirrelService.getSquirrelsByUsername("testUsername");

        assert(found.contains(sqrl1) && found.contains(sqrl2));
    }
}