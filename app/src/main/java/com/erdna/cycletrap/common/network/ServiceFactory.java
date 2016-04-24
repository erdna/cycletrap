package com.erdna.cycletrap.common.network;

import retrofit.RestAdapter;

/**
 * Created by André Nitzschke on 23/04/16.
 */
public class ServiceFactory {
    static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .build();
        T service = restAdapter.create(clazz);

        return service;
    }
}
