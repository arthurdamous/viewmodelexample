package com.pronto.viewmodelexample.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pronto.viewmodelexample.databinding.MainFragmentBinding;

public class MainFragment extends Fragment implements View.OnClickListener {

    private MainFragmentBinding mBinding;

    private MainViewModel mViewModel;

    private ListAdapter mAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = MainFragmentBinding.inflate(inflater, container, false);
        init();
        return mBinding.getRoot();
    }

    private void init() {
        setupRecycler();
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.init();
        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        mBinding.executePendingBindings();
        mBinding.btnClick.setOnClickListener(this);
    }

    private void setupRecycler() {
        mAdapter = new ListAdapter();
        mBinding.rvLista.setHasFixedSize(true);
        if (mBinding.rvLista.getItemDecorationCount() == 0)
            mBinding.rvLista.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mBinding.rvLista.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        mViewModel.addUsuario();
        mBinding.textNome.requestFocus();
    }
}