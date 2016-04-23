package com.erdna.cycletrap;

import android.os.Bundle;
import android.widget.Toast;

import com.erdna.cycletrap.model.Trap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by André Nitzschke on 23/04/16.
 */
public class TrapMapFragment extends SupportMapFragment implements OnMapReadyCallback {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        TrapService service = ServiceFactory.createRetrofitService(TrapService.class, TrapService.SERVICE_ENDPOINT);

        service.getTraps()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Trap>>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(getContext(), "complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNext(List<Trap> traps) {
                        Toast.makeText(getContext(), "traps count" + traps.size(), Toast.LENGTH_SHORT).show();

                        LatLng last = new LatLng(0, 0);
                        for (Trap trap : traps) {
                            googleMap.addMarker(new MarkerOptions()
                                    .position(last = new LatLng(trap.latitude, trap.longitude))
                                    .title(trap.name));
                        }

                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(last, 12));


                    }
                });

    }
}
