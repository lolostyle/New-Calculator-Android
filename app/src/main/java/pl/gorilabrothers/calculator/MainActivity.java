package pl.gorilabrothers.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText field;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultime;
    private Button buttonDivide;

    private Button buttonEquals;
    private Button buttonDelete;

    private boolean empty;
    private boolean new_operation = true;
    private boolean ochist;

    private double a;
    private double b;

    private double first_value;
    private double second_value;
    private String operation;

    private ArrayList<String> object = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field = (EditText) findViewById(R.id.editText);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);


        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultime = (Button) findViewById(R.id.buttonMultime);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);


        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (field.getText().length() == 0) {
                    empty();
                } else {
                    field.getText().delete(field.getText().length()-1, field.getText().length());
                }
            }
        });

        buttonDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                empty();
                return true;
            }
        });


    }

    public void onClick(View view) {

        switch (view.) {

            case buttonPlus:

                field.setText("5785950");

//                if (new_operation) {
//                    first_value = getDouble(field.getText().toString());
//                    operation = "plus";
//                    new_operation = false;
//                    ochist = true;
//                } else if (!new_operation) {
//                    second_value = getDouble(field.getText().toString());
//                    calc();
//                    first_value = getDouble(field.getText().toString());
//                    operation = "plus";
//                    new_operation = false;
//                    ochist = true;
//                }


            default:

                if (field.getText().toString().equals("0")) {
                    field.setText(view.getContentDescription().toString());
                    ochist = false;
                } else {
                    field.setText(field.getText().toString()
                            + view.getContentDescription().toString());
                }
        }
    }

    private void empty() {
        field.setText("0");
        empty = true;
    }

    private double doCalc(double a, double b, String o) {
        double c = 0;

        switch (o) {
            case "plus":
                c = a + b;
                break;

            case "minus":
                c = a - b;
                break;

            case "multime":
                c = a * b;
                break;

            case "divide":
                if (b == 0) {
                    Toast.makeText(getApplicationContext(), "You cann't divide on zero", Toast.LENGTH_SHORT).show();
                } else {
                    c = a / b;
                }
                break;
        }
        return c;
    }

    private void calc () {
        double result = 0;

        result = doCalc(first_value,
                second_value, operation);

        if (result % 1 == 0) {
            field.setText(String.valueOf((int)result));
        } else {
            field.setText(String.valueOf(result));
        }


    }

    private double getDouble (Object value) {
        double result = 0;
        try {
            result = Double.valueOf(value.toString().replace(',', '.')).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }

        return result;

    }
}
