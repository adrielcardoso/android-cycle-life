package aula.magnani.cadastro_pessoas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import aula.magnani.cadastro_pessoas.helper.MyDbHelper;

/**
 * Created by marcelo on 11/04/16.
 */
public class Pessoa implements Parcelable{

    private String nome;
    private String sobrenome;
    private String sexo;
    private int idade;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa(){

    }


    //daqui para baixo é do Parcelable

    public Pessoa(Parcel in){
        this.nome = in.readString();
        this.sobrenome = in.readString();
        this.sexo = in.readString();
        this.idade = in.readInt();
        this.id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(sobrenome);
        dest.writeString(sexo);
        dest.writeInt(idade);
        dest.writeInt(id);
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public long save(Context context){
        MyDbHelper dbHelper = new MyDbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //db.execSQL("INSERT");
        ContentValues conteudo = new ContentValues();
        conteudo.put("nome", this.getNome());
        conteudo.put("sobrenome", this.getSobrenome());
        conteudo.put("idade", this.getIdade());
        conteudo.put("sexo", this.getSexo());
        long insertId = db.insert("pessoa", null, conteudo);
        this.setId((int) insertId);
        return insertId;
    }

    public static ArrayList<Pessoa> list(Context context){
        ArrayList<Pessoa> lista = new ArrayList<>();

        MyDbHelper dbHelper = new MyDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] selectedColumns = {"id", "nome", "sobrenome", "idade", "sexo"};
        Cursor cursor = db.query("pessoa", selectedColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            for (int i = 0; i < 30; i++){
                Pessoa p = new Pessoa();
                p.setId(cursor.getInt(0));
                p.setNome(cursor.getString(1));
                p.setSobrenome(cursor.getString(2));
                p.setIdade(cursor.getInt(3));
                p.setSexo(cursor.getString(4));
                lista.add(p);
            }

            cursor.moveToNext();
        }

        return lista;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
