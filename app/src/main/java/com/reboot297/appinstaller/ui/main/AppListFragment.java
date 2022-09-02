/*
 * Copyright (c) 2022. Viktor Pop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.reboot297.appinstaller.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.reboot297.appinstaller.App;
import com.reboot297.appinstaller.R;
import com.reboot297.appinstaller.di.ViewModelFactory;

import javax.inject.Inject;

/**
 * Screen with list of all applications.
 */
public class AppListFragment extends Fragment {

    @Inject
    ViewModelFactory viewModelFactory;

    AppListViewModel viewModel;

    private RecyclerView recyclerView;
    private AppListAdapter adapter;

    public static AppListFragment newInstance() {
        return new AppListFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) requireContext().getApplicationContext()).applicationComponent.inject(this);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(AppListViewModel.class);
        adapter = new AppListAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getAppItems().observe(getViewLifecycleOwner(), data -> adapter.submitList(data));

        recyclerView = view.findViewById(R.id.applicationListView);
        recyclerView.setAdapter(adapter);

        viewModel.loadData();
    }
}