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

package com.reboot297.appinstaller.data;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.reboot297.appinstaller.data.file.FileManager;
import com.reboot297.appinstaller.data.mapper.JsonMapper;
import com.reboot297.appinstaller.domain.model.AppItem;
import com.reboot297.appinstaller.domain.repository.AppItemsRepository;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppItemsRepositoryImpl implements AppItemsRepository {

    private final FileManager fileManager;
    private final JsonMapper jsonMapper;
    private final Context applicationContext;

    @Inject
    public AppItemsRepositoryImpl(@NonNull Context context,
                                  @NonNull FileManager fileManager,
                                  @NonNull JsonMapper jsonMapper) {
        this.fileManager = fileManager;
        this.applicationContext = context;
        this.jsonMapper = jsonMapper;
        initData();
    }

    private void initData() {
        File file = new File(applicationContext.getFilesDir(), "local_data.txt");
        String data = fileManager.readFile(Uri.fromFile(file));
        JSONObject jsonObject = jsonMapper.fromString(data);
        Log.d("", "initData: " + data);
    }

    @Override
    public List<AppItem> getAllItems() {
        List<AppItem> items = new ArrayList<>();
        items.add(createFakeItem(0));
        items.add(createFakeItem(1));
        items.add(createFakeItem(2));
        items.add(createFakeItem(3));
        items.add(createFakeItem(4));
        items.add(createFakeItem(5));
        return items;
    }

    private AppItem createFakeItem(int number) {
        AppItem item = new AppItem();
        item.setTitle("Item" + number);
        return item;
    }

}
