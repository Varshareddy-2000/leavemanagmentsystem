package com.leavemanagment.repo;
package com.leavemanagementsystem.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

import com.leavemanagementsystem.entity.AppUserEntity;

 
@Repository
public class AppUserRepo extends JpaRepository<AppUserEntity,String> {

}
