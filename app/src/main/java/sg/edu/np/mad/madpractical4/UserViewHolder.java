package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageSmall;
    private TextView textName;
    private TextView textDescription;
    private ImageView imageBig;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        imageSmall = itemView.findViewById(R.id.imageSmall);
        textName = itemView.findViewById(R.id.textName);
        textDescription = itemView.findViewById(R.id.textDescription);
        imageBig = itemView.findViewById(R.id.imageBig);
    }

    public void bind(User user) {
        textName.setText(user.name);
        textDescription.setText(user.description);
        imageSmall.setImageResource(R.mipmap.ic_launcher);
        imageBig.setImageResource(R.mipmap.ic_launcher);
    }
}
