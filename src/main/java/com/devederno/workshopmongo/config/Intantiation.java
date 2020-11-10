package com.devederno.workshopmongo.config;

import com.devederno.workshopmongo.domain.Post;
import com.devederno.workshopmongo.domain.User;
import com.devederno.workshopmongo.dto.AuthorDTO;
import com.devederno.workshopmongo.dto.CommentDTO;
import com.devederno.workshopmongo.repository.PostRepository;
import com.devederno.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Intantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    userRepository.deleteAll();
    postRepository.deleteAll();

    User eder = new User(null, "Eder N. Oliveira", "eder@gmail.com");
    User minoru = new User(null, "Minoru Gondon", "minoru@gmail.com");
    User khalleb = new User(null, "Khalleb Ribeiro", "maria@gmail.com");

    userRepository.saveAll(Arrays.asList(eder, minoru, khalleb));

    Post post1 = new Post(
      null,
      sdf.parse("21/03/2018"),
      "Partiu viagem",
      "Vou viajar para São Paulo. Abraços!",
      new AuthorDTO(eder)
    );
    Post post2 = new Post(
      null,
      sdf.parse("23/03/2018"),
      "Bom dia",
      "Acordei feliz hoje",
      new AuthorDTO(minoru)
    );

    CommentDTO c1 = new CommentDTO(
      "Boa viajem Mano",
      sdf.parse("21/03/2018"),
      new AuthorDTO(minoru)
    );
    CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(khalleb));
    CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("23/03/2018"), new AuthorDTO(minoru));

    post1.getCommets().addAll(Arrays.asList(c1, c2));
    post2.getCommets().add(c3);

    postRepository.saveAll(Arrays.asList(post1, post2));

    eder.getPost().addAll(Arrays.asList(post1, post2));
    userRepository.save(eder);
  }
}
