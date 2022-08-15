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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.reboot297.appinstaller.domain.model.AppItem;

import java.util.Objects;

/**
 * DiffUtil Callback for the list of applications
 */
class AppItemDiffUtilCallback extends DiffUtil.ItemCallback<AppItem> {
    @Override
    public boolean areItemsTheSame(@NonNull AppItem oldItem, @NonNull AppItem newItem) {
        return Objects.equals(oldItem.getId(), newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull AppItem oldItem, @NonNull AppItem newItem) {
        return oldItem.equals(newItem);
    }
}
