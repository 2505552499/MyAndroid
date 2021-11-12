package com.example.bookexperiment.litepalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        Button createDatabass = (Button) findViewById(R.id.create_database);
        createDatabass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
            }
        });
        //增加数据
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setAge(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
            }
        });
        //修改数据
        Button updateDate = (Button) findViewById(R.id.update_data);
        updateDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Book book = new Book();
                book.setName("The Lost Symbol");
                book.setAuthor("Dan Brown");
                book.setAge(510);
                book.setPrice(19.95);
                book.setPress("Unknow");
                book.save();
                book.setPrice(10.99);
                book.save();*/
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?", "The Da Vinci Code", "Dan Brown");
                /*book.setToDefault("pages");
                book.updateAll();*/
            }
        });
        //删除数据
        Button deleteButton = (Button) findViewById(R.id.delite_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class, "price < ?", "15");
            }
        });
        //查询数据
        Button query_data = (Button) findViewById(R.id.query_data);
        query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books = DataSupport.findAll(Book.class);
                //findFitst();
                //findLast();
                //DataSupport.select("name", "author").find(Book.class);
                //DataSupport.where("pages > ? ", "400").find(Book.class);
                //DataSupport.order("price desc").find(Book.class);
                //DataSupport.limit(3).find(Book.class);//限制查询行数
                //DataSupport.limit(3).offset(1).find(Book.class);//制定偏移量
//                List<Book> books = DataSupport.select("name", "author", "age").where("age > ?", "400")
//                        .order("pages").limit(10).offset(10).find(Book.class);
                for (Book book : books) {
                    Log.d("MainActivity", "book name is " + book.getName());
                    Log.d("MainActivity", "book author is " + book.getAuthor());
                    Log.d("MainActivity", "book pages is " + book.getAge());
                    Log.d("MainActivity", "book price is " + book.getPrice());
                    Log.d("MainActivity", "book press is " + book.getPress());


                }
            }
        });
    }
}