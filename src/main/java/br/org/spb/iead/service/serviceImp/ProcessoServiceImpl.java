package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.eventos.ProcessoModel;
import br.org.spb.iead.repository.ProcessoRepository;
import br.org.spb.iead.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessoServiceImpl implements ProcessoService {

    @Autowired
    ProcessoRepository processoRepository;

    @Override
    public List<ProcessoModel> findAll() {
        return processoRepository.findAll();
    }

    @Override
    public ProcessoModel findByID(long id) {
        return processoRepository.findById(id).get();
    }

    @Override
    public ProcessoModel save(ProcessoModel processo) {
        return processoRepository.save(processo);
    }

    @Override
    public ProcessoModel findByProcesso(String processo) {
        return processoRepository.findByProcesso(processo);
    }
}
