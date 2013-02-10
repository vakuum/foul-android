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

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class FoulMenu {

	public enum MenuId { YELLOW_CARD, RED_CARD, WHISTLE }

	private Context context;

	public FoulMenu(final Context context) {
		this.context = context;
	}

	public List<MenuEntry> getMenuEntries() {
		List<MenuEntry> entries = new ArrayList<MenuEntry>();
		entries.add(new MenuEntry(MenuId.YELLOW_CARD, context.getString(R.string.yellow_card), "yellow.png"));
		entries.add(new MenuEntry(MenuId.RED_CARD, context.getString(R.string.red_card), "red.png"));
		entries.add(new MenuEntry(MenuId.WHISTLE, context.getString(R.string.whistle), "whistle.png"));
		return entries;
	}

}
