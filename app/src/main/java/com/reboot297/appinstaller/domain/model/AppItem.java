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

package com.reboot297.appinstaller.domain.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Application info.
 */
public class AppItem {
    @Nullable
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppItem appItem = (AppItem) o;
        return Objects.equals(id, appItem.id) && Objects.equals(title, appItem.title) && Objects.equals(url, appItem.url) && Objects.equals(localPath, appItem.localPath) && tags.equals(appItem.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, url, localPath, tags);
    }

    @Nullable
    private String title;
    @Nullable
    private String url;
    @Nullable
    private String localPath;
    @NonNull
    private List<String> tags = new ArrayList<>();


    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public void setUrl(@Nullable String url) {
        this.url = url;
    }

    @Nullable
    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(@Nullable String localPath) {
        this.localPath = localPath;
    }

    @NonNull
    public List<String> getTags() {
        return tags;
    }

    public void setTags(@NonNull List<String> tags) {
        this.tags = tags;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable String id) {
        this.id = id;
    }
}
