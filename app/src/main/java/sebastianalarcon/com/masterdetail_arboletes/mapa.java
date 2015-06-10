package sebastianalarcon.com.masterdetail_arboletes;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;


public class mapa extends Fragment {

    private MapView mMapView;
    private GoogleMap mMap;
    private Bundle mBundle;
    private final LatLng LOCATION_ARBOLETES = new LatLng(8.850170, -76.42671);
    private CameraUpdate cameraUpdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View inflatedView = inflater.inflate(R.layout.fragment_mapa, container, false);

    try {
        MapsInitializer.initialize(getActivity());
    } catch (Exception e) {
        // TODO handle this situation
    }

    mMapView = (MapView) inflatedView.findViewById(R.id.map);
    mMapView.onCreate(mBundle);
    setUpMapIfNeeded(inflatedView);

    return inflatedView;
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = savedInstanceState;
    }

    private void setUpMapIfNeeded(View inflatedView) {
        if (mMap == null) {
            // Intenta obtener el mapa del MapView.
            mMap = ((MapView) inflatedView.findViewById(R.id.map)).getMap();
            // Comprueba si hemos tenido éxito en la obtención del mapa.
            if (mMap != null) {
                mMap.addMarker(new MarkerOptions().position(LOCATION_ARBOLETES).title("Arboletes").snippet("Volcan de lodo")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                cameraUpdate= CameraUpdateFactory.newLatLngZoom(LOCATION_ARBOLETES, 16);
                mMap.animateCamera(cameraUpdate);
            }
        }
    }
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(8.850170, -76.42671)).title("Arboletes"));
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }





}

    /*private GoogleMap map;
    private CameraUpdate cameraUpdate;

    private final LatLng LOCATION_ARBOLETES = new LatLng(8.850170, -76.42671);

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_mapa, container,false);

        if (map == null) {
            // Intenta obtener el mapa del MapFragment.
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            // Comprueba si hemos tenido éxito en la obtención del mapa.
            if (map != null) {
                map.addMarker(new MarkerOptions().position(LOCATION_ARBOLETES).title("Arboletes").snippet("Volcan de lodo")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                cameraUpdate= CameraUpdateFactory.newLatLngZoom(LOCATION_ARBOLETES, 16);//12 es el zoom, mientras mas pequeño, mas alejado.
                map.animateCamera(cameraUpdate);
            }
        }
           /* map.addMarker(new MarkerOptions()
                    .position(LOCATION_ARBOLETES)
                    .title("Arboletes")
                    .snippet("Volcán de Lodo")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                   map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    cameraUpdate = CameraUpdateFactory.newLatLngZoom(LOCATION_SANTAFE, 16);
                    map.animateCamera(cameraUpdate);
        return rootView;
    }



    @Override
    public void onDetach() {
        super.onDetach();
        /*try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(getActivity(), "OnDetach",Toast.LENGTH_SHORT).show();
        map=null;
    }

    @Override
    public void onPause() {
        super.onPause();
        /*try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(getActivity(), "OnPause",Toast.LENGTH_SHORT).show();
        //map=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "OnDestroy",Toast.LENGTH_SHORT).show();
        //try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        /*}
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.title_activity_mapa);
        Toast.makeText(getActivity(), "OnResume",Toast.LENGTH_SHORT).show();
    }
}*/

