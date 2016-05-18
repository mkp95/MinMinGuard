package tw.fatminmin.xposed.minminguard.blocker.adnetwork;

import tw.fatminmin.xposed.minminguard.Main;
import tw.fatminmin.xposed.minminguard.blocker.ApiBlocking;
import tw.fatminmin.xposed.minminguard.blocker.Blocker;
import tw.fatminmin.xposed.minminguard.blocker.Util;
import android.view.View;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.XposedHelpers.ClassNotFoundError;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Vpon extends Blocker {
    
    public static final String BANNER = "com.vpon.ads.VponBanner";
    public static final String BANNER_PREFIX = "com.vpon.ads";
	public static final String INTER_ADS = "com.vpon.ads.VponInterstitialAd";

	@Override
	public String getBannerPrefix() {
		return BANNER_PREFIX;
	}

	@Override
	public String getBanner() {
		return BANNER;
	}
	public boolean handleLoadPackage(final String packageName, LoadPackageParam lpparam, final boolean removeAd) {
		boolean result = false;
		result |= ApiBlocking.removeBanner(packageName, BANNER, "loadAd", lpparam, removeAd);
		result |= ApiBlocking.blockAdFunction(packageName, INTER_ADS, "show", lpparam, removeAd);

		return result;
	}
}
