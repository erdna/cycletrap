package com.erdna.cycletrap;

import com.erdna.cycletrap.model.Trap;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by André Nitzschke on 23/04/16.
 */
public interface TrapService {

    String SERVICE_ENDPOINT = "http://192.168.1.171:8080";

    @GET("/traps")
    Observable<List<Trap>> getTraps();

}
