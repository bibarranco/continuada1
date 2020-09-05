package com.example.appbianca

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(componente: View) {

        //Quantidade de óbitos nos últimos 7 dias dividido pela quantidade de óbitos nos 7 dias anteriores
        //Acima de 2,0: Fase 1- alerta máximo
        //Entre 1,0 e 2,0: Fase 2- controle
        //Entre 0,5 e 1,0: Fase 3- flexibilização
        //Abaixo de 0,5: Fase 4- abertura parcial

        val ultimos = et_ultimos.text.toString().toInt()
        val anteriores = et_anteriores.text.toString().toInt()

        val classificacao = ultimos / anteriores

        if (classificacao > 2.0) {
            tv_secreto.visibility = View.VISIBLE
            tv_secreto.text = "A classificação do Estado de ${et_estado.text} é de alerta máximo"
            tv_secreto.setTextColor(Color.RED)

        } else if (classificacao >= 1.0 && classificacao <= 2.0) {
            tv_secreto.visibility = View.VISIBLE
            tv_secreto.text = "A classificação do Estado de ${et_estado.text} é de controle"
            tv_secreto.setTextColor(Color.parseColor("#FFA500"))

        } else if (classificacao >= 0.5 && classificacao < 1.0) {
            tv_secreto.visibility = View.VISIBLE
            tv_secreto.text = "A classificação do Estado de ${et_estado.text} é de flexibilização"
            tv_secreto.setTextColor(Color.YELLOW)

        } else {
            tv_secreto.visibility = View.VISIBLE
            tv_secreto.text = "A classificação do Estado de ${et_estado.text} é de abertura parcial"
            tv_secreto.setTextColor(Color.GREEN)

        }

    }
}