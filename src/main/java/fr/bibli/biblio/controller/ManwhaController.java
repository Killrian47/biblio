package fr.bibli.biblio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bibli.biblio.model.Manwha;
import fr.bibli.biblio.service.ManwhaService;

@RestController
@RequestMapping("/manwhas")
public class ManwhaController {

  private static final Logger LOG = LoggerFactory.getLogger(ManwhaController.class);

  @Autowired
  private ManwhaService manwhaService;

  // GET /manwhas -> get all manwhas
  @GetMapping
  public ResponseEntity<?> getAllManwhas() {
    LOG.info("Getting all manwhas");
    return ResponseEntity.ok(manwhaService.getAllManwhas());
  }

  // POST /manwhas -> add a manwha
  @PostMapping
  public ResponseEntity<?> addManwha(@RequestBody Manwha manwha) {
    LOG.info("Adding a manwha");
    return ResponseEntity.ok(manwhaService.addManwha(manwha));
  }

  // DELETE /manwhas -> delete all manwhas
  @DeleteMapping
  public ResponseEntity<?> deleteAllManwhas() {
    LOG.info("Deleting all manwhas");
    manwhaService.deleteAllManwhas();
    return ResponseEntity.ok().build();
  }

  // GET /manwhas/{id} -> get a manwha by his id
  @GetMapping("/{id}")
  public ResponseEntity<?> getManwhaById(@PathVariable("id") Long id) {
    LOG.info("Getting a manwha by his id");
    return ResponseEntity.ok(manwhaService.getManwhaById(id));
  }

  // PUT /manwhas/{id} -> update a manwha by his id
  @PutMapping("/{id}")
  public ResponseEntity<?> updateManwha(@RequestBody Manwha manwha) {
    LOG.info("Updating a manwha by his id");
    return ResponseEntity.ok(manwhaService.updateManwha(manwha.getId(), manwha));
  }

  // DELETE /manwhas/{id} -> delete a manwha by his id
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteManwha(@PathVariable("id") Long id) {
    LOG.info("Deleting a manwha by his id");
    manwhaService.deleteManwha(id);
    return ResponseEntity.ok().build();
  }

  // GET /manwhas/search/{title} -> get manwhas by title
  @GetMapping("/search/{title}")
  public ResponseEntity<?> getManwhasByTitle(@PathVariable("title") String title) {
    LOG.info("Getting manwhas with title containing " + title);
    return ResponseEntity.ok(manwhaService.getManwhasByTitle(title));
  }

  // GET /manwhas/search/author/{author} -> get manwhas by author
  @GetMapping("/search/author/{author}")
  public ResponseEntity<?> getManwhasByAuthor(@PathVariable("author") String author) {
    LOG.info("Getting manwhas with author containing " + author);
    return ResponseEntity.ok(manwhaService.getManwhasByAuthor(author));
  }
}
