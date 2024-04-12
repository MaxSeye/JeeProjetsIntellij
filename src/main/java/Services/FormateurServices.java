package Services;

import daos.FormateurDaos;

import java.util.List;

public interface FormateurServices {
    FormateurDaos createFormateur(FormateurDaos formateur);
    boolean getFrmateur(int idFormateur);

    List<FormateurDaos> getAllFormateurs();

    FormateurDaos updateFormateur(int idFormateur, FormateurDaos formateur);

    FormateurDaos deleteFormateur(int idFormateur);

}
