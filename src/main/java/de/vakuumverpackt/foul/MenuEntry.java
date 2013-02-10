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

import de.vakuumverpackt.foul.FoulMenu.MenuId;

public class MenuEntry {

	private MenuId id;
	private String label;
	private String icon;

	public MenuEntry(final MenuId id, final String label, final String icon) {
		this.id = id;
		this.label = label;
		this.icon = icon;
	}

	public String getLabel() {
		return label;
	}

	public String getIcon() {
		return icon;
	}

	public MenuId getId() {
		return id;
	}

}
