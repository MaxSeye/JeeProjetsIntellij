package Services.servicesImpl;

import Repositories.SalleRepositories;
import Services.SalleServices;
import daos.CentreDaos;
import daos.SalleDaos;
import entities.Centre;
import entities.Formateur;
import entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectMapperUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalleServiceImpl implements SalleServices {

    @Autowired
    SalleRepositories salleRepositories;
    @Override

    public SalleDaos createSalle(SalleDaos salle) {
        Salle addedSalle = salleRepositories.save(ObjectMapperUtils.map(salle, Salle.class));
        return ObjectMapperUtils.map(addedSalle, SalleDaos.class);
    }


    @Override
    public SalleDaos getSalle(int idSalle) {
        Optional<Salle> searchedSalle = salleRepositories.findById(idSalle);

        if(searchedSalle.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedSalle.get(), SalleDaos.class);
    }

    @Override
    public List<SalleDaos> getAllSalles() {
        List<Salle> salleList = salleRepositories.findAll();
        return salleList.stream()
                .map(salle -> new SalleDaos())
                .collect(Collectors.toList());
    }

    @Override
    public SalleDaos updateSalle(int idSalle, SalleDaos salle) {
        if(salleRepositories.existsById(idSalle)) {

            return salle;
        }
        return null;
    }

    @Override
    public boolean deleteSalle(int IdSalle) {
        Optional<Salle> searchedSalle = salleRepositories.findById(IdSalle);

        if(searchedSalle.isEmpty()) return false;
        salleRepositories.delete(searchedSalle.get());
        return true;
    }
}
