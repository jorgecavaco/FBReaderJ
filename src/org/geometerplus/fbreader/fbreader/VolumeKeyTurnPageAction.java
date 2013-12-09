/*
 * Copyright (C) 2007-2013 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.fbreader.fbreader;

import android.content.Intent;

import com.yotadevices.fbreader.FBReaderYotaService;

import org.geometerplus.fbreader.fbreader.options.PageTurningOptions;
import org.geometerplus.android.fbreader.FBReaderApplication;

class VolumeKeyTurnPageAction extends FBAction {
	private final boolean myForward;

	VolumeKeyTurnPageAction(FBReaderApp fbreader, boolean forward) {
		super(fbreader);
		myForward = forward;
	}

	@Override
	protected void run(Object ... params) {
		if (Reader.YotaDrawOnBackScreenOption.getValue()) {
//			Intent serviceIntent = new Intent(BaseActivity.getApplicationContext(), FBReaderYotaService.class);
//			serviceIntent.setAction(myForward ? FBReaderYotaService.BROADCAST_ACTION_BACKSCREEN_PAGE_RIGHT
//					: FBReaderYotaService.BROADCAST_ACTION_BACKSCREEN_PAGE_LEFT);
//			BaseActivity.getApplicationContext().startService(serviceIntent);
		} else {
			final PageTurningOptions preferences = Reader.PageTurningOptions;
			Reader.getViewWidget().startAnimatedScrolling(
				myForward ? FBView.PageIndex.next : FBView.PageIndex.previous,
				preferences.Horizontal.getValue()
					? FBView.Direction.rightToLeft : FBView.Direction.up,
				preferences.AnimationSpeed.getValue()
			);
		}
	}
}
