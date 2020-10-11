package com.example.hxchat.app.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Jenly
 */
public class ToastUtils {

    private static Toast toast;

    private ToastUtils(){
        throw new AssertionError();
    }

    public static void showToast(Context context,int resId){
        showToast(context,context.getResources().getString(resId));
    }

    public static void showToast(Context context,int resId,int duration){
        showToast(context,context.getResources().getString(resId),duration);
    }

    public static void showToast(Context context,CharSequence text){
        showToast(context,text,Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context,String text,int duration,Object...args){
        showToast(context,String.format(text,args),duration);
    }

    public static void showToast(Context context,CharSequence text,int duration){

        if(toast == null){
            synchronized (ToastUtils.class){
                if(toast == null){
                    toast = Toast.makeText(context,text,duration);
                }
            }
        }else{
            toast.setText(text);
            toast.setDuration(duration);
        }
        toast.show();
    }
}
