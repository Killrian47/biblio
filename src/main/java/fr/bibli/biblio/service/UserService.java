package fr.bibli.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bibli.biblio.model.User;
import fr.bibli.biblio.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User addUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  public void deleteAllUsers() {
    userRepository.deleteAll();
  }
}
