package xulyform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xulyform.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {
	
}
