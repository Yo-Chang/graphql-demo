package com.example.demo.graphql;

import com.example.demo.graphql.jpa.FriendShip;
import com.example.demo.graphql.jpa.FriendShipRepository;
import com.example.demo.graphql.jpa.User;
import com.example.demo.graphql.jpa.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoGraphQLApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphQLApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository userRepository, FriendShipRepository friendShipRepository) {
        return args -> {
            List<User> users = new ArrayList<>();
            users.add(User.builder().name("Fong").email("fong@test.com").age(25).height(175F).weight(70F).birthDay("1997-07-12").build());
            users.add(User.builder().name("Kevin").email("kevin@test.com").age(40).height(185F).weight(90F).birthDay(null).build());
            users.add(User.builder().name("Mary").email("Mary@test.com").age(18).height(162F).weight(null).birthDay(null).build());

            userRepository.saveAll(users);
            userRepository.findAll().forEach(System.out::println);

            List<FriendShip> friendShips = new ArrayList<>();
            friendShips.add(FriendShip.builder().userId(1L).friendId(2L).build());
            friendShips.add(FriendShip.builder().userId(1L).friendId(3L).build());
            friendShips.add(FriendShip.builder().userId(2L).friendId(1L).build());
            friendShips.add(FriendShip.builder().userId(3L).friendId(1L).build());

            friendShipRepository.saveAll(friendShips);
            friendShipRepository.findAll().forEach(System.out::println);
        };

    }
}
