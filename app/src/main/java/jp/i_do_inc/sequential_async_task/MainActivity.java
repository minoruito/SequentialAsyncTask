package jp.i_do_inc.sequential_async_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String  TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "ボタンクリックを検知");

                final AsyncTaskClass1 atClass1 = new AsyncTaskClass1();
                final AsyncTaskClass2 atClass2 = new AsyncTaskClass2();

                atClass1.setOnCallBack(new AsyncTaskClass1.CallBackTask(){
                    @Override
                    public void CallBack(Integer result1) {
                        super.CallBack(result1);
                        Log.i(TAG, "非同期処理1が終了しました。");

                        // AsyncTaskの実行
                        atClass2.execute(result1);

                    }
                });

                // AsyncTaskの実行
                atClass1.execute(1);

                atClass2.setOnCallBack(new AsyncTaskClass2.CallBackTask(){

                    @Override
                    public void CallBack(Integer result2) {
                        super.CallBack(result2);
                        Log.i(TAG, "result: " + result2);
                        Log.i(TAG, "非同期処理2が終了しました。");
                    }
                });

            }
        });
    }
}
