package b.com.galdir.agenda.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marce on 17/06/2017.
 */

public class AlunoDAO extends SQLiteOpenHelper {

    public AlunoDAO(Context context) {
        super(context, "agenda", null , 1);
    }



    @Override
    public void onCreate(SQLiteDatabase basededados) {

    String SQL = "CREATE TABLE Alunos (id INTERGER PRIMARY KEY\n" +
            ", nome TEXT NOT NULL" +
            ", endereco TEXT" +
            ", telefone TEXT" +
            ", site TEXT" +
            ", nota REAL); ";

        basededados.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase basededados, int i , int i1) {

     String SQL = "DROP TABLE IF EXIST Alunos";
     basededados.execSQL(SQL);
     this.onCreate(basededados);

    }


public void insere (Aluno aluno) {

    SQLiteDatabase database = getWritableDatabase();
    ContentValues data = new ContentValues();
    data.put("nome",aluno.getNome());
    data.put("endereco",aluno.getEndereco());
    data.put("telefone",aluno.getTelefone());
    data.put("site",aluno.getSite());
    data.put("nota",aluno.getNota());


    database.insert("Alunos",null,data);
}






    public List<Aluno> buscaAlunos() {

        String SQL = "SELECT id, nome, endereco, telefone, site, nota FROM Alunos ";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(SQL, null);
        List<Aluno> alunos = new ArrayList<Aluno>();

        while (cursor.moveToNext()) {

            Aluno aluno = new Aluno();
            aluno.setId(cursor.getLong(cursor.getColumnIndex("id")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("site")));
            aluno.setNota(cursor.getFloat(cursor.getColumnIndex("nota")));

            alunos.add(aluno);

        }

        cursor.close();
        return alunos;









    }







}


