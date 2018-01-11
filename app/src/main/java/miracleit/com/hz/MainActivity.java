package miracleit.com.hz;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import miracleit.com.hz.model.User;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "my";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);


        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setName("Alex");
        user.setAge(24);
        user.setSex(1);
        realm.insert(user);
        realm.commitTransaction();

        Log.d(LOG_TAG, "MainActivity :  " + user.getName() + " created");

        RealmResults<User> users = realm.where(User.class).findAll();
        for (User elem : users) {
            Log.d(LOG_TAG, "MainActivity :" + elem);
        }

        Log.d(LOG_TAG, "MainActivity : users printed ");

        realm.beginTransaction();
        realm.delete(User.class);
        realm.commitTransaction();

        Log.d(LOG_TAG, "MainActivity : user deleted ");

        RealmResults<User> usersAfter = realm.where(User.class).findAll();
        for (User elem : usersAfter) {
            Log.d(LOG_TAG, "MainActivity :" + elem);
        }

        Log.d(LOG_TAG, "MainActivity : users printed ");
    }

    public void some(View view) {
        Snackbar.make(view, "fdsefew", Snackbar.LENGTH_LONG).show();
    }
}
