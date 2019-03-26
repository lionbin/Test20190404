package com.sxzy.b.test_app.Test_03;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sxzy.b.test_app.R;

public class Fm_t3_02 extends Fragment {
    private ImageView im;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.itrm_fm_t3_02, null);
        im=view.findViewById(R.id.im_t03);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        im.setOnTouchListener(new TouchListener());
    }
    class TouchListener implements View.OnTouchListener {
        PointF startPointf = new PointF();
        Matrix matrix = new Matrix();
        Matrix currentMatrix = new Matrix();
        private int move;
        private float startDis;
        PointF pointF;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    move = 1;
                    currentMatrix.set(im.getImageMatrix());
                    startPointf.set(event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (move == 1) {
                        matrix.set(currentMatrix);
                        matrix.postTranslate(event.getX() - startPointf.x, event.getY() - startPointf.y);
                    } else if (move == 2) {
                        float endDis=distance(event);
                        if (endDis>10){
                            float scaleSize=endDis/startDis;
                            pointF=midPoint(event);
                            matrix.set(currentMatrix);
                            matrix.postScale(scaleSize,scaleSize,pointF.x,pointF.y);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    move = 0;
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    move = 2;
                    startDis = distance(event);
                    if (startDis > 10) {
                        pointF = midPoint(event);
                        currentMatrix.set(im.getImageMatrix());
                    }
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    move = 0;
                    break;

            }
            im.setImageMatrix(matrix);
            return true;

        }

        private PointF midPoint(MotionEvent event) {
            return new PointF((event.getX(1) + event.getX(0)) / 2,
                    (event.getY(1) + event.getY(0)) / 2);
        }

        private float distance(MotionEvent event) {
            float x = event.getX(1) - event.getX(0);
            float y = event.getY(1) - event.getY(0);
            return (float) Math.sqrt(x * x + y * y);

        }


    }
}
