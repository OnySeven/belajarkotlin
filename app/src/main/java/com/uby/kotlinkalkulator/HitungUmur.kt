package com.uby.kotlinkalkulator

import android.graphics.Typeface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType.TYPE_CLASS_NUMBER
import android.view.View
import android.view.View.TEXT_ALIGNMENT_CENTER
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import java.util.*

class HitungUmur : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_umur)
        //todo 1 buat parent view
        verticalLayout {
            //todo 2 membuat edit text untuk tanggal lahir user.
            var birthday = editText {
                hint = "Isikan Umur"
                inputType = TYPE_CLASS_NUMBER
            }.lparams {
                width = matchParent
                height = wrapContent

            }
            //todo 3.membuat parent view untuk textview dan button hasil
            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                //todo 4. membuat textview
                var umurnya = textView {
                    text = "Umurmu Gesss"
                    textSize = 20F
                    typeface = Typeface.DEFAULT_BOLD
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 1F
                }

                //TODO 5. button untuk menghitung umur
                  button {
                    text = "Hitung"
                    textSize = 15F

                    //todo 6. buat action setOnClickListener
                    setOnClickListener {
                        val tahunlahir = birthday.text.toString().toInt()

                        // 7. todo Ambil Tanggal Sekarang , atau tahun sekarang
                        val tahunNow = Calendar.getInstance().get(Calendar.YEAR)
                        // 8. todo Hitung Tahun Sekarang dikurangi Tahun Lahir
                        var hasilumur = tahunNow - tahunlahir

                        //9. todo Menampilkah hasil umur
                        umurnya.text = hasilumur.toString()

                        //10. todo menampilkan info berdasarkan rentang umur
                        when(hasilumur){
                            in 0..14  -> Toast.makeText(this@HitungUmur,"Umurmu dibawah 15 tahun",Toast.LENGTH_LONG).show()
                            in 15..20 -> Toast.makeText(this@HitungUmur,"Umurmu dibawah 21 tahun",Toast.LENGTH_LONG).show()
                            in 21..25 -> Toast.makeText(this@HitungUmur,"Umurmu dibawah 26 tahun",Toast.LENGTH_LONG).show()
                            in 26..30 -> Toast.makeText(this@HitungUmur,"Umurmu dibawah 31 tahun",Toast.LENGTH_LONG).show()
                            in 31..35 -> Toast.makeText(this@HitungUmur,"Umurmu dibawah 36 tahun",Toast.LENGTH_LONG).show()

                        }

                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 1F
                }
            }.lparams {
                padding = 15
            }

        }


    }
}
