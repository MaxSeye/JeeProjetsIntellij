package Services;

import daos.FormationDaos;
import entities.Formation;

import java.util.List;

public interface FormationServices {
    FormationDaos createFormation(FormationDaos formation);

    FormationDaos getFormation(int idFormation);

    List<FormationDaos> getAllFormations();


    FormationDaos updateFormation(int idFormation, FormationDaos formation);

    boolean deleteFormation(int idFormation);

}

