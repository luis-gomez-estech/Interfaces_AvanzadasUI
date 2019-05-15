package com.luisgomez.interfaces_avanzadasui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class IntroducirURLFragment extends Fragment {

    private Button btnEnviar;
    private IntroducirURLFragmentListener listener;

    // EditText donde introducimos  las urls
    EditText urlWeb1;
    EditText urlWeb2;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof IntroducirURLFragmentListener){
            this.listener = (IntroducirURLFragmentListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_introducir_url,null);

        urlWeb1 = viewRoot.findViewById(R.id.urlWeb1_Toast);

        urlWeb2 = viewRoot.findViewById(R.id.urlWeb2_Toast);

        btnEnviar = viewRoot.findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Validaciones, si no se rellenan los campos, entonces nos alerta

                if (isEmpty(urlWeb1.getText().toString()) || isEmpty(urlWeb2.getText().toString())) {

                    urlWeb1.setError("Rellene este campo"); // Con este setError señalo el error a la derecha del campo con un simbolo rojo, y si nos ponemos encima nos muestra un mensaje
                    urlWeb2.setError("Rellene este campo");

                    //Imprimo en un Toast
                    Toast.makeText(getContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();

                } else {

                // Aqui enviamos al MainActivity el valor introducido para la url1 pasandole el valor al metodo onUrl1Ingresada mediante la interfaz FragmentUnoListener que esta mas abajo
                String direccionURL1 = urlWeb1.getText().toString();
                listener.onUrl1Ingresada(direccionURL1);


                // Aqui enviamos al MainActivity el valor introducido para la url2 igualmente
                String direccionURL2 = urlWeb2.getText().toString();
                listener.onUrl2Ingresada(direccionURL2);

                Toast toast1 = Toast.makeText(getContext(),"Direcciones enviadas a los Fragment", Toast.LENGTH_SHORT);
                toast1.show();

                }


                }


        });

        return viewRoot;
    }

    public static interface IntroducirURLFragmentListener{

        public void onUrl1Ingresada(String url1);
        public void onUrl2Ingresada(String url2);

    }
}