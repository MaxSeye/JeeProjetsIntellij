package Services.servicesImpl;

import Repositories.UtilisateurRepositories;
import Services.UtilisateurServices;
import daos.InscriptionDaos;
import daos.UtilisateurDaos;
import entities.Inscription;
import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServicesImpl implements UtilisateurServices {

    @Autowired
    UtilisateurRepositories utilisateurRepositories;
    @Override
    public UtilisateurDaos createUtilisateur(UtilisateurDaos utilisateurDaos) {
        // Créer un nouvel objet Centre à partir de l'objet CentreDaos
        Utilisateur newUtilisateur= new Utilisateur();
        // Affecter les valeurs appropriées depuis centreDaos à newCentre
        newUtilisateur.setIdUtilisateur(utilisateurDaos.getIdUtilisateur()); // Par exemple, si le nom est une propriété de Centre
        newUtilisateur.setNomUtilisateur(utilisateurDaos.getNomUtilisateur()); // Assurez-vous d'adapter cela à votre modèle Centre
        newUtilisateur.setMotDePasse(utilisateurDaos.getMotDePasse());
        newUtilisateur.setRole(utilisateurDaos.getRole());


        // Enregistrer le nouveau centre dans la base de données en utilisant le repository
        Utilisateur savedUtilisateur = utilisateurRepositories.save(newUtilisateur);

        // Vous pouvez mapper savedCentre à un objet CentreDaos si nécessaire
        UtilisateurDaos savedUtilisateurDaos = new UtilisateurDaos();

        savedUtilisateurDaos.setIdUtilisateur(savedUtilisateur.getIdUtilisateur()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedUtilisateurDaos.setNomUtilisateur(savedUtilisateur.getNomUtilisateur()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedUtilisateurDaos.setMotDePasse(savedUtilisateur.getMotDePasse()); // Assurez-vous d'adapter cela à votre modèle CentreDaos
        savedUtilisateurDaos.setRole(savedUtilisateur.getRole()); // Assurez-vous d'adapter cela à votre modèle CentreDaos


        return savedUtilisateurDaos; // Retourner le centre nouvellement créé
    }

    @Override
    public boolean getUtilisateur(int idUtiliateur) {
        Optional<Utilisateur> searchedUtilisateur = utilisateurRepositories.findById(idUtiliateur);
        if(searchedUtilisateur.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public List<UtilisateurDaos> getAllUtilisateur() {
        List<Utilisateur> utilisateurList = utilisateurRepositories.findAll();
        return utilisateurList.stream()
                .map(utilisateur -> new UtilisateurDaos())
                .collect(Collectors.toList());

    }

    @Override
    public UtilisateurDaos updateUtilisateur(int idUtilisateur, UtilisateurDaos utilisateur) {

        if(utilisateurRepositories.existsById(idUtilisateur)) {

            return utilisateur;
        }
        return null;
    }

    @Override
    public boolean deleteUtilisateur(int idUtilisateur) {
        Optional<Utilisateur> searchedUtilisateur = utilisateurRepositories.findById(idUtilisateur);
        if(searchedUtilisateur.isPresent()) {
            utilisateurRepositories.delete(searchedUtilisateur.get());
            return true;
        }
        return false;
    }
}
