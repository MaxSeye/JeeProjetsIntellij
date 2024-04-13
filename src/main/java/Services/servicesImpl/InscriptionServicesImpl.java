package Services.servicesImpl;

import Repositories.InscriptionRepositories;
import Services.InscriptionServices;
import daos.FormationDaos;
import daos.InscriptionDaos;
import entities.Formation;
import entities.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class InscriptionServicesImpl implements InscriptionServices {


    @Autowired
    InscriptionRepositories inscriptionRepositories;

    @Override
    public InscriptionDaos createInscription(InscriptionDaos inscriptionDaos) {
        // Créer un nouvel objet Centre à partir de l'objet CentreDaos
        Inscription newInscription= new Inscription();
        // Affecter les valeurs appropriées depuis centreDaos à newCentre
        newInscription.setIdInscription(inscriptionDaos.getIdInscription()); // Par exemple, si le nom est une propriété de Centre
        newInscription.setFrais(inscriptionDaos.getFrais()); // Assurez-vous d'adapter cela à votre modèle Centre
        newInscription.setDateInscription(inscriptionDaos.getDateInscription());



        // Enregistrer le nouveau centre dans la base de données en utilisant le repository
        Inscription savedInscription = inscriptionRepositories.save(newInscription);

        // Vous pouvez mapper savedCentre à un objet CentreDaos si nécessaire
        InscriptionDaos savedInscriptionDaos = new InscriptionDaos();

        savedInscriptionDaos.setIdInscription(savedInscription.getIdInscription()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedInscriptionDaos.setFrais(savedInscription.getFrais()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedInscriptionDaos.setDateInscription(savedInscription.getDateInscription()); // Assurez-vous d'adapter cela à votre modèle CentreDaos


        return savedInscriptionDaos; // Retourner le centre nouvellement créé
    }

    @Override
    public boolean getInscription(int idInscription) {
        Optional<Inscription> searchedInscription = inscriptionRepositories.findById(idInscription);
        if(searchedInscription.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public List<InscriptionDaos> getAllInscriptions() {
        List<Inscription> inscriptionList = inscriptionRepositories.findAll();
        return inscriptionList.stream()
                .map(inscription -> new InscriptionDaos())
                .collect(Collectors.toList());
    }

    @Override
    public InscriptionDaos updateInscriptions(int idInscription, InscriptionDaos inscription) {
        if(inscriptionRepositories.existsById(idInscription)) {

            return inscription;
        }
        return null;
    }

    @Override
    public boolean deleteInscription(int idInscription) {
        Optional<Inscription> searchedInscription = inscriptionRepositories.findById(idInscription);
        if(searchedInscription.isPresent()) {
            inscriptionRepositories.delete(searchedInscription.get());
            return true;
        }
        return false;
    }
}
