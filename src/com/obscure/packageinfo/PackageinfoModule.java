/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.obscure.packageinfo;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

@Kroll.module(name = "PackageInfo", id = "com.obscure.packageinfo")
public class PackageinfoModule extends KrollModule {

	private static final String		LCAT	= "PackageInfo";

	private static final boolean	DBG		= TiConfig.LOGD;

	public PackageinfoModule() {
		super();
	}

	private PackageInfo	info	= null;

	private PackageInfo getInfo() {
		if (info == null) {
			try {
				Activity activity = this.getActivity();
				info = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
			}
			catch (NameNotFoundException e) {
				Log.e(LCAT, e.getMessage());
			}
		}
		return info;
	}

	@Kroll.getProperty(name = "versionCode")
	public int getVersionCode() {
		PackageInfo info = getInfo();
		return info != null ? info.versionCode : 0;
	}

	@Kroll.getProperty(name = "versionName")
	public String getVersionName() {
		PackageInfo info = getInfo();
		return info != null ? info.versionName : null;
	}

	@Kroll.getProperty(name = "packageName")
	public String getPackageName() {
		PackageInfo info = getInfo();
		return info != null ? info.packageName : null;
	}

}
