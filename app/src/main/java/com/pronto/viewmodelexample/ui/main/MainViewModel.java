package com.pronto.viewmodelexample.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pronto.viewmodelexample.data.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Usuario> _usuario = new MutableLiveData<>();
    private MutableLiveData<List<Usuario>> _usuarios = new MutableLiveData<>();


    public void init() {
        if (_usuario.getValue() == null)
            _usuario.setValue(new Usuario());
        if (_usuarios.getValue() == null)
            _usuarios.setValue(new ArrayList<>());
    }

    public void addUsuario() {
        if (_usuario.getValue() != null && _usuarios.getValue() != null) {
            List<Usuario> usuarios = new ArrayList<>(_usuarios.getValue());
            Usuario usuario = _usuario.getValue();
            usuario.setId(getUsuarioId(usuarios));
            usuarios.add(usuario);
            _usuario.setValue(new Usuario());
            _usuarios.setValue(usuarios);
        }
    }

    private int getUsuarioId(List<Usuario> usuarios) {
        if (usuarios.size() > 0)
            return usuarios.get(usuarios.size() - 1).getId() + 1;
        return 1;
    }

    public MutableLiveData<Usuario> getUsuario() {
        return _usuario;
    }

    public MutableLiveData<List<Usuario>> getUsuarios() {
        return _usuarios;
    }

}