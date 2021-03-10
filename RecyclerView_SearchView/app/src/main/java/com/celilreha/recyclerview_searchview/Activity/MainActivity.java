package com.celilreha.recyclerview_searchview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.celilreha.recyclerview_searchview.Adapter.UlkeAdapter;
import com.celilreha.recyclerview_searchview.Model.Ulke;
import com.celilreha.recyclerview_searchview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    RecyclerView recyclerView;
    UlkeAdapter adapter;
    List<Ulke> ulkeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ulkeler = new ArrayList<>();
        //String ulkeAdi, String ulkeResimUrl, String telefonKodu, String ulkeBaskent, int kurulusYili
        ulkeler.add(new Ulke("Spain","flag_spain","+34","Madrid",1469));
        ulkeler.add(new Ulke("Greece","flag_greece","+30","Atina",1821));
        ulkeler.add(new Ulke("Türkiye","flag_turkey","+90","Ankara",1923));
        ulkeler.add(new Ulke("Egypt","flag_egypt","+20","Kahire",3150));
        ulkeler.add(new Ulke("Algeria","flag_algeria","+213","Cezayir",1515));
        ulkeler.add(new Ulke("Norway","flag_norway","+47","Oslo",872));
        ulkeler.add(new Ulke("Liberia","flag_liberia","+231","Monrovia",1822));
        ulkeler.add(new Ulke("South Korea","flag_south_korea","+82","Seul",1948));

        adapter = new UlkeAdapter(ulkeler,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //Toast.makeText(getApplicationContext(),query,Toast.LENGTH_LONG).show();
        adapter.getFilter().filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}
