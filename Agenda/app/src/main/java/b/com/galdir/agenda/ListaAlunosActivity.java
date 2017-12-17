package b.com.galdir.agenda;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import b.com.galdir.agenda.modelo.AlunoAdapter;
import java.util.ArrayList;
import java.util.List;

import b.com.galdir.agenda.R;
import b.com.galdir.agenda.modelo.Aluno;
import b.com.galdir.agenda.modelo.AlunoAdapter;
import b.com.galdir.agenda.modelo.AlunoDAO;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;




public class ListaAlunosActivity extends AppCompatActivity {

    ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);


        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        registerForContextMenu(listaAlunos);


        Button novoAluno = (Button) findViewById(R.id.novo_aluno);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaAlunosActivity.this,
                        FormularioActivity.class);
                startActivity(intent);


            }
        });


    }


    @Override
    public void onResume() {
        super.onResume();
        ;
        carregarLista();
    }

    private void carregarLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);

    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem delete = menu.add("Delete");

        delete.setOnMenuItemClickListener(MenuItem menu ) { AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Aluno aluno = (Aluno) ListaAluno.getItemAtPosition(info.position);

        }
    }

}