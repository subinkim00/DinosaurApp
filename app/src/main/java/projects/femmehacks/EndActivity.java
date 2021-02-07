package projects.femmehacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        String goals = intent.getStringExtra("text");
        TextView textView = findViewById(R.id.endMessage);
        textView.setText("Hooray! You are ready for " + goals + "!");
    }

}
