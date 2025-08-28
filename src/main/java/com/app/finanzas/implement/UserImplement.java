package com.app.finanzas.implement;

import com.app.finanzas.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.app.finanzas.repository.UserRepository;
import com.app.finanzas.dto.UserDTO;
import com.app.finanzas.entity.User;

@Service
public class UserImplement implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO save(UserDTO dto) {
        User userEntity = modelMapper.map(dto, User.class);
        User savedEntity = repository.save(userEntity);
        return modelMapper.map(savedEntity, UserDTO.class);
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User userEntity = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        modelMapper.typeMap(UserDTO.class, User.class)
                .addMappings(mapper -> mapper.skip(User::setIdUser));

        modelMapper.map(dto, userEntity);

        User updatedEntity = repository.save(userEntity);
        return modelMapper.map(updatedEntity, UserDTO.class);
    }

    @Override
    public UserDTO findById(Long id) {
        User userEntity = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, UserDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        if(!repository.existsById(id)){
               return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean validarLogin(String email, String contrasena) {
        User user = repository.findByEmail(email);
        if(contrasena.equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
