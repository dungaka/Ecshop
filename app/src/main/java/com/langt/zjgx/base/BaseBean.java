package com.langt.zjgx.base;

/**
 * Created by Hao on 2019/5/15.
 * Describe
 */
public class BaseBean {

    private int result;
    private String resultNote;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultNote() {
        return resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    public boolean isSuccess() {
        return 0 == result;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "result=" + result +
                ", resultNote='" + resultNote + '\'' +
                '}';
    }
}
