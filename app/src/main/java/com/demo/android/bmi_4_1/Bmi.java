package com.demo.android.bmi_4_1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Bmi extends AppCompatActivity implements View.OnClickListener {

    EditText field_height;
    EditText field_weight;
    TextView result;
    TextView suggest;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
        setMyListener();

    }

    private void findViews() { //導向物件欄位位置，注意名稱一定要相同
        submit = findViewById(R.id.submit);
        field_height = findViewById(R.id.field_height);
        field_weight = findViewById(R.id.field_weight);
        result = findViewById(R.id.result);
        suggest = findViewById(R.id.suggest);
    }

    private void setMyListener() {
        submit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.00");

        double height = Double.parseDouble(field_height.getText().toString()) / 100;
        double weight = Double.parseDouble(field_weight.getText().toString());
        double BMI = weight / (height * height);

        TextView result = findViewById(R.id.result);
        result.setText("你的BMI值 = " + df.format(BMI));
        TextView suggest = findViewById(R.id.suggest);

        if (BMI > 25)
            suggest.setText(R.string.advice_heavy);
        else if (BMI < 20)
            suggest.setText(R.string.advice_light);
        else
            suggest.setText(R.string.advice_average);
        openOptionsDialog();

    }

    void openOptionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Android BMI");
        builder.setMessage("Android BMI Calculator");
        builder.setPositiveButton("確認", dialogListener);
        builder.setNegativeButton("取消", dialogListener);
        builder.setNeutralButton("其他", dialogListener);
        builder.show();

    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    System.out.println("已下確認鍵了");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    System.out.println("已下取消鍵了");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    System.out.println("已下其他鍵");

            }

    /*};
    DialogInterface.OnClickListener dialogListener1=new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            System.out.println("已下取消鍵了");        }
    };
    DialogInterface.OnClickListener dialogListener2=new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            System.out.println("已下其他鍵了");        */
        }
    };


}


