package com.example.demo.graphql.api;

import com.example.demo.graphql.jpa.FriendShipRepository;
import com.example.demo.graphql.jpa.User;
import com.example.demo.graphql.jpa.UserRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class UserGraphQLApi {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendShipRepository friendShipRepository;

    @GraphQLQuery(name = "hello")
    public String getHello() {
        return "Hello world!";
    }

    @GraphQLQuery(name = "me")
    public Optional<User> getMe() {
        return userRepository.findById(1L);
    }

    @GraphQLQuery(name = "users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GraphQLQuery(name = "user")
    public Optional<User> findById(@NotNull @GraphQLArgument(name = "id") Long id) {
        return userRepository.findById(id);
    }

    @GraphQLMutation(name = "saveUser")
    public User saveUser(@GraphQLArgument(name = "user") User user) {
        return userRepository.save(user);
    }

    @GraphQLMutation(name = "deleteUser")
    public boolean deleteUser(@GraphQLArgument(name = "id") Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @GraphQLQuery(name = "friends")
    public List<User> getFriends(@GraphQLContext User user) {
        return friendShipRepository.findFriendsByUserId(user.getId());
    }

}
