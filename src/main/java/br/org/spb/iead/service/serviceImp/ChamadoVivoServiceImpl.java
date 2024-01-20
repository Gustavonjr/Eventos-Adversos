package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.informatica.ChamadoVivo;
import br.org.spb.iead.repository.ChamadoVivoRepository;
import br.org.spb.iead.service.ChamadoVivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoVivoServiceImpl implements ChamadoVivoService {

    @Autowired
    ChamadoVivoRepository chamadoVivoRepository;

    @Override
    public List<ChamadoVivo> findAll() {
        return chamadoVivoRepository.findAll();
    }

    @Override
    public ChamadoVivo findById(long id) {
        return chamadoVivoRepository.findById(id).get();
    }

    @Override
    public ChamadoVivo save(ChamadoVivo chamadoVivo) {
        return chamadoVivoRepository.save(chamadoVivo);
    }
}
