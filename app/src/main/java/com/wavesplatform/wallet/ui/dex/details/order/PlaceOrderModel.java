package com.wavesplatform.wallet.ui.dex.details.order;

import android.databinding.BaseObservable;

import com.wavesplatform.wallet.payload.WatchMarket;
import com.wavesplatform.wallet.request.AssetPair;

public class PlaceOrderModel extends BaseObservable {

    private WatchMarket watchMarket;
    private AssetPair assetPair;
    private double price;
    private boolean dontAskAgain = false;
    public static final String sWAVES = "COF";

    public WatchMarket getWatchMarket() {
        return watchMarket;
    }

    public void setWatchMarket(WatchMarket pairModel) {
        this.watchMarket = pairModel;

        assetPair = new AssetPair(pairModel.market.amountAsset.trim().equals(sWAVES) ? "" : pairModel.market.amountAsset,
                pairModel.market.priceAsset.trim().equals(sWAVES) ? "" : pairModel.market.priceAsset);
    }

    public AssetPair getAssetPair() {
        return assetPair;
    }

    public boolean isDontAskAgain() {
        return dontAskAgain;
    }

    public void setDontAskAgain(boolean dontAskAgain) {
        this.dontAskAgain = dontAskAgain;
    }

    public int getAmountDecimals() {
        return watchMarket.market.getAmountAssetInfo().decimals;
    }

    public int getPriceDecimals() {
        return watchMarket.market.getPriceAssetInfo().decimals;
    }

    public int getPriceValueDecimals() {
        return 8 + getPriceDecimals() - getAmountDecimals();
    }
}
