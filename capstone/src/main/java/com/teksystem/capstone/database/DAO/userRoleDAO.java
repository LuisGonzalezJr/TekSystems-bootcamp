package com.teksystem.capstone.database.DAO;

import com.teksystem.capstone.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(@Param("userId") Integer userId);
}
