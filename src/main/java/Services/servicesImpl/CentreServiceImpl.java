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
    public CentreDaos createCentre(CentreDaos centreDaos) {
        // Créer un nouvel objet Centre à partir de l'objet CentreDaos
        Centre newCentre = new Centre();
        // Affecter les valeurs appropriées depuis centreDaos à newCentre
        newCentre.setNumCentre(centreDaos.getNumCentre()); // Par exemple, si le nom est une propriété de Centre
        newCentre.setAdresse(centreDaos.getAdresse()); // Assurez-vous d'adapter cela à votre modèle Centre
        newCentre.setIdCentre(centreDaos.getIdCentre()); // Assurez-vous d'adapter cela à votre modèle Centre
        // Enregistrer le nouveau centre dans la base de données en utilisant le repository
        Centre savedCentre = centreRepositories.save(newCentre);

        // Vous pouvez mapper savedCentre à un objet CentreDaos si nécessaire
        CentreDaos savedCentreDaos = new CentreDaos();
        savedCentreDaos.setIdCentre(savedCentre.getIdCentre()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedCentreDaos.setNumCentre(savedCentre.getNumCentre()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedCentreDaos.setAdresse(savedCentre.getAdresse()); // Assurez-vous d'adapter cela à votre modèle CentreDaos

        return savedCentreDaos; // Retourner le centre nouvellement créé
    }

    @Override
    public boolean getCentre(int idCentre) {
        Optional<Centre> searchedCentre = centreRepositories.findById(idCentre);
        if(searchedCentre.isPresent()) {
            return true;
        }
        return false;
    }


    @Override
    public Centre deleteCentre(int idCentre) {
        Optional<Centre> searchedCentre = centreRepositories.findById(idCentre);
        if(searchedCentre.isPresent()) {
            centreRepositories.delete(searchedCentre.get());
            return searchedCentre.get(); // Retourner le centre supprimé
        }
        return null; // Retourner null si le centre n'a pas été trouvé
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
