package projects.femmehacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Bundle goals = getIntent().getExtras(); //Gets the goals text from Alarm
        String goalTxt = goals.getString("goals");

        TextView textView = findViewById(R.id.endMessage);
        textView.setText("Hooray! You are ready for " + goalTxt + "!");
    }

}
