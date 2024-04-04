package Repositories;

import entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepositories extends JpaRepository<Utilisateur,Integer> {
}
