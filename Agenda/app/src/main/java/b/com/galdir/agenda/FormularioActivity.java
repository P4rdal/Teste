package b.com.galdir.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import b.com.galdir.agenda.modelo.Aluno;
import b.com.galdir.agenda.modelo.AlunoDAO;
import b.com.galdir.agenda.modelo.FormularioHelper;

import static android.R.id.edit;
import static android.R.id.inputExtractEditText;
import static b.com.galdir.agenda.R.id.formulario_nome;
import static b.com.galdir.agenda.modelo.FormularioHelper.*;

public class FormularioActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        FormularioHelper formularioHelper = new FormularioHelper(this);
        switch (item.getItemId()) {
             case R.id.menu_formulario_ok:
                Aluno aluno = formularioHelper.pegaAluno();


                 AlunoDAO dao = new AlunoDAO(this);
                 dao.insere(aluno);
                 dao.close();




                 Toast.makeText(FormularioActivity.this, "Aluno salvo com sucesso!", Toast.LENGTH_SHORT).show();
              finish();
              break;






        }
        return super.onOptionsItemSelected(item);
    }




}

