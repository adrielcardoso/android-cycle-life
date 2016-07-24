package aula.magnani.cadastro_pessoas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import aula.magnani.cadastro_pessoas.modelo.Pessoa;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAdicionar(View view){
        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        EditText txtSobrenome = (EditText) findViewById(R.id.txtSobrenome);
        EditText txtIdade= (EditText) findViewById(R.id.txtIdade);
        RadioGroup rGrpSexo= (RadioGroup) findViewById(R.id.rGrpSexo);
        int radioSelectedId = rGrpSexo.getCheckedRadioButtonId();

        if( txtNome.getText().toString().equals("") ){
            txtNome.setError( getResources().getString(R.string.campo_obrigatorio, getResources().getString(R.string.nome)) );
            return;
        }
        if(radioSelectedId == -1){
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.campo_obrigatorio, getResources().getString(R.string.sexo)), Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton rGrpSexoRadioButtonSelected = (RadioButton) findViewById(radioSelectedId);

        Toast.makeText(getApplicationContext(), "Ola "+txtNome.getText().toString(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, HelloActivity.class);
//        intent.putExtra("nome", txtNome.getText().toString());
//        intent.putExtra("sexo", rGrpSexoRadioButtonSelected.getText().toString());

        Pessoa p = new Pessoa();
        p.setNome(txtNome.getText().toString());
        p.setSobrenome(txtSobrenome.getText().toString());
        p.setSexo(rGrpSexoRadioButtonSelected.getText().toString());
        p.setIdade(Integer.parseInt(txtIdade.getText().toString()));

        intent.putExtra("pessoa", p);

        startActivity(intent);
    }

    public void onClickVerTodos(View v){
        Intent intent = new Intent(this, ShowAllActivity.class);
        startActivity(intent);
    }

}
