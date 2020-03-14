package com.mustafayigit.mycustomtoast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

import com.mustafayigit.mycustomtoastmessage.R;

public class MYToast extends Toast {

    public static final int CUSTOM_TYPE_INFO = 0;
    public static final int CUSTOM_TYPE_WARNING = 1;
    public static final int CUSTOM_TYPE_SUCCESS = 2;
    public static final int CUSTOM_TYPE_ERROR = 3;

    public static final int CUSTOM_GRAVITY_TOP = 0;
    public static final int CUSTOM_GRAVITY_CENTER = 1;
    public static final int CUSTOM_GRAVITY_BOTTOM = 2;

    public static int CUSTOM_DURATION_SHORT = Toast.LENGTH_SHORT;
    public static int CUSTOM_DURATION_LONG = Toast.LENGTH_LONG;

    private Context mContext;
    private View mView;
    private int mType;

    public MYToast(Context context) {
        super(context);
        this.mContext = context;
    }

    public static MYToast makeToast(Context context, String message) {
        return makeToast(context, message, CUSTOM_DURATION_SHORT, CUSTOM_TYPE_INFO, CUSTOM_GRAVITY_BOTTOM);
    }

    public static MYToast makeToast(Context context, String message, int duration) {
        return makeToast(context, message, duration);
    }

    public static MYToast makeToast(Context context, String message, int duration, int type, int gravity) {
        MYToast myToast = new MYToast(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mycustom_toast_container, null);

        ImageView myIcon = view.findViewById(R.id.my_toast_icon);
        TextView myTextView = view.findViewById(R.id.my_toast_textview);

        switch (type) {
            case CUSTOM_TYPE_ERROR:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_error));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_error_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorError));
                }
                break;

            case CUSTOM_TYPE_SUCCESS:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_success));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_success_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSuccess));
                }
                break;

            case CUSTOM_TYPE_WARNING:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_warning));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_warning_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWarning));
                }
                break;

            default:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_info));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_info_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorInfo));
                }
                break;
        }

        switch (gravity) {
            case CUSTOM_GRAVITY_TOP:
                myToast.setGravity(Gravity.TOP, 0, 30);
                break;
            case CUSTOM_GRAVITY_CENTER:
                myToast.setGravity(Gravity.CENTER, 0, 30);
                break;

            default:
                myToast.setGravity(Gravity.BOTTOM, 0, 30);
                break;
        }

        myTextView.setText(message);
        myToast.setDuration(duration);
        myToast.setView(view);

        myToast.mView = view;
        myToast.mType = type;

        return myToast;
    }

    public static MYToast makeToast(Context context, String message, int duration, int type) {
        MYToast myToast = new MYToast(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mycustom_toast_container, null);

        ImageView myIcon = view.findViewById(R.id.my_toast_icon);
        TextView myTextView = view.findViewById(R.id.my_toast_textview);

        switch (type) {
            case CUSTOM_TYPE_ERROR:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_error));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_error_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorError));
                }
                break;

            case CUSTOM_TYPE_SUCCESS:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_success));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_success_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSuccess));
                }
                break;

            case CUSTOM_TYPE_WARNING:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_warning));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_warning_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWarning));
                }
                break;

            default:
                myIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_info));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_info_background));
                } else {
                    view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorInfo));
                }
                break;
        }

        myTextView.setText(message);
        myToast.setDuration(duration);
        myToast.setView(view);

        myToast.mView = view;
        myToast.mType = type;

        return myToast;
    }


    @Override
    public void setText(int resId) {
        setText(mContext.getString(resId));
    }

    @Override
    public void setText(CharSequence s) {
        if (mView == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView tv = mView.findViewById(R.id.text);
        if (tv == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        tv.setText(s);
    }

    public void setIcon(@DrawableRes int iconId) {
        setIcon(ContextCompat.getDrawable(mContext, iconId));
    }

    public void setIcon(Drawable icon) {
        if (mView == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        ImageView iv = mView.findViewById(R.id.icon);
        if (iv == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        iv.setImageDrawable(icon);
    }

    public void setmType(int type) {
        mType = type;
    }

    public int getmType() {
        return mType;
    }

}
