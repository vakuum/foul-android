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

import org.apache.commons.io.IOUtils;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class About extends Dialog {

	public About(final Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setCanceledOnTouchOutside(true);
	}

	@Override
	public void onCreate(final Bundle bundle) {
		setContentView(R.layout.activity_about);

		TextView text = (TextView) findViewById(R.id.textView);
		text.setLinkTextColor(getLinkColor());
		text.setMovementMethod(LinkMovementMethod.getInstance());
		text.setText(getText());
		text.setTextColor(getTextColor());
	}

	private Spanned getText() {
		return Html.fromHtml(read(R.raw.about));
	}

	private ColorStateList getLinkColor() {
		return getColor(android.R.color.primary_text_dark_nodisable);
	}

	private ColorStateList getTextColor() {
		return getColor(android.R.color.secondary_text_dark_nodisable);
	}

	private ColorStateList getColor(final int color) {
		return getContext().getResources().getColorStateList(color);
	}

	private String read(final int id) {
		try {
			return IOUtils.toString(getContext().getResources().openRawResource(id), "UTF-8");
		} catch (Exception e) {
			Log.e("About.read", e.getMessage(), e);
			return "";
		}
	}

}
