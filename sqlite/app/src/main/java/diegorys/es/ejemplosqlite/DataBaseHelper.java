package diegorys.es.ejemplosqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by Diego on 17/11/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "data/data/diegorys.es.ejemplosqlite/databases/";
    static final String DB_NAME = "formacion.sqlite";
    private SQLiteDatabase myDataBase;
    private Context myContext;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase();
        SQLiteDatabase db_Read = null;

        if(!dbExist){
            db_Read = this.getReadableDatabase();
            db_Read.close();

            try{
                copyDataBase();
            }catch (Exception e){
                throw new Error("Error copying database");
            }
        }
    }

    public void openDataBase() throws SQLException{
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = this.myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;

        OutputStream myOutput= new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int lenght;

        while((lenght = myInput.read(buffer)) != -1){
            if(lenght > 0){
                myOutput.write(buffer, 0, lenght);
            }
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;

        String myPath = DB_PATH + DB_NAME;

        try{
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch (SQLiteException e){
            File dbFile = new File(DB_PATH + DB_NAME);
            return dbFile.exists();
        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor fetchTeacher(String palabra) throws SQLException{
        String[] campos = new String[]{"id", "nombre"};
        String[] args = new String[]{palabra};

        Cursor qCursor = myDataBase.query("maestros", campos, "nombre=?", args, null, null, null);

        if(qCursor != null){
            qCursor.moveToFirst();
        }

        return qCursor;
    }
}
