package com.example.myapplicationofsocialpersonpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Person persons[] = new Person[]
            {
            new Person("Дмитро","Коваленко",30, "Україна", "Київ", "pers1.JPG"),
                    new Person("Ірина","Велика",25, "Україна", "Львів", "pers2.JPG"),
                    new Person("Юлія","Федишина",29, "Україна", "Харків", "pers3.JPG"),
            };
    ListView listView ;
    int number=-1;
    View curentview=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView  = findViewById(R.id.ListView);
        AssetManager assetManager = this.getAssets();

        ArrayAdapter<Person> arrayAdapter =  new ArrayAdapter<Person>(this, R.layout.my_person_list,R.id.lastName, persons)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent )
            {

                View view = super.getView( position, convertView, parent );
                Person person = this.getItem(position);

                TextView firstName = view.findViewById(R.id.firstName);
                TextView lastName = view.findViewById(R.id.lastName);
                TextView age = view.findViewById(R.id.age);
                TextView country = view.findViewById(R.id.country);
                TextView city = view.findViewById(R.id.city);

                ImageView imageView = view.findViewById(R.id.imageView);
                Bitmap bmp=null;
                InputStream IS = null;
                try {
                    IS = assetManager.open(person.fileName);
                    bmp = BitmapFactory.decodeStream(IS);
                    IS.close();
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                imageView.setImageBitmap(bmp);

                firstName.setText(person.firstName);
                lastName.setText(person.lastName);
                age.setText(person.age+ " років");
                country.setText(person.country);
                city.setText(person.city);

                return view;
            }
        };

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(MainActivity.this.number!=-1)
                {
                    MainActivity.this.curentview.setBackgroundColor(Color.rgb(222,132,143));
                }
                MainActivity.this.number=i;
                MainActivity.this.curentview=view;

                MainActivity.this.curentview.setBackgroundColor(Color.rgb(122,172,143));
            }
        });

    }
}