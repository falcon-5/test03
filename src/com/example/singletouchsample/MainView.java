package com.example.singletouchsample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainView extends View {
	//タッチイベントの状態
	private String touchState;

	//タッチイベントのX,Y座標値
	private int touchX, touchY;

	//コンストラクタ
	public MainView(Context context)
	{
		super(context);

		//メンバを初期化
		touchState = "";
		touchX = 0;
		touchY = 0;

		//背景色を白色にセット
		setBackgroundColor(Color.rgb(255, 255, 255));
	}

	//描画のためにシステムから呼び出される
	protected void onDraw(Canvas canvas)
	{
		//描画オブジェクトの生成
		Paint p = new Paint();

		//アンチエイリアスを有効に
		p.setAntiAlias(true);

		//文字サイズをセット
		p.setTextSize(32.0f);

		//文字色を黒色にセット
		p.setColor(Color.rgb(0, 0, 0));

		//文字列を描画
		canvas.drawText("TouchState:" + touchState, 8,40,p);
		canvas.drawText("(" + touchX + "," + touchY + ")", 8,80,p);
	}

	//座標値をセット
	public void setTouchXY(int x, int y)
	{
		touchX = x;
		touchY = y;
	}

	//タッチ状態を表す文字列をセット
	public void setTouchState(String state)
	{
		touchState = state;
	}
}
