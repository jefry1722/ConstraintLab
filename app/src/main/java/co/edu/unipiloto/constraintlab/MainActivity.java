package co.edu.unipiloto.constraintlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etTo,etSubject,etMessage;
    private Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTo=(EditText)findViewById(R.id.email_address);
        etSubject=(EditText)findViewById(R.id.subject_text);
        etMessage=(EditText)findViewById(R.id.message_text);
        btSend=(Button)findViewById(R.id.button);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+etTo.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                startActivity(intent);
            }
        });
    }
}