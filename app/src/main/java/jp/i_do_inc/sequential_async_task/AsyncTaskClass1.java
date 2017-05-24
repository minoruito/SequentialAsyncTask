package jp.i_do_inc.sequential_async_task;

import android.os.AsyncTask;
import android.util.Log;

public class AsyncTaskClass1 extends AsyncTask<Integer, Void, Integer> {
    private static final String  TAG = "AsyncTaskClass1";

    private CallBackTask callbacktask;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Integer doInBackground(Integer... params) {
        Integer result = params[0];
        Log.i(TAG, "START doInBackground実行");
        Log.i(TAG, String.format("%d ", result));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "END doInBackground実行");
        return result;
    }


    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        callbacktask.CallBack(result);
    }


    public void setOnCallBack(CallBackTask _cbj) {
        callbacktask = _cbj;
    }


    /**
     * コールバック用のstaticなclass
     */
    public static class CallBackTask {
        public void CallBack(Integer result) {
        }
    }

}