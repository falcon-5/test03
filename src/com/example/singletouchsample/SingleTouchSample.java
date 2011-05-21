package com.example.singletouchsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class SingleTouchSample extends Activity {

	private MainView mainView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //MainViewのインスタンスを生成
        mainView = new MainView(this);

        //Viewオブジェクトとして、MainViewのインスタンスをセット
        //レイアウトのリソース参照は渡さず直接Viewオブジェクトを渡している
//      setContentView(R.layout.main);
        setContentView(mainView);
    }

    //タッチイベント発生時に呼び出される
    public boolean onTouchEvent(MotionEvent event)
    {
    	//タッチ座標を取得
    	int x = (int)event.getX();
    	int y = (int)event.getY();

    	//MainViewにタッチイベントをセット
    	mainView.setTouchXY(x, y);

    	//イベントの種類で条件分岐し、MainViewにイベントの種類をセット
    	switch(event.getAction())
    	{
	    	//タッチされた瞬間を表すイベント
	    	case MotionEvent.ACTION_DOWN:
	    		mainView.setTouchState("Down");
	    		break;

	    	//指が離された瞬間を表すイベント
	    	case MotionEvent.ACTION_UP:
	    		mainView.setTouchState("Up");
	    		break;

	    	//タッチされた指がスライドされたことを表すイベント
	    	case MotionEvent.ACTION_MOVE:
	    		mainView.setTouchState("Move");
	    		break;
    	}

    	//MainViewの再描画を行う
    	mainView.invalidate();

    	return true;
    }
}