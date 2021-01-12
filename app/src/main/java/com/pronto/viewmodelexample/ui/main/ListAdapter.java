package com.pronto.viewmodelexample.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.pronto.viewmodelexample.data.Usuario;
import com.pronto.viewmodelexample.databinding.ItemUsuarioBinding;

public class ListAdapter extends androidx.recyclerview.widget.ListAdapter<Usuario, ListHolder> {

    public ListAdapter() {
        super(Usuario.getItemCallback());
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUsuarioBinding mBinding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ListHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        holder.bind(getItem(position));
    }

}
