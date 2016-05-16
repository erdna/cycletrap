package com.erdna.cycletrap.common.network;

import com.erdna.cycletrap.BuildConfig;
import com.erdna.cycletrap.common.model.Trap;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by André Nitzschke on 23/04/16.
 */
public interface TrapService {

    String BASE_URL = BuildConfig.API_BASE_URL;

    @GET("/traps")
    Observable<List<Trap>> getTraps();

    @POST("/traps")
    Observable<Trap> ceateTrap(@Body Trap trap);

}
