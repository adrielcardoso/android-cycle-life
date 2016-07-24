package aula.magnani.cadastro_pessoas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import aula.magnani.cadastro_pessoas.modelo.Pessoa;

public class ShowAllActivity extends AppCompatActivity {

    AdapterItemPessoa adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        ArrayList<Pessoa> lista = Pessoa.list(this.getApplicationContext());
//        String resultado = "";
//        for(int i = 0; i < lista.size(); i++){
//            resultado += lista.get(i).getId()+ " - "+lista.get(i).getNome()+"\n";
//        }
//        Toast.makeText(this.getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

        adaptador = new AdapterItemPessoa(lista, getApplicationContext());

        ListView listaResultado = (ListView) findViewById(R.id.listaResultado);
        listaResultado.setAdapter(adaptador);

        listaResultado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), adaptador.getItem(position).getSobrenome() , Toast.LENGTH_LONG).show();
            }
        });


//        TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
//        txtResultado.setText(resultado);

    }


}
