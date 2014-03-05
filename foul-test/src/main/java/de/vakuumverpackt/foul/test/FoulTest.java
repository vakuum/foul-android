/*
 * Copyright (C) 2013-2014 Clemens Fuchslocher <clemens@vakuumverpackt.de>
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
package de.vakuumverpackt.foul.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import de.vakuumverpackt.foul.Foul;
import de.vakuumverpackt.foul.R;
import de.vakuumverpackt.foul.RedCardActivity;
import de.vakuumverpackt.foul.YellowCardActivity;

public class FoulTest extends ActivityInstrumentationTestCase2<Foul> {

	private Solo solo;

	public FoulTest() throws ClassNotFoundException {
		super(Foul.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	public void testFoul() throws Exception {
		solo.assertCurrentActivity("Foul.class", Foul.class);
	}

	public void testAbout() throws Exception {
		solo.sendKey(Solo.MENU);
		solo.clickOnText(t(R.string.about));
		Assert.assertTrue(solo.searchText("Foul"));
		Assert.assertTrue(solo.searchText("Icons"));
		Assert.assertTrue(solo.searchText("Sound"));
	}

	public void testYellowCard() throws Exception {
		solo.clickOnText(t(R.string.yellow_card));
		solo.assertCurrentActivity("YellowCardActivity.class", YellowCardActivity.class);
		solo.clickOnScreen(1, 1);
		solo.sendKey(Solo.MENU);
		solo.clickOnText(t(R.string.whistle));
	}

	public void testRedCard() throws Exception {
		solo.clickOnText(t(R.string.red_card));
		solo.assertCurrentActivity("RedCardActivity.class", RedCardActivity.class);
		solo.clickOnScreen(1, 1);
		solo.sendKey(Solo.MENU);
		solo.clickOnText(t(R.string.whistle));
	}

	public void testWhistle() throws Exception {
		solo.clickOnText(t(R.string.whistle));
	}

	private String t(final int id) {
		return solo.getString(id);
	}

}
