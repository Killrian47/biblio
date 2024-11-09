package fr.bibli.biblio.repository;

import org.springframework.data.repository.CrudRepository;

import fr.bibli.biblio.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
