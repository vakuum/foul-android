/*
 * Copyright (C) 2014 Clemens Fuchslocher <clemens@vakuumverpackt.de>
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.Robolectric.shadowOf_;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.robolectric.shadows.ShadowListView;

import android.media.AudioManager;
import android.widget.ListAdapter;
import de.vakuumverpackt.foul.FoulMenu.MenuId;

@RunWith(RobolectricTestRunner.class)
public class FoulTest {

	private Foul foul;

	@Before
	public void before() throws Exception {
		foul = buildActivity(Foul.class).create().get();
	}

	@Test
	public void testTitle() throws Exception {
		assertThat(foul.getTitle().toString(), equalTo("Foul"));
	}

	@Test
	public void testMenu() throws Exception {
		ListAdapter menu = foul.getListAdapter();
		assertThat(menu, is(MenuEntryAdapter.class));
		assertThat(menu.getCount(), equalTo(3));

		assertThat(menuLabel(menu, 0), equalTo("Yellow card"));
		assertThat(menuLabel(menu, 1), equalTo("Red card"));
		assertThat(menuLabel(menu, 2), equalTo("Whistle"));

		assertThat(menuId(menu, 0), equalTo(MenuId.YELLOW_CARD));
		assertThat(menuId(menu, 1), equalTo(MenuId.RED_CARD));
		assertThat(menuId(menu, 2), equalTo(MenuId.WHISTLE));
	}

	private String menuLabel(final ListAdapter menu, final int n) {
		return ((MenuEntry) menu.getItem(n)).getLabel();
	}

	private MenuId menuId(final ListAdapter menu, final int n) {
		return ((MenuEntry) menu.getItem(n)).getId();
	}

	@Test
	public void testMenuClicks() throws Exception {
		testMenuClick(0, YellowCardActivity.class);
		testMenuClick(1, RedCardActivity.class);
	}

	private void testMenuClick(final int index, final Class<?> expected) {
		ShadowListView list = shadowOf_(foul.getListView());
		assertThat(list.performItemClick(index), is(true));

		ShadowActivity activity = shadowOf_(foul);
		ShadowIntent intent = shadowOf_(activity.getNextStartedActivity());
		assertThat(intent.getIntentClass().getName(), equalTo(expected.getName()));
	}

	@Test
	public void testAudio() throws Exception {
		assertThat(foul.getVolumeControlStream(), is(AudioManager.STREAM_MUSIC));
	}
}
