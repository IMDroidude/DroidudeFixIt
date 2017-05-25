package droidudes.fix.it;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Zare Ahmed on 5/25/2017.
 */
public class TasbihView extends View {
    private int speed;
    private Paint tasbehPaint;

    public TasbihView(Context context) {
        super(context);
        init();
    }

    public TasbihView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TasbihView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /*public TasbihView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/

    private void init(){
        //TypedArray typedArray = R.d;

        tasbehPaint = new Paint();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


        canvas.translate(getWidth()/2,getHeight()/2);

        canvas.drawCircle(20,20,100,tasbehPaint);

    }
}
