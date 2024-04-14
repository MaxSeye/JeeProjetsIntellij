package Services.servicesImpl;

import Repositories.CentreRepositories;
import Services.CentreServices;
import daos.CentreDaos;
import entities.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectMapperUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentreServiceImpl implements CentreServices {

    @Autowired
    CentreRepositories centreRepositories;

    @Override

    public CentreDaos createCentre(CentreDaos centre) {
        Centre addedCentre = centreRepositories.save(ObjectMapperUtils.map(centre, Centre.class));
        return ObjectMapperUtils.map(addedCentre, CentreDaos.class);
    }

    @Override
    public CentreDaos getCentre(int idClient) {
        Optional<Centre> searchedCentre = centreRepositories.findById(idClient);

        if(searchedCentre.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedCentre.get(), CentreDaos.class);
    }


    @Override
    public boolean deleteCentre(int IdCentre) {
        Optional<Centre> searchedCentre = centreRepositories.findById(IdCentre);

        if(searchedCentre.isEmpty()) return false;
        centreRepositories.delete(searchedCentre.get());
        return true;
    }


    @Override
    public List<CentreDaos> getAllCentres() {
        List<Centre> centreList = centreRepositories.findAll();
        return centreList.stream()
                .map(centre -> new CentreDaos())
                .collect(Collectors.toList());
    }

    @Override
    public CentreDaos updateCentre(int idCentre, CentreDaos centre) {
        if(centreRepositories.existsById(idCentre)) {

            return centre;
        }
        return null;
    }
}
