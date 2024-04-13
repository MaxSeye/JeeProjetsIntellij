package Services;

import daos.InscriptionDaos;

import java.util.List;

public interface InscriptionServices {
    InscriptionDaos createInscription(InscriptionDaos inscription);

    boolean getInscription(int idInscription);

    List<InscriptionDaos> getAllInscriptions();

    InscriptionDaos updateInscriptions(int idInscription, InscriptionDaos inscription);

    boolean deleteInscription(int idInscription);

}

