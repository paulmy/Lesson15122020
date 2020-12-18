package ru.myitschool.lesson15122020;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView nameperson, paramperson, storyperson;
    Button[] btngame = new Button[3];
   //

    public static Character manager;
    public static Story story;
    public static int curent=1;
    String name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        nameperson = findViewById(R.id.nameperson);
        paramperson = findViewById(R.id.paramperson);
        storyperson = findViewById(R.id.storyperson);
        btngame[0] = findViewById(R.id.btngame1);
        btngame[1] = findViewById(R.id.btngame2);
        btngame[2] = findViewById(R.id.btngame3);

         name2= getIntent().getStringExtra("personname");
        game();
    }


    public void game() {
        //Scanner in = new Scanner(System.in);

        storyperson.setText("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \n "
                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):");
        manager = new Character(name2);
        nameperson.setText(name2);
        story = new Story();
        while (true) {
            manager.A += story.current_situation.dA;
            manager.K += story.current_situation.dK;
            manager.R += story.current_situation.dR;
            paramperson.setText("=====\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n=====");
            storyperson.setText("============="
                    + story.current_situation.subject + "==============");
            storyperson.append(story.current_situation.text);
            if (story.isEnd()) {
                storyperson.setText("====================the end!===================");
                return;
            }
            story.go(curent);

        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btngame1:curent=1;break;
            case R.id.btngame2:curent=2;break;
            case R.id.btngame3:curent=3;break;




        }
    }
}