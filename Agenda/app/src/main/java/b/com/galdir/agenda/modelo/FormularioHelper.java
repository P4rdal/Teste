package b.com.galdir.agenda.modelo;
import android.widget.EditText;
import android.widget.RatingBar;
import b.com.galdir.agenda.FormularioActivity;
import b.com.galdir.agenda.R;
import b.com.galdir.agenda.modelo.Aluno;
/**
 * Created by marce on 17/06/2017.
 */

public class FormularioHelper {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String site;
    private float nota;


    public FormularioHelper(FormularioActivity activity) {

     this.nome = ((EditText) activity.findViewById(R.id.formulario_nome)).getText().toString();
     this.endereco = ((EditText)activity.findViewById(R.id.formulario_endereco)).getText().toString();
     this.telefone = ((EditText)activity.findViewById(R.id.formulario_telefone)).getText().toString();
     this.site = ( (EditText)activity.findViewById(R.id.formulario_site)  ).getText().toString();
     this.nota = ( (RatingBar)activity.findViewById(R.id.formulario_nota)).getRating();
    }

    public Aluno pegaAluno  (){

        Aluno aluno = new Aluno();
        aluno.setId(this.id);
        aluno.setNome(this.nome);
        aluno.setEndereco(this.endereco);
        aluno.setTelefone(this.telefone);
        aluno.setSite(this.site);
        aluno.setNota(this.nota);

        return aluno;
    }


}
