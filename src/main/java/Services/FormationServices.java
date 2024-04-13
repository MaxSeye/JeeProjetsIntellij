package Services;

import daos.FormationDaos;
import entities.Formation;

import java.util.List;

public interface FormationServices {
    FormationDaos createFormation(FormationDaos formation);

    boolean getFormation(int idFormation);

    List<FormationDaos> getAllFormations();


    FormationDaos updateFormation(int idFormation, FormationDaos formation);

    Formation deleteFormation(int idFormation);

}

