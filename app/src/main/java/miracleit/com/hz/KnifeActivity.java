package miracleit.com.hz;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import miracleit.com.hz.model.HZ;
import miracleit.com.hz.model.User;

public class KnifeActivity extends AppCompatActivity {

    private DatabaseReference reference;

    @BindView(R.id.txt_email)
    public TextView txtEmail;
    @BindView(R.id.txt_password)
    public TextView txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knife);
        ButterKnife.bind(this);

        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        reference = instance.getReference().child("HZ");

        listener();
    }

    @OnClick(R.id.btn_show)
    public void show(View view) {
        Snackbar.make(view, "Hello", Snackbar.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_ok)
    public void ok() {
        HZ hz = new HZ();
        hz.setEmail(txtEmail.getText().toString());
        hz.setPassword(txtPassword.getText().toString());
        reference.push().setValue(hz);
    }

    /**
     * Listening firebase.
     */
    private void listener() {
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println(dataSnapshot.getValue(HZ.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                System.out.println(dataSnapshot.getValue(HZ.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
