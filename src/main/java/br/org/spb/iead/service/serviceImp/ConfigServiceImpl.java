package br.org.spb.iead.service.serviceImp;

import br.org.spb.iead.model.Config;
import br.org.spb.iead.repository.ConfigRepository;
import br.org.spb.iead.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigRepository configRepository;

    public ConfigServiceImpl(){

    }

    @Override
    public Config findById(long id) {
        return configRepository.findById(id).get();
    }

    @Override
    public Config save(Config config) {
        return configRepository.save(config);
    }
}
