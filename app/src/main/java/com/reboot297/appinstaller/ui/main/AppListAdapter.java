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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.reboot297.appinstaller.R;
import com.reboot297.appinstaller.domain.model.AppItem;

/**
 * Adapter for list of applications.
 */
class AppListAdapter extends ListAdapter<AppItem, AppListAdapter.AppListViewHolder> {

    AppListAdapter() {
        super(new AppItemDiffUtilCallback());
    }

    @NonNull
    @Override
    public AppListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AppListViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppListViewHolder holder, int position) {
        holder.titleView.setText(getCurrentList().get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    static class AppListViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;

        public AppListViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.titleView);
        }
    }
}
