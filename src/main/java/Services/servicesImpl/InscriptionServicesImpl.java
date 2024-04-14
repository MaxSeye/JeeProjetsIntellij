package Services.servicesImpl;

import Repositories.InscriptionRepositories;
import Services.InscriptionServices;
import daos.FormationDaos;
import daos.InscriptionDaos;
import entities.Formateur;
import entities.Formation;
import entities.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectMapperUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class InscriptionServicesImpl implements InscriptionServices {


    @Autowired
    InscriptionRepositories inscriptionRepositories;

    @Override
    public InscriptionDaos createInscription(InscriptionDaos inscription) {
        Inscription addedInscription = inscriptionRepositories.save(ObjectMapperUtils.map(inscription, Inscription.class));
        return ObjectMapperUtils.map(addedInscription, InscriptionDaos.class);
    }

    @Override
    public InscriptionDaos getInscription(int idInscription) {
        Optional<Inscription> searchedInscription= inscriptionRepositories.findById(idInscription);

        if(searchedInscription.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedInscription.get(), InscriptionDaos.class);
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
    public boolean deleteInscription(int IdInscription) {
        Optional<Inscription> searchedInscription = inscriptionRepositories.findById(IdInscription);

        if(searchedInscription.isEmpty()) return false;
        inscriptionRepositories.delete(searchedInscription.get());
        return true;
    }
}
