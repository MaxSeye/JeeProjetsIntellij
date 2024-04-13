package Services.servicesImpl;

import Repositories.SalleRepositories;
import Services.SalleServices;
import daos.CentreDaos;
import daos.SalleDaos;
import entities.Centre;
import entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalleServiceImpl implements SalleServices {

    @Autowired
    SalleRepositories salleRepositories;
    @Override
    public SalleDaos createSalle(SalleDaos salleDaos) {
        // Créer un nouvel objet Centre à partir de l'objet CentreDaos
        Salle newSalle = new Salle();
        // Affecter les valeurs appropriées depuis centreDaos à newCentre
        newSalle.setIdSalle(salleDaos.getIdSalle()); // Par exemple, si le nom est une propriété de Centre
        newSalle.setNumSalle(salleDaos.getNumSalle()); // Assurez-vous d'adapter cela à votre modèle Centre
        newSalle.setCapacite(salleDaos.getCapacite());// Assurez-vous d'adapter cela à votre modèle Centre

        // Enregistrer le nouveau centre dans la base de données en utilisant le repository
        Salle savedSalle = salleRepositories.save(newSalle);

        // Vous pouvez mapper savedCentre à un objet CentreDaos si nécessaire
        SalleDaos savedSalleDaos = new SalleDaos();
        savedSalleDaos.setIdSalle(savedSalle.getIdSalle()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedSalleDaos.setNumSalle(savedSalle.getNumSalle()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedSalleDaos.setCapacite(savedSalle.getCapacite()); // Assurez-vous d'adapter cela à votre modèle CentreDaos

        return savedSalleDaos; // Retourner le centre nouvellement créé
    }

    @Override
    public boolean getSalle(int idSalle) {
        Optional<Salle> searchedSalle = salleRepositories.findById(idSalle);
        if(searchedSalle.isPresent()) {
            return true;
        }
        return false;
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
    public boolean deleteSalle(int idSalle) {
        Optional<Salle> searchedSalle = salleRepositories.findById(idSalle);
        if(searchedSalle.isPresent()) {
            salleRepositories.delete(searchedSalle.get());
            return true;
        }
        return false;
    }
}
