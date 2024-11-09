package fr.bibli.biblio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bibli.biblio.model.User;
import fr.bibli.biblio.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<?> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PostMapping
  public ResponseEntity<?> addUser(@RequestBody User user) {
    LOG.info("Adding a user");
    return ResponseEntity.ok(userService.addUser(user));
  }

  @DeleteMapping
  public ResponseEntity<?> deleteAllUsers() {
    LOG.info("Deleting all users");
    userService.deleteAllUsers();
    return ResponseEntity.ok().build();
  }
}
