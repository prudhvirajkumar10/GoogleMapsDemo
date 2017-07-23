package com.assessment.googlemapsdemo.database;


import android.content.Context;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class DataManager {

    public PlaceDao placeDao;

    private DaoSession session;

    public DataManager(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "place.db");
        Database db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();
        placeDao = session.getPlaceDao();
    }

    public void savePlace(Place place){
        placeDao.insert(place);
    }

    public List<Place> getAllPlaces(){
        return placeDao.queryBuilder().orderAsc(PlaceDao.Properties.Id).build().list();
    }
}
