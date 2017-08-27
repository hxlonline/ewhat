package hxl.cn.com.ewhat.utils;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import hxl.cn.com.ewhat.model.User;

/**
 * Created by hexinglin on 2017/08/25.
 */

public class ResAPI {

    private DatabaseReference mDatabase;

    public ResAPI() {
        super();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }


    public void readFromDatabase(String name,String email){

        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d("qwe", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("qwe", "Failed to read value.", error.toException());
            }
        });

    }


    private void writeNewUser(String userId, User user) {

        mDatabase.child("users").child(userId).setValue(user);
    }

}
