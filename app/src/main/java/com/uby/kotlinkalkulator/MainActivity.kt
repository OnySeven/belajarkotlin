package com.uby.kotlinkalkulator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnClickListener {

    var n1 = 0.0f
    var n2 = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)



        btnAdd.setOnClickListener {
           if(validasi()) operator("+")
            else Toast.makeText(this,"Harus di isi",Toast.LENGTH_SHORT).show()
        }

        btnKurang.setOnClickListener {
            if(validasi()) operator("-")
            else Toast.makeText(this,"Harus di isi",Toast.LENGTH_SHORT).show()
        }

        btnBagi.setOnClickListener {
            if(validasi()) operator("/")
            else Toast.makeText(this,"Harus di isi",Toast.LENGTH_SHORT).show()

        }

        btnKali.setOnClickListener {
            if(validasi()) operator("*")
            else Toast.makeText(this,"Harus di isi",Toast.LENGTH_SHORT).show()

        }

        cleardata.setOnClickListener { clear() }
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun realmconfiguration(){

      //  Realm
    }

    private fun operator(s:String){
        n1 = firstvalue.text.toString().toFloat()
        n2 = secondvalue.text.toString().toFloat()
        when(s){
            "+" -> tambah(n1,n2)
            "-" -> kurang(n1,n2)
            "*" -> kali(n1,n2)
            "/" -> bagi(n1,n2)
        }
    }

    private fun validasi():Boolean{
        val nilai1 = firstvalue.text.toString()
        var nilai2 = secondvalue.text.toString()

        return !(nilai1.isEmpty() || nilai2.isEmpty())
    }
    private fun clear(){
        val nilai1 = firstvalue.setText("")
        val nilai2 = secondvalue.setText("")
        return nilai1

    }

    private fun bagi(nn1:Float,nn2:Float){
        if(!validasi()){
            Toast.makeText(this,"Harus diisi",Toast.LENGTH_SHORT).show()

        }else{
            //val hasilhitung = firstvalue.text.toString().toDouble() / secondvalue.text.toString().toDouble()
            val hasilhitung = nn1/nn2
            hasil.text = hasilhitung.toString();
        }
    }
    private fun kali(nn1:Float,nn2:Float){
        if(!validasi()){
            Toast.makeText(this,"Harus diisi",Toast.LENGTH_SHORT).show()

        }else{
            //val hasilhitung = firstvalue.text.toString().toDouble() * secondvalue.text.toString().toDouble()
            val hasilhitung = nn1*nn2
            hasil.text = hasilhitung.toString()
        }
    }

    private fun tambah(nn1:Float,nn2:Float){
        if(!validasi()){
            Toast.makeText(this,"Harus diisi",Toast.LENGTH_SHORT).show()

        }else{
            Log.d("firstvalue",firstvalue.toString().trim())

            //val hasilhitung =  firstvalue.text.toString().toDouble() + secondvalue.text.toString().toDouble()
            val hasilhitung = nn1+nn2
            hasil.text = hasilhitung.toString()
        }
    }


    private fun kurang(nn1:Float,nn2:Float){
        if(!validasi()){
            Toast.makeText(this,"Harus diisi",Toast.LENGTH_SHORT).show()

        }else{
            //val hasilhitung = firstvalue.text.toString().toDouble() - secondvalue.text.toString().toDouble()
            val hasilhitung = nn1-nn2
            hasil.text = hasilhitung.toString()
        }
    }
}
