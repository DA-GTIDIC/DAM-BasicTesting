package cat.udl.tidic.amd.dam_basictesting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class LoginActivity extends AppCompatActivity {


    private EditText password;
    private TextView errorMsg;
    private LoginUtils loginUtils;
    private Button fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = findViewById(R.id.editTest_username);
        password = findViewById(R.id.editText_pass);
        errorMsg = findViewById(R.id.errorMessage);
        fragment = findViewById(R.id.firstFragment);
        loginUtils = new LoginUtils();
        Button login = findViewById(R.id.button_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = password.getText().toString();
                String user = username.getText().toString();
                if (!loginUtils.isValidPassword(pass)){
                    errorMsg.setText("Bad password");
                    errorMsg.setVisibility(View.VISIBLE);
                }else{
                   // do sth
                }
            }
        });

        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SimpleFragment());
            }

        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }

}
