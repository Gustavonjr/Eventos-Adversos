package br.org.spb.iead.service;

import br.org.spb.iead.model.Config;

public interface ConfigService {

    Config findById(long id);

    Config save(Config config);

}
