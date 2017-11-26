package pl.devone.android.broadcastpublisher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etMessage = findViewById(R.id.et_msg);

        Button btnBroadcast = findViewById(R.id.btn_broadcast);
        btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();

                if (!TextUtils.isEmpty(msg)) {
                    Intent intent = new Intent();
                    intent.setAction(this.getClass().getPackage().getName() + "." + getString(R.string.simple_broadcast));
                    intent.putExtra("msg", msg);
                    sendBroadcast(intent);

                    etMessage.setText(R.string.empty_string);
                    etMessage.clearFocus();

                    Snackbar.make(findViewById(R.id.rl_main_act), R.string.message_sent, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
