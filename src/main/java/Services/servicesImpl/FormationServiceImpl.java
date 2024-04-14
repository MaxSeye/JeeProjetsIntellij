package Services.servicesImpl;


import Repositories.FormationRepositories;
import Services.FormationServices;


import daos.FormateurDaos;
import daos.FormationDaos;
import entities.Formateur;
import entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectMapperUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FormationServiceImpl implements FormationServices {

    @Autowired
    FormationRepositories formationRepositories;

    @Override
    public FormationDaos createFormation(FormationDaos formation) {
        Formation addedFormation = formationRepositories.save(ObjectMapperUtils.map(formation, Formation.class));
        return ObjectMapperUtils.map(addedFormation, FormationDaos.class);
    }

    @Override
    public FormationDaos getFormation(int idFormation) {
        Optional<Formation> searchedFormation = formationRepositories.findById(idFormation);

        if(searchedFormation.isEmpty()) return null;
        return ObjectMapperUtils.map(searchedFormation.get(), FormationDaos.class);
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
    public boolean deleteFormation(int IdFormation) {
        Optional<Formation> searchedFormation = formationRepositories.findById(IdFormation);

        if(searchedFormation.isEmpty()) return false;
        formationRepositories.delete(searchedFormation.get());
        return true;
    }
}








