package Services;

import daos.FormateurDaos;
import entities.Formateur;

import java.util.List;

public interface FormateurServices {
    FormateurDaos createFormateur(FormateurDaos formateur);


    List<FormateurDaos> getAllFormateurs();

    boolean getFormateur(int idFormateur);


    FormateurDaos updateFormateur(int idFormateur, FormateurDaos formateur);



    Formateur deleteFormateur(int idFormateur);

}
