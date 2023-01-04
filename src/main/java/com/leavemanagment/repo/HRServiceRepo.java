package com.leavemanagment.repo;

import org.springframework.stereotype.Repository;

@Repository
public class HRServiceRepo extends JpaRepository<LeaveDetailsEntity, Long> {

}