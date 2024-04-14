package Services;

import daos.CentreDaos;
import entities.Centre;

import java.util.List;

public interface CentreServices {
        CentreDaos createCentre(CentreDaos centre);
        CentreDaos getCentre(int idCentre);

        List<CentreDaos> getAllCentres();

        CentreDaos updateCentre(int idCentre, CentreDaos centre);

        boolean deleteCentre(int idCentre);

}
