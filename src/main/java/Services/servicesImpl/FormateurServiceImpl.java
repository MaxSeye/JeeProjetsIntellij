package Services.servicesImpl;

import Repositories.FormateurRepositories;
import Services.FormateurServices;

import daos.CentreDaos;
import daos.FormateurDaos;
import entities.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormateurServiceImpl implements FormateurServices {

    @Autowired
    private FormateurRepositories formateurRepositories;
    @Override
    public FormateurDaos createFormateur(FormateurDaos formateurDaos) {
        // Créer un nouvel objet Centre à partir de l'objet CentreDaos
        Formateur newFormateur = new Formateur();
        // Affecter les valeurs appropriées depuis centreDaos à newCentre
        newFormateur.setIdFormateur(formateurDaos.getIdFormateur()); // Par exemple, si le nom est une propriété de Centre
        newFormateur.setNumFormateur(formateurDaos.getNumFormateur()); // Assurez-vous d'adapter cela à votre modèle Centre
        newFormateur.setPrenomFormateur(formateurDaos.getPrenomFormateur());
        newFormateur.setSpecialite(formateurDaos.getSpecialite());

        // Enregistrer le nouveau centre dans la base de données en utilisant le repository
        Formateur savedFormateur = formateurRepositories.save(newFormateur);

        // Vous pouvez mapper savedCentre à un objet CentreDaos si nécessaire
        FormateurDaos savedFormateurDaos = new FormateurDaos();
        savedFormateurDaos.setIdFormateur(savedFormateur.getIdFormateur()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedFormateurDaos.setNumFormateur(savedFormateur.getNumFormateur()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedFormateurDaos.setPrenomFormateur(savedFormateur.getPrenomFormateur()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedFormateurDaos.setSpecialite(savedFormateur.getSpecialite());
        return savedFormateurDaos; // Retourner le centre nouvellement créé
    }


    @Override
    public List<FormateurDaos> getAllFormateurs() {
        List<Formateur> formateurList = formateurRepositories.findAll();
        return formateurList.stream()
                .map(centre -> new FormateurDaos())
                .collect(Collectors.toList());
    }

    @Override
    public boolean getFormateur(int idFormateur) {
        Optional<Formateur> searchedFormateur = formateurRepositories.findById(idFormateur);
        if(searchedFormateur.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public FormateurDaos updateFormateur(int idFormateur, FormateurDaos formateur) {
        if(formateurRepositories.existsById(idFormateur)) {

            return formateur;
        }
        return null;
    }

    @Override
    public Formateur deleteFormateur(int idFormateur) {
        Optional<Formateur> searchedFormateur = formateurRepositories.findById(idFormateur);
        if(searchedFormateur.isPresent()) {
            formateurRepositories.delete(searchedFormateur.get());
            return searchedFormateur.get(); // Retourner le centre supprimé
        }
        return null;
    }
}




