package co.edu.ue.basedatossqlite.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import android.util.Log;
import android.view.View;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import co.edu.ue.basedatossqlite.entidades.User;

public class UserDao {

    private ManagerDataBase managerDataBase;
    Context context;
    View view;
    User user;

    public UserDao(Context context, View view) {
        this.context = context;
        this.view = view;
        this.managerDataBase = new ManagerDataBase(this.context);
    }

    public void insertUser(User user){
        try {
            SQLiteDatabase db = managerDataBase.getWritableDatabase();
            if(db != null){
                ContentValues values = new ContentValues();
                values.put("use_document", user.getDocument());
                values.put("use_user", user.getUser());
                values.put("use_names", user.getNames());
                values.put("use_lastNames", user.getLastNames());
                values.put("use_pass", user.getPassword());
                values.put("use_status", "1");
                long cod = db.insert("users",null,values);
                Snackbar.make(this.view, "Se ha registrado el usuario" +cod,Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(this.view, "No se ha podido registrar al usuario" ,Snackbar.LENGTH_LONG).show();
            }
        }catch (SQLException e){
            Log.i("Error en BD", ""+e);
        }
    }

    public ArrayList<User> getUserList(){
        SQLiteDatabase db = managerDataBase.getReadableDatabase();
        String query = "select * from users where use_status =1;";
        ArrayList<User> listaUsuarios = new ArrayList<>();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{
                User user1 = new User();
                user1.setDocument(cursor.getInt(0));
                user1.setUser(cursor.getString(1));
                user1.setNames(cursor.getString(2));
                user1.setLastNames(cursor.getString(3));
                user1.setPassword(cursor.getString(4));
                listaUsuarios.add(user1);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaUsuarios;
    }
}
