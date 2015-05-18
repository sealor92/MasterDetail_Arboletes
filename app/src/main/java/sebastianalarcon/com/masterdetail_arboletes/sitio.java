package sebastianalarcon.com.masterdetail_arboletes;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;



public class sitio extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sitio, container, false);


        final TextView tsitios =(TextView) view.findViewById(R.id.tsitios);
        final ImageView isitios = (ImageView) view.findViewById(R.id.isitios);

        Spinner spinner = (Spinner) view.findViewById( R.id.sitios_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.sitios_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                switch(position) {
                    case 0:
                        isitios.setImageResource(R.drawable.sitio1);
                        tsitios.setText(R.string.sitio1);
                        break;

                    case 1:
                        isitios.setImageResource(R.drawable.sitio2);
                        tsitios.setText(R.string.sitio2);
                        break;

                    case 2:
                        isitios.setImageResource(R.drawable.sitio3);
                        tsitios.setText(R.string.sitio3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.title_activity_sitios);
    }
}
