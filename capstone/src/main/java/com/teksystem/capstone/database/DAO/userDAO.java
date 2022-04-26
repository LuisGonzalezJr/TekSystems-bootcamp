package com.teksystem.capstone.database.DAO;

import com.teksystem.capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);

    @Query(value = "select * from users where email = :email", nativeQuery = true)
    public User findByEmail(@Param("email") String email);

    public List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName") String firstName);


}
