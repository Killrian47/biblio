package fr.bibli.biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bibli.biblio.model.Manwha;
import fr.bibli.biblio.model.User;
import fr.bibli.biblio.repository.ManwhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ManwhaService {

  @Autowired
  private ManwhaRepository manwhaRepository;

  @PersistenceContext
  private EntityManager entityManager;

  public List<Manwha> getAllManwhas() {
    return (List<Manwha>) manwhaRepository.findAll();
  }

  public Manwha getManwhaById(Long id) {
    return manwhaRepository.findById(id).get();
  }

  public Manwha addManwha(Manwha manwha) {
    return manwhaRepository.save(manwha);
  }

  public Manwha updateManwha(Long id, Manwha updatedManwha) {
    Optional<Manwha> manwha = manwhaRepository.findById(id);
    if (manwha.isPresent()) {
      Manwha manwhaToUpdate = manwha.get();
      manwhaToUpdate.setTitle(updatedManwha.getTitle());
      manwhaToUpdate.setAuthor(updatedManwha.getAuthor());
      manwhaToUpdate.setArtist(updatedManwha.getArtist());
      manwhaToUpdate.setGenre(updatedManwha.getGenre());
      manwhaToUpdate.setSummary(updatedManwha.getSummary());
      manwhaToUpdate.setChapters(updatedManwha.getChapters());
      manwhaToUpdate.setChaptersRead(updatedManwha.getChaptersRead());
      return manwhaRepository.save(manwhaToUpdate);
    } else {
      throw new RuntimeException("Manwha not found");
    }
  }

  public void deleteManwha(Long id) {
    manwhaRepository.deleteById(id);
  }

  public void deleteAllManwhas() {
    manwhaRepository.deleteAll();
  }

  public List<Manwha> getManwhasByTitle(String title) {
    return entityManager.createQuery("SELECT m FROM Manwha m WHERE m.title LIKE :title", Manwha.class)
        .setParameter("title", "%" + title + "%").getResultList();
  }

  public List<Manwha> getManwhasByAuthor(String author) {
    return entityManager.createQuery("SELECT m FROM Manwha m WHERE m.author LIKE :author", Manwha.class)
        .setParameter("author", "%" + author + "%").getResultList();
  }
}
