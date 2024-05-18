package sg.edu.np.mad.madpractical4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private List<User> userList;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        userList = generateRandomUsers(20);

        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userList = generateRandomUsers(20);
    }

    private List<User> generateRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String name = "User " + (i + 1);
            String description = "Description " + (i + 1);
            int id = i;
            boolean followed = random.nextBoolean();

            User user = new User(name, description, id, followed);
            users.add(user);
        }

        return users;
    }
}