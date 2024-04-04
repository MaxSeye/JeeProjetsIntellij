package Services.servicesImpl;

import Repositories.CentreRepositories;
import Services.CentreServices;
import daos.CentreDaos;
import entities.Centre;
import jdk.internal.classfile.impl.ClassPrinterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentreServiceImpl implements CentreServices {
    @Autowired
    CentreRepositories centreRepositorie;

    @Override
    public CentreDaos createCentre(CentreDaos centre) {
        return null;
    }

    @Override
    public boolean getCentre(int idCentre) {
        Optional<Centre> searchedCentre = centreRepositorie.findById(idCentre);
        if(searchedCentre.isEmpty()) return false;
        CentreRepositories.delete(searchedCentre.get());
        return true;
    }

    @Override
    public List<CentreDaos> getAllCentres() {
        List<Centre> clientList = CentreRepositories.findAll();
        List<CentreDaos> Centre = ObjectMapperUtils.mapAll(clientList,CentreDaos.class);
        return Centre;
    }

    @Override
    public CentreDaos updateCentre(int CentreId, CentreDaos centre) {
        if(!CentreRepositories.existsById(CentreId))
            return null;
        else
            return ObjectMapperUtils.map(CentreRepositories.save(ObjectMapperUtils.map(centre, Centre.class)), CentreDaos.class);
    }

    @Override
    public CentreDaos deleteCentre(int idCentre) {
        Optional<Centre> searchedPurchase = CentreRepositories.findById(idCentre);
        ClassPrinterImpl.MapNodeImpl searchedCentre;
        if(searchedCentre.isEmpty()) return false;
        CentreRepositories.delete(searchedCentre.get());
        return true; 

    
}
