package b.com.galdir.agenda.modelo;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import b.com.galdir.agenda.ListaAlunosActivity;
import b.com.galdir.agenda.R;

/**
 * Created by marce on 04/08/2017.
 */

public class AlunoAdapter extends BaseAdapter {

    private List<Aluno> alunos;
    private Activity activity;

    public AlunoAdapter(Activity activity , List<Aluno> alunos) {

        this.activity = activity;
        this.alunos = alunos;

    }


    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = this.activity.getLayoutInflater().inflate(R.layout.activity_lista_alunos,null);

        Aluno aluno = alunos.get(position);

        TextView nome;
        nome = (TextView) view.findViewById(R.id.list_item,null);

        return view;
    }
}
