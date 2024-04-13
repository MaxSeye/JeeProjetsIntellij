package Services.servicesImpl;


import Repositories.FormationRepositories;
import Services.FormationServices;


import daos.FormateurDaos;
import daos.FormationDaos;
import entities.Formateur;
import entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FormationServiceImpl implements FormationServices {

    @Autowired
    FormationRepositories formationRepositories;

    @Override
    public FormationDaos createFormation(FormationDaos formationDaos) {
        // Créer un nouvel objet Centre à partir de l'objet CentreDaos
        Formation newFormation= new Formation();
        // Affecter les valeurs appropriées depuis centreDaos à newCentre
        newFormation.setIdFormation(formationDaos.getIdFormation()); // Par exemple, si le nom est une propriété de Centre
        newFormation.setTitre(formationDaos.getTitre()); // Assurez-vous d'adapter cela à votre modèle Centre
        newFormation.setDescription(formationDaos.getDescription());
        newFormation.setDateDebut(formationDaos.getDateDebut());
        newFormation.setDateFin(formationDaos.getDateFin());


        // Enregistrer le nouveau centre dans la base de données en utilisant le repository
        Formation savedFormation = formationRepositories.save(newFormation);

        // Vous pouvez mapper savedCentre à un objet CentreDaos si nécessaire
        FormationDaos savedFormationDaos = new FormationDaos();

        savedFormationDaos.setIdFormation(savedFormation.getIdFormation()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedFormationDaos.setTitre(savedFormation.getTitre()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedFormationDaos.setDescription(savedFormation.getDescription()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedFormationDaos.setDateDebut(savedFormation.getDateDebut());
        savedFormationDaos.setDateFin(savedFormation.getDateFin());

        return savedFormationDaos; // Retourner le centre nouvellement créé
    }

    @Override
    public boolean getFormation(int idFormation) {
        Optional<Formation> searchedFormation = formationRepositories.findById(idFormation);
        if(searchedFormation.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public List<FormationDaos> getAllFormations() {
        List<Formation> formationList = formationRepositories.findAll();
        return formationList.stream()
                .map(formation -> new FormationDaos())
                .collect(Collectors.toList());
    }


    @Override
    public FormationDaos updateFormation(int idFormation, FormationDaos formation) {
        if(formationRepositories.existsById(idFormation)) {

            return formation;
        }
        return null;
    }

    @Override
    public Formation deleteFormation(int idFormation) {
        Optional<Formation> searchedFormation = formationRepositories.findById(idFormation);
        if(searchedFormation.isPresent()) {
            formationRepositories.delete(searchedFormation.get());
            return searchedFormation.get(); // Retourner le centre supprimé
        }
        return null; // Retourner null si le centre n'a pas été trouvé
    }
}








