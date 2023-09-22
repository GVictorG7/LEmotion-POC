package ro.lemotion.ui.register;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import ro.lemotion.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("LEmotion new user registration");

        ActivityRegisterBinding binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
