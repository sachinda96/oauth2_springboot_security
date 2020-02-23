package authserver.example.repository;

import authserver.example.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Integer> {

    Optional<UserModel> findByUsername(String s);
}
