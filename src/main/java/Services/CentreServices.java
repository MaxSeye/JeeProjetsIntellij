package Services;

import daos.CentreDaos;
import entities.Centre;

import java.util.List;

public interface CentreServices {
        CentreDaos createCentre(CentreDaos centre);
        boolean getCentre(int idCentre);

        List<CentreDaos> getAllCentres();

        CentreDaos updateCentre(int idCentre, CentreDaos centre);

        Centre deleteCentre(int idCentre);

}
