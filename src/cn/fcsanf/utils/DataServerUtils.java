package cn.fcsanf.utils;

import cn.fcsanf.model.Data;
import cn.fcsanf.service.impl.DataServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataServerUtils {
    ServerSocket s = new ServerSocket(8899);
    Date date = new Date();
    Data data = new Data();
    int temperature = 0;
    int ph = 0;
    int turbidity = 0;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentime = dateFormat.format(new Date());

    public DataServerUtils() throws IOException {
    }

    public void DataServer(){
        Socket socket = null;
        try {
            while (true) {
                socket = s.accept();
                System.out.println(socket.getRemoteSocketAddress().toString()+"连接成功");
                new DataServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class DataServerThread extends Thread {
        private Socket socket;
        DataServiceImpl service = new DataServiceImpl();

        DataServerThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            if (socket != null) {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String strMsg = null;
                try {
                    strMsg = bufferedReader.readLine();
                    String s = String.valueOf(strMsg.charAt(0));
                    if ("T".equals(s)) {
                        data.setTemperature(strMsg.substring(1, 3));
                        temperature = Integer.parseInt(strMsg.substring(1, 3));
                    }
                    if ("P".equals(s)) {
                        data.setPh(strMsg.substring(1, 3));
                        ph = Integer.parseInt(strMsg.substring(1, 3));
                    }
                    if ("Z".equals(s)) {
                        data.setTurbidity(strMsg.substring(1, 6));
                        turbidity = Integer.parseInt(strMsg.substring(1, 6));
                    }
                    service.SaveData(data);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                /**
                 *@Author:Fcscanf
                 *@Description:先判断属性值是否为空，不为空保存数据，回调socket获取数据
                 *@Date:下午 17:00 2018/4/27
                 */
                new DataServerThread(socket).start();
            }
        }
    }
}
