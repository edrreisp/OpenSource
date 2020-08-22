package android.example.opensource;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private Button button_read_sensor;
    private TextView textView_SensorResult;
    private CheckBox checkbox_fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();

        // Enables Always-on
        setAmbientEnabled();
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    int celcius;
    double fahrenheit;
    void bindUI(){
        button_read_sensor=(Button) findViewById(R.id.button_read_sensor);
        textView_SensorResult=(TextView) findViewById(R.id.textView_SensorResult);
        checkbox_fahrenheit=(CheckBox) findViewById(R.id.checkbox_fahrenheit);

        button_read_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celcius = getRandomNumber(34,40);
                fahrenheit = (celcius * 1.8) + 32;
                if(checkbox_fahrenheit.isChecked()){
                    textView_SensorResult.setText(fahrenheit + "°F");
                }else{
                    textView_SensorResult.setText(celcius + "°C");
                }
            }
        });

        checkbox_fahrenheit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textView_SensorResult.setText(fahrenheit + "°F");
                }else{
                    textView_SensorResult.setText(celcius + "°C");
                }
            }
        });
    }
}
