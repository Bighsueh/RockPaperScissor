package tw.edu.nfu.gm.hsueh.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnPaper, btnScissor, btnStone;
    private TextView text_result,text_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_record = (TextView) findViewById(R.id.text_record);
        text_result = (TextView) findViewById(R.id.text_result);
        btnPaper = (Button) findViewById(R.id.btn_paper);
        btnScissor = (Button) findViewById(R.id.btn_scissor);
        btnStone = (Button) findViewById(R.id.btn_stone);

        btnPaper.setOnClickListener(myListener);
        btnScissor.setOnClickListener(myListener);
        btnStone.setOnClickListener(myListener);
        Log.d("out","");

    }

    private final Button.OnClickListener myListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = text_record.getText().toString();
            String r = "";

            int num = (int) (Math.random() * 3);
//            0->剪刀
//            1->石頭
//            2->布

            switch (view.getId()) {
                case R.id.btn_paper:{
                    if (num == 0) {
                        r = "電腦出 剪刀,玩家出 布   ,電腦贏";
                    } else if (num == 1) {
                        r = "電腦出 石頭,玩家出 布   ,玩家贏";
                    } else if (num == 2) {
                        r = "電腦出 布  ,玩家出 布   ,沒人贏";
                    }
                    break;
                }
                case R.id.btn_scissor:{
                    if (num == 0) {
                        r = "電腦出 剪刀,玩家出 剪刀 ,沒人贏";
                    } else if (num == 1) {
                        r = "電腦出 石頭,玩家出 剪刀 ,電腦贏";
                    } else if (num == 2) {
                        r = "電腦出 布  ,玩家出 剪刀 ,贏";
                    }
                    break;
                }
                case R.id.btn_stone:{
                    if (num == 0) {
                        r = "電腦出 剪刀,玩家出 石頭 ,玩家贏";
                    } else if (num == 1) {
                        r = "電腦出 石頭,玩家出 石頭 ,沒人贏";
                    } else if (num == 2) {
                        r = "電腦出 布  ,玩家出 石頭 ,電腦贏";
                    }
                    break;
                }

            }
            s = s + "\n "+ r;
            text_record.setText(s);
            text_result.setText(r);
        }
    };
}