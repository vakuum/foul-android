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

import android.app.ListActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Foul extends ListActivity {

	@Override
	protected void onCreate(final Bundle bundle) {
		super.onCreate(bundle);
		setTitle(getString(R.string.foul));
		setListAdapter(getAdapter());
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
	}

	private ListAdapter getAdapter() {
		return new MenuEntryAdapter(this);
	}

	@Override
	protected void onListItemClick(final ListView list, final View view, final int position, final long id) {
		MenuEntry entry = (MenuEntry) list.getItemAtPosition(position);
		switch (entry.getId()) {
			case YELLOW_CARD:
				startActivity(new Intent(this, YellowCardActivity.class));
				break;

			case RED_CARD:
				startActivity(new Intent(this, RedCardActivity.class));
				break;

			case WHISTLE:
				Whistler.whistle(this);
				break;

			default:
				Log.e("Foul.onListItemClick", "Unknown Id; entry.getId() == " + entry.getId());
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.activity_about, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		if (item.getItemId() == R.id.menu_about) {
			new About(this).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
