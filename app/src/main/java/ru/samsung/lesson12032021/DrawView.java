package ru.samsung.lesson12032021;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLUE);
       // paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.f);
    }

    int w, h;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.h = h;
        this.w = w;
    }

    Paint paint = new Paint();

    static long nFib(int n) {
        if (n == 0 || n == 1)
            return 1;// Условие завершения рекурсии – «заглушка»
        return nFib(n - 1) + nFib(n - 2);//возвращаем сумму предыдущих чисел
    }

    void onDrawCircle(Canvas canvas, int x, int y, int r, int N) {
        switch (N){
            case 1:paint.setColor(Color.RED);break;
            case 2:paint.setColor(Color.GREEN);break;
            case 3:paint.setColor(Color.YELLOW);break;
            case 4:paint.setColor(Color.BLUE);break;


        }
        canvas.drawCircle(x, y, r, paint);

        if (N > 1) {

            onDrawCircle(canvas, x - r, y, r / 2, N - 1);
            onDrawCircle(canvas, x + r, y, r / 2, N - 1);
            onDrawCircle(canvas, x, y - r, r / 2, N - 1);
            onDrawCircle(canvas, x, y + r, r / 2, N - 1);

        }


    }

    @Override
    protected void onDraw(Canvas canvas) {

        onDrawCircle(canvas, canvas.getWidth() / 2, canvas.getHeight() / 2, 500, 5);
        paint.setTextSize(100);
        canvas.drawText("" + nFib(10), 10, 100, paint);
    }
}
