package th.ac.klanarong.su.ict.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button btnCalculate;
    Button btnClear;
    TextView tvResult;

    RadioGroup rgOperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                editText1 = findViewById(R.id.eDt1);
                editText2 = findViewById(R.id.eDt2);
                btnCalculate = findViewById(R.id.bTn1);
                btnClear = findViewById(R.id.bTn2);
                tvResult = findViewById(R.id.tvShow);
                rgOperator = findViewById(R.id.rgOperator);


                btnCalculate.setOnClickListener(listener);
                btnClear.setOnClickListener(listener);


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v == btnClear) {
                tvResult.setText("0");
                editText1.setText("");
                editText2.setText("");
            }

            if(v == btnCalculate) {
                int v1 = Integer.parseInt(editText1.getText().toString());
                int v2 = Integer.parseInt(editText2.getText().toString());
                int result = v1+v2;

//                if (rgOperator.isChecked()){
//                    result = v1+v2;
//                }

                switch (rgOperator.getCheckedRadioButtonId()){
                    case R.id.rbPlus:
                        result = v1+v2;
                        break;

                    case R.id.rbMinus:
                        result = v1-v2;
                        break;

                    case R.id.rbMultiply:
                        result = v1*v2;
                        break;

                    case R.id.rbDivide:
                        result = v1/v2;
                        break;
                }

//                Log.d("calculation","result = "+result);
//                        Toast.makeText(MainActivity.this,
//                                "result"+result,Toast.LENGTH_LONG).show();

                        tvResult.setText(" = "+result);
            }

        }
    };
}
