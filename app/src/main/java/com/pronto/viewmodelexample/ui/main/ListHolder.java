package com.pronto.viewmodelexample.ui.main;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.pronto.viewmodelexample.data.Usuario;
import com.pronto.viewmodelexample.databinding.ItemUsuarioBinding;

public class ListHolder extends RecyclerView.ViewHolder {

    private ItemUsuarioBinding mBinding;

    public ListHolder(@NonNull ItemUsuarioBinding mBinding) {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
    }

    public void bind(Usuario usuario) {
        mBinding.setUsuario(usuario);
    }

}
