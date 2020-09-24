package com.qibeigo.aidl;
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androidty on 2020/9/24.
 * description:
 */
public class MyService extends Service {

    private List<Book> mBooks = new ArrayList<>();
    public MyService(){}
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAGBind", "onBind: ");
        return new IBookManager.Stub(){
            @Override
            public String getName() throws RemoteException {
                return "test";
            }

            @Override
            public void addBook(Book book) throws RemoteException {
                mBooks.add(book);
            }

            @Override
            public List<Book> getBookList() throws RemoteException {
                return mBooks;
            }
        };
    }


}
