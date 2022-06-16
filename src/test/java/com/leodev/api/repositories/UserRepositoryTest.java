package com.leodev.api.repositories;

import com.leodev.api.entities.User;
import com.leodev.api.util.UserCreator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_PersistUser_WhenSuccessFull(){
        User user = UserCreator.createUser();
        String expectedName = "Leo";
        final User resultUser = userRepository.save(user);

        assertAll(
                () -> assertThat(resultUser).isNotNull(),
                () -> assertThat(resultUser.getName()).isNotNull(),
                () -> assertThat(resultUser.getName()).isNotEmpty(),
                () -> assertThat(resultUser.getName()).isEqualTo(expectedName),
                () -> assertThat(resultUser.getEmail()).isNotNull(),
                () -> assertThat(resultUser.getPhone()).isNotNull(),
                () -> assertThat(resultUser.getPassword()).isNotNull(),
                () -> assertThat(resultUser).isNotNull(),
                () -> assertThat(resultUser).isNotNull()
        );
    }
}