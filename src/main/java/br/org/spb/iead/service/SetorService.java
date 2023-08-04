package br.org.spb.iead.service;

import br.org.spb.iead.model.SetorModel;
import java.util.List;

public interface SetorService {

    List<SetorModel> findAll();
    SetorModel findById(long id);
    SetorModel save(SetorModel s);

}
