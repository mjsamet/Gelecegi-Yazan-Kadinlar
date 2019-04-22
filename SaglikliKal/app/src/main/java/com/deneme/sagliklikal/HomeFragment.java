package com.deneme.sagliklikal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.deneme.sagliklikal.data.SaglikliKalDb;
import com.deneme.sagliklikal.data.model.KiloGecmisi;
import com.deneme.sagliklikal.data.repository.KiloGecmisiRepository;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnHesapla = view.findViewById(R.id.buttonHesapla);
        final EditText editTextKilo = view.findViewById(R.id.editTextKilo);
        final EditText editTextBoy = view.findViewById(R.id.editTextBoy);

        KiloGecmisiRepository repository =  ((App)view.getContext().getApplicationContext()).GetKiloGecmisiRepository();
        KiloGecmisi k = repository.GetLast();
        if(k != null){
            editTextKilo.setText(k.getKilo()+"");
            editTextBoy.setText(k.getBoy()+"");
        }

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vücut ağırlığı / boyun metre cinsinden karesi
                int vucutAgirligi = Integer.valueOf(editTextKilo.getText().toString());
                int boyu = Integer.valueOf(editTextBoy.getText().toString());

                double yeniBoy = (double)boyu / 100;

                double indeks = vucutAgirligi / (yeniBoy* yeniBoy);
                TextView textViewSonuc = view.findViewById(R.id.textViewSonuc);
                textViewSonuc.setText("Vücut kitle indeksiniz: " + indeks);


                KiloGecmisiRepository repo =  ((App)view.getContext().getApplicationContext()).GetKiloGecmisiRepository();

                KiloGecmisi kiloGecmisi = new KiloGecmisi();
                kiloGecmisi.setBoy(boyu);
                kiloGecmisi.setKilo(vucutAgirligi);
                kiloGecmisi.setIndeks(indeks);
                kiloGecmisi.setTarih(new Date());

                repo.Add(kiloGecmisi);

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       // if (context instanceof OnFragmentInteractionListener) {
        //    mListener = (OnFragmentInteractionListener) context;
        //} else {
        //    throw new RuntimeException(context.toString()
         //           + " must implement OnFragmentInteractionListener");
        //}
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
