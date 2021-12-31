package com.example.peticioneshttp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val actionBar = supportActionBar

        actionBar?.hide()

        val queue = Volley.newRequestQueue(this)
        val url: String = "https://cursodemoviles.000webhostapp.com/listar.php"

        val stringReq = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    var jsonArray = JSONArray(response)
                    var usuarios= arrayOfNulls<String>(jsonArray.length())
                    for(i in 0 until jsonArray.length()){
                        var jsonObject=JSONObject(jsonArray.getString(i))
                        var nombre=jsonObject.get("nombre")
                        var contra=jsonObject.get("contrasena")
                        var usuario=jsonObject.get("usuario")
                        var id=jsonObject.get("idPersona")
                        usuarios[i]="Id:${id}\nNombre: ${nombre}\nUsuario: ${usuario}\nContraseña: ${contra}\n"
                    }
                    val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usuarios)
                    list1.adapter = adaptador1

                    list1.setOnItemClickListener {
                        adapterView, view, i, l ->
                        val dialogBuilder = AlertDialog.Builder(this)
                        // set message of alert dialog
                        dialogBuilder.setMessage(usuarios[i])
                                // if the dialog is cancelable
                                .setCancelable(false)
                                // positive button text and action
                                .setPositiveButton("OK", DialogInterface.OnClickListener {
                                    dialog, id -> finish()
                                })
                        // create dialog box
                        val alert = dialogBuilder.create()
                        // set title for alert dialog box
                        //alert.setTitle("Registro de usuarios")
                        // show alert dialog
                        alert.show()
                    }
                },
                Response.ErrorListener {
                    Alerta("Red","Problemas con el Internet")
                })
        queue.add(stringReq)
    }
    fun Alerta(Titulo:String, Mensaje:String)
    {
        val dialogBuilder = AlertDialog.Builder(this)
        // set message of alert dialog
        dialogBuilder.setMessage(Mensaje)
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("OK", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
                })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle(Titulo)
        // show alert dialog
        alert.show()
    }
}