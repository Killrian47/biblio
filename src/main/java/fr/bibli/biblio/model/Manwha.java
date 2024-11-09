package fr.bibli.biblio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Manwha {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String author;
  private String artist;
  private String genre;
  @Column(length = 10000)
  private String summary;
  private int chapters;
  private int chaptersRead;

  @ManyToOne
  @JsonBackReference // Prevent infinite recursion
  private User user;
}
