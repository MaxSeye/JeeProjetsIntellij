package Services;

import daos.UtilisateurDaos;

import java.util.List;

public interface UtilisateurServices {

    UtilisateurDaos createUtilisateur(UtilisateurDaos utilisateur);

    boolean getUtilisateur(int idUtiliateur);

    List<UtilisateurDaos> getAllUtilisateur();

    UtilisateurDaos updateUtilisateur(int idUtilisateur, UtilisateurDaos utilisateur);

    boolean deleteUtilisateur(int idUtilisateur);


}
