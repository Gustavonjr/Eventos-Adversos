package br.org.spb.iead.service;

import br.org.spb.iead.model.Evento;
import br.org.spb.iead.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> findAll();
    UserModel findById(long id);
    UserModel save(UserModel userModel);
    Optional<UserModel> findByUsername(String username);
}
