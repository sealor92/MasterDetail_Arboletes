package sebastianalarcon.com.masterdetail_arboletes;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;


public class mapa extends Fragment {

    private GoogleMap map;
    private CameraUpdate cameraUpdate;

    private final LatLng LOCATION_ARBOLETES = new LatLng(8.850170, -76.42671);

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_mapa, container,false);

        Toast.makeText(getActivity(),"Hola desde Start", Toast.LENGTH_SHORT).show();

        if (map == null) {
            // Intenta obtener el mapa del SupportMapFragment.
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            // Comprueba si hemos tenido éxito en la obtención del mapa.
            if (map != null) {
                map.addMarker(new MarkerOptions().position(LOCATION_ARBOLETES).title("Guarne").snippet("Parque Principal")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                cameraUpdate= CameraUpdateFactory.newLatLngZoom(LOCATION_ARBOLETES, 12);//12 es el zonn, mientras mas pequeño, mas alejado.
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
                    map.animateCamera(cameraUpdate);*/
        return rootView;
    }



    @Override
    public void onDetach() {
        super.onDetach();
        try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try{
            Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.title_activity_mapa);
    }
}