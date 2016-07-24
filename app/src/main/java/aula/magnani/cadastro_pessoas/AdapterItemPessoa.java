package aula.magnani.cadastro_pessoas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import aula.magnani.cadastro_pessoas.modelo.Pessoa;

/**
 * Created by marcelo on 18/04/16.
 */
public class AdapterItemPessoa extends BaseAdapter {

    private List<Pessoa> lista;
    private LayoutInflater inflador;


    public AdapterItemPessoa(List<Pessoa> pLista, Context context){
        this.lista = pLista;
        this.inflador = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Pessoa getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflador.inflate(R.layout.item_pessoa, parent, false);
        TextView nomePessoa = (TextView) convertView.findViewById(R.id.itemNomePessoa);
        nomePessoa.setText( this.getItem(position).getNome() );

        TextView idadePessoa = (TextView) convertView.findViewById(R.id.itemIdadePessoa);
        idadePessoa.setText( String.valueOf(this.getItem(position).getIdade()) );
        return convertView;
    }
}
