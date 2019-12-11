package com.example.demo.graphql.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendShipRepository extends JpaRepository<FriendShip, Long> {

    @Query(value = "select u from User u where id in (select friendId from FriendShip where userId = :userId)")
    List<User> findFriendsByUserId(Long userId);

}