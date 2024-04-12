package Services;

import daos.UtilisateurDaos;

import java.util.List;

public interface UtilisateurServices {

    UtilisateurDaos createUtilisateur(UtilisateurDaos utilisateur);

    boolean getUtilisateur(int idUtiliateur);

    List<UtilisateurDaos> getAllUtilisateur();

    UtilisateurDaos updateUtilisateur(int idUtilisateur, UtilisateurDaos utilisateur);

    UtilisateurDaos deleteUtilisateur(int idUtilisateur);


}
