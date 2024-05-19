package sg.edu.np.mad.madpractical4;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView description;
    private ImageView smallImage;
    private ImageView bigImage;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textName);
        description = itemView.findViewById(R.id.textDescription);
        smallImage = itemView.findViewById(R.id.imageSmall);
        bigImage = itemView.findViewById(R.id.imageBig);

        smallImage.setOnClickListener(v -> {
            showAlertDialog();
        });
    }

    public void bind(User user) {
        name.setText(user.name);
        description.setText(user.description);
        smallImage.setImageResource(R.mipmap.ic_launcher);
        bigImage.setImageResource(R.mipmap.ic_launcher);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
        builder.setTitle("Profile");
        builder.setMessage("MADness");

        builder.setNegativeButton("Close", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.setPositiveButton("View", (dialog, which) -> {
            int randomInteger = new Random().nextInt(1000000);

            Intent intent = new Intent(itemView.getContext(), MainActivity.class);
            intent.putExtra("randomInteger", randomInteger);
            itemView.getContext().startActivity(intent);
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
