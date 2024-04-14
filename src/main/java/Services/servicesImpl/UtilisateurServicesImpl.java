package Services.servicesImpl;

import Repositories.UtilisateurRepositories;
import Services.UtilisateurServices;
import daos.CentreDaos;
import daos.InscriptionDaos;
import daos.UtilisateurDaos;
import entities.Centre;
import entities.Formateur;
import entities.Inscription;
import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectMapperUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServicesImpl implements UtilisateurServices {

    @Autowired
    UtilisateurRepositories utilisateurRepositories;
    @Override

    public UtilisateurDaos createUtilisateur(UtilisateurDaos utilisateur) {
        Utilisateur addedUtilisateur = utilisateurRepositories.save(ObjectMapperUtils.map(utilisateur, Utilisateur.class));
        return ObjectMapperUtils.map(addedUtilisateur, UtilisateurDaos.class);
    }

    @Override
    public UtilisateurDaos getUtilisateur(int idUtilisateur) {
        Optional<Utilisateur> searchedUtilisateur = utilisateurRepositories.findById(idUtilisateur    );

        if(searchedUtilisateur.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedUtilisateur.get(), UtilisateurDaos.class);
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
    public boolean deleteUtilisateur(int IdUtilisateur) {
        Optional<Utilisateur> searchedUtilisateur = utilisateurRepositories.findById(IdUtilisateur);

        if(searchedUtilisateur.isEmpty()) return false;
        utilisateurRepositories.delete(searchedUtilisateur.get());
        return true;
    }
}
