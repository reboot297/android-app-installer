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

package com.reboot297.appinstaller.domain.interactors;

import com.reboot297.appinstaller.domain.model.AppItem;
import com.reboot297.appinstaller.domain.repository.AppItemsRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * UseCase to get all applications.
 */
public class GetListApplicationsImpl implements GetListApplications {

    private final AppItemsRepository appItemsRepository;

    @Inject
    public GetListApplicationsImpl(AppItemsRepository appItemsRepository) {
        this.appItemsRepository = appItemsRepository;
    }

    @Override
    public List<AppItem> getAppItems() {
        return appItemsRepository.getAllItems();
    }
}
