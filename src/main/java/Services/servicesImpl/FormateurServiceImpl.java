package Services.servicesImpl;

import Repositories.FormateurRepositories;
import Services.FormateurServices;

import daos.FormateurDaos;
import entities.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectMapperUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormateurServiceImpl implements FormateurServices {

    @Autowired
    private FormateurRepositories formateurRepositories;
    @Override
    public FormateurDaos createFormateur(FormateurDaos formateur) {
        Formateur addedFormateur = formateurRepositories.save(ObjectMapperUtils.map(formateur, Formateur.class));
        return ObjectMapperUtils.map(addedFormateur, FormateurDaos.class);
    }


    @Override
    public List<FormateurDaos> getAllFormateurs() {
        List<Formateur> formateurList = formateurRepositories.findAll();
        return formateurList.stream()
                .map(centre -> new FormateurDaos())
                .collect(Collectors.toList());
    }

    @Override
    public FormateurDaos getFormateur(int idFormateur) {
        Optional<Formateur> searchedFormateur = formateurRepositories.findById(idFormateur);

        if(searchedFormateur.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedFormateur.get(), FormateurDaos.class);
    }

    @Override
    public FormateurDaos updateFormateur(int idFormateur, FormateurDaos formateur) {
        if(formateurRepositories.existsById(idFormateur)) {

            return formateur;
        }
        return null;
    }

    @Override
    public boolean deleteFormateur(int IdFormateur) {
        Optional<Formateur> searchedFormateur = formateurRepositories.findById(IdFormateur);

        if(searchedFormateur.isEmpty()) return false;
        formateurRepositories.delete(searchedFormateur.get());
        return true;
    }
}




