package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        User user = new User("Zane", "MAD Developer", 1, false);

        TextView tvName = findViewById(R.id.textView);
        TextView tvDescription = findViewById(R.id.textView2);
        Button btnFollow = findViewById(R.id.button2);
        Button btnMessage = findViewById(R.id.button3);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        btnFollow.setOnClickListener(v -> {
            user.followed = !user.followed;
            updateFollowButton(btnFollow, user.followed);
            if (user.followed) {
                showToast ("Followed");
            } else {
                showToast ("Unfollowed");
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int randomInteger = extras.getInt("randomInteger", 0);

            tvName.setText(user.name + " " + randomInteger);
        }

        btnMessage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void updateFollowButton(Button btnFollow, boolean followed) {
        if (followed) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}