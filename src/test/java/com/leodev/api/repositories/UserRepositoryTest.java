package com.leodev.api.repositories;

import com.leodev.api.entities.User;
import com.leodev.api.util.UserCreator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest @Log4j2
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Save persist User when success")
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
    @Test
    @DisplayName("Save update User when success")
    void save_UpdateUser_WhenSuccessFull(){
        User user = UserCreator.createUser();
        final User resultUser = userRepository.save(user);
        resultUser.setName("Leo update");
        String expectedNameUpdate = "Leo update";
        final User resultUserUpdate = userRepository.save(user);

        assertAll(
                () -> assertThat(resultUserUpdate).isNotNull(),
                () -> assertThat(resultUserUpdate.getName()).isNotNull(),
                () -> assertThat(resultUserUpdate.getName()).isNotEmpty(),
                () -> assertThat(resultUserUpdate.getName()).isEqualTo(expectedNameUpdate),
                () -> assertThat(resultUserUpdate.getEmail()).isNotNull(),
                () -> assertThat(resultUserUpdate.getPhone()).isNotNull(),
                () -> assertThat(resultUserUpdate.getPassword()).isNotNull(),
                () -> assertThat(resultUserUpdate).isNotNull(),
                () -> assertThat(resultUserUpdate).isNotNull()
        );
    }

    @Test
    @DisplayName("FindById search User when success")
    void findById_SearchUser_WhenSuccessFull(){
        User user = UserCreator.createUserValid();
        Optional<User> optionalUser = userRepository.findById(user.getId());
        assertThat(optionalUser.isEmpty()).isTrue();
    }
}