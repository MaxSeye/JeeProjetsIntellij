package Repositories;

import entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepositories extends JpaRepository<Inscription,Integer> {
}
