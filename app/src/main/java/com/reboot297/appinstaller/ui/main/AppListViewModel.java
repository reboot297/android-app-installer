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

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.reboot297.appinstaller.domain.interactors.GetListApplications;
import com.reboot297.appinstaller.domain.interactors.GetListApplicationsImpl;
import com.reboot297.appinstaller.domain.model.AppItem;

import java.util.List;

import javax.inject.Inject;

/**
 * ViewModel for main screen.
 */
public class AppListViewModel extends ViewModel {

    private final MutableLiveData<List<AppItem>> appItems = new MutableLiveData<>();

    private final GetListApplications getListApplications ;

    public LiveData<List<AppItem>> getAppItems() {
        return appItems;
    }

    @Inject
    public AppListViewModel(GetListApplicationsImpl getListApplications) {
        this.getListApplications = getListApplications;
    }

    void loadData() {
        appItems.postValue(getListApplications.getAppItems());
    }
}