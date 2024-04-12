package Services;

import daos.SalleDaos;

import java.util.List;

public interface SalleServices {
    SalleDaos createSalle(SalleDaos salle);

    boolean getSalle(int idSalle);

    List<SalleDaos> getAllSalles();

    SalleDaos updateSalle(int idSalle, SalleDaos salle);

    SalleDaos deleteSalle(int idSalle);

}
