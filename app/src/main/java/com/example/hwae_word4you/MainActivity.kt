package com.example.hwae_word4you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.hwae_word4you.model.Question
import com.example.hwae_word4you.retrofit.QuestionApi
import com.example.hwae_word4you.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val dialogBtn: Button = findViewById(R.id.dialog_btn)
        dialogBtn.setOnClickListener{
        showDialog()
        }

        initializeComponents();

    }

    private fun initializeComponents(){
        val inputEditText = findViewById<EditText>(R.id.edit_question);
        val buttonSave = findViewById<Button>(R.id.dialog_btn)
//        val inputEditText = findViewById(R.id.edit_question) as EditText;

        val retrofitService: RetrofitService = RetrofitService();
        val questionApi: QuestionApi = retrofitService.retrofit.create(QuestionApi::class.java);
//            retrofitService.getRetrofit().create(QuestionApi.class);

        buttonSave.setOnClickListener(
            View.OnClickListener{
//            val questionInput = inputEditText.text.toString()
//            String question = String.valueOf(inputEditText.text());
//            String question = String.valueOf(inputEditText.text)


                val question: Question = Question();
                question.setQuestion_content("hi");
                question.setMember_id("1");

            questionApi.save(question)
                .enqueue(object : Callback<Question>{

                    override fun onResponse(call: Call<Question>, response: Response<Question>) {
                        Log.d("질문 저장 성공:", "${response.raw()}")
                    }

                    override fun onFailure(call: Call<Question>, t: Throwable) {
                        Log.d("질문 저장 실패:", "$t")
                    }

                });

        });
    }








    private fun showDialog(){

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setTitle("로그인")

        val inflater: LayoutInflater = layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_dialog, null))

            builder.setPositiveButton("OK") { p0, p1 ->
            }

            builder.setNegativeButton("CANCEL"){
                dialog, p1 -> dialog.cancel()
            }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}