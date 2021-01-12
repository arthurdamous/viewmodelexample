package com.pronto.viewmodelexample.adapters;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.pronto.viewmodelexample.data.Usuario;
import com.pronto.viewmodelexample.ui.main.ListAdapter;

import java.util.List;

public class BindingAdapters {


    @BindingAdapter(value = "items")
    public static void setUsuariosItems(RecyclerView view, List<Usuario> usuarios){
        ListAdapter mAdapter = (ListAdapter) view.getAdapter();
        mAdapter.submitList(usuarios);
    }

}
