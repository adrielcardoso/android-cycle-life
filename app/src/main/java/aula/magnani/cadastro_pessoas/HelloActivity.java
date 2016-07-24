package aula.magnani.cadastro_pessoas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import aula.magnani.cadastro_pessoas.modelo.Pessoa;


public class HelloActivity extends AppCompatActivity {

    private Pessoa p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

//        String nome = this.getIntent().getStringExtra("nome");
//        String sexo = this.getIntent().getStringExtra("sexo");
        p = this.getIntent().getParcelableExtra("pessoa");


        TextView msgTitle = (TextView) findViewById(R.id.msgTitle);
        if(p.getSexo().equals( getResources().getString(R.string.feminino) )){
            msgTitle.setBackgroundColor( getResources().getColor(R.color.myRed) );
        }else{
            msgTitle.setBackgroundColor( getResources().getColor(R.color.myBlue) );
        }

        TextView msgMessage = (TextView) findViewById(R.id.msgResult);
        msgMessage.setText( p.getNome() );
    }

    public void salvarPessoa(View v){
        if(p.save(this.getApplicationContext()) == -1){
            Toast.makeText(HelloActivity.this, "Deu Ruim", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(HelloActivity.this, "Deu boa!", Toast.LENGTH_SHORT).show();
        }
    }

}
