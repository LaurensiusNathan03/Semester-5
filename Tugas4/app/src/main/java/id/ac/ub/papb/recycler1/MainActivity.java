package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    public static String TAG = "RV1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.rv1);
        ArrayList<Mahasiswa> data = getData();
        MahasiswaAdapter adapter = new MahasiswaAdapter(this, data);
        rv1.setAdapter(adapter);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        Button btnSimpan = findViewById(R.id.bt1);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etNim = findViewById(R.id.etNim);
                EditText etNama = findViewById(R.id.editTextTextPersonName2);
                String nim = etNim.getText().toString();
                String nama = etNama.getText().toString();

                // Create a new Mahasiswa object
                Mahasiswa mhs = new Mahasiswa();
                mhs.nim = nim;
                mhs.nama = nama;

                // Add the new Mahasiswa object to the data ArrayList
                data.add(0,mhs);

                // Notify the adapter about the data change
                adapter.notifyDataSetChanged();
            }
        });
    }

    public ArrayList getData() {
        ArrayList<Mahasiswa> data = new ArrayList<>();
        List<String> nim = Arrays.asList(getResources().getStringArray(R.array.nim));
        List<String> nama = Arrays.asList(getResources().getStringArray(R.array.nama));
        for (int i = 0; i < nim.size(); i++) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.nim = nim.get(i);
            mhs.nama = nama.get(i);
            Log.d(TAG,"getData "+mhs.nim);
            data.add(mhs);
        }
        return data;
    }
}
