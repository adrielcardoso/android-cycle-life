package aula.magnani.cadastro_pessoas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marcelo on 11/04/16.
 */
public class MyDbHelper extends SQLiteOpenHelper {

    public MyDbHelper(Context context){
        super(context, "my_app", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, sobrenome TEXT, idade INTEGER, sexo TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
