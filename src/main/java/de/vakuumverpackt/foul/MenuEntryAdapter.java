/*
 * Copyright (C) 2013 Clemens Fuchslocher <clemens@vakuumverpackt.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.vakuumverpackt.foul;

import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuEntryAdapter extends ArrayAdapter<MenuEntry> {

	public MenuEntryAdapter(final Context context, final FoulMenu menu) {
		super(context, -1, menu.getMenuEntries());
	}

	@Override
	public View getView(final int n, final View view, final ViewGroup group) {
		return getMenuEntryView(n, getView(view));
	}

	private View getMenuEntryView(final int n, final View view) {
		MenuEntry entry = getItem(n);
		if (entry == null) {
			return view;
		}

		ImageView icon = (ImageView) view.findViewById(R.id.menu_entry_icon);
		icon.setImageBitmap(getBitmap(entry));

		TextView label = (TextView) view.findViewById(R.id.menu_entry_label);
		label.setText(entry.getLabel());

		return view;
	}

	private View getView(final View view) {
		if (view != null) {
			return view;
		}
		return getInflater().inflate(R.layout.menu_entry, null);
	}

	public LayoutInflater getInflater() {
		return (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public Bitmap getBitmap(final MenuEntry entry) {
		try {
			return BitmapFactory.decodeStream(getContext().getResources().getAssets().open(entry.getIcon()));
		} catch (IOException e) {
			Log.e("MenuEntryAdapter.getBitmap", e.getMessage(), e);
			return null;
		}
	}

}
