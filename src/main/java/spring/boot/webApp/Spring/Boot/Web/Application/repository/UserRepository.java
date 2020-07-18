package spring.boot.webApp.Spring.Boot.Web.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.boot.webApp.Spring.Boot.Web.Application.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
