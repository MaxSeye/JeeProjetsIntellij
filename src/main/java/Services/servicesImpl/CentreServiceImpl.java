package Services.servicesImpl;

import Repositories.CentreRepositories;
import Services.CentreServices;
import daos.CentreDaos;
import entities.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentreServiceImpl implements CentreServices {

    @Autowired
    CentreRepositories centreRepositories;

    @Override
    public CentreDaos createCentre(CentreDaos centre) {
        return null;
    }
    @Override
    public CentreDaos getCentre(int idCentre) {
        Optional<Centre> searchedCentre = centreRepositories.findById(idCentre);
        if(searchedCentre.isPresent()) {
            return new CentreDaos();
        }
        return null;
    }


    @Override
    public boolean deleteCentre(int idCentre) {
        Optional<Centre> searchedCentre = centreRepositories.findById(idCentre);
        if(searchedCentre.isPresent()) {
            centreRepositories.delete(searchedCentre.get());
            return true;
        }
        return false;
    }

    @Override
    public List<CentreDaos> getAllCentres() {
        List<Centre> centreList = centreRepositories.findAll();
        return centreList.stream()
                .map(centre -> new CentreDaos())
                .collect(Collectors.toList());
    }

    @Override
    public CentreDaos updateCentre(int centreId, CentreDaos centre) {
        if(centreRepositories.existsById(centreId)) {
            // Implémentation nécessaire pour mettre à jour un centre
            return centre;
        }
        return null;
    }
}
