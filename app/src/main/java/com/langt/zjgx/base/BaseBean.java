package com.langt.zjgx.base;

import android.text.TextUtils;

/**
 * Created by Hao on 2019/5/15.
 * Describe
 */
public class BaseBean {

    private String result;
    private String resultNote;

    public String getResult() {
        return result;
    }

    public void setResult(String  result) {
        this.result = result;
    }

    public String getResultNote() {
        return resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    public boolean isSuccess() {
        return TextUtils.equals("0",result);
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "result=" + result +
                ", resultNote='" + resultNote + '\'' +
                '}';
    }
}
