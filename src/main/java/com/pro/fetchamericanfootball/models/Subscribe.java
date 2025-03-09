package com.pro.fetchamericanfootball.models;

import java.util.ArrayList;

public class Subscribe {
    public Subscribe() {
    }

    public ArrayList<String> marketTypes = new ArrayList<String>() ;
    public ArrayList<String> ids = new ArrayList<String>();

    public ArrayList<String> getIds() {
        return ids;
    }

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }

    public ArrayList<String> getMarketTypes() {
        return marketTypes;
    }

    public void setMarketTypes(ArrayList<String> marketTypes) {
        this.marketTypes = marketTypes;
    }
}
