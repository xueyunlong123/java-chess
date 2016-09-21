package interactive;

import Model.ChessBoard;
import Model.ChessPoint;
import Model.MyPanel;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/4/16.
 */


public class Server {

    private static ChessBoard chessBoard;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(1111);
        Socket socket=serverSocket.accept();
        while(true){//保持长连接
            try {
                Thread.sleep(3000);//等待时间
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if (socket !=null){
                ObjectInputStream is = null;
                OutputStream os = null;
                try {
                    String ip = socket.getInetAddress().toString().replace("/", "");
                    System.out.println("====socket.getInetAddress()====="+ip);
                    socket.setKeepAlive(true);
                    is = new ObjectInputStream(socket.getInputStream());
                    os = socket.getOutputStream();
                    System.out.println("服务器端接受请求");

                    //从对方手中得到棋盘
                    chessBoard = (ChessBoard) is.readObject();
                    //获取棋盘三元素：
                    //list元素下标从0开始
                    ChessPoint chessPoints = (ChessPoint) chessBoard.chessPoints.get(0);
                }catch(Exception e){
                    System.out.println("出现了错误,关闭连接");
                    if (is!= null)
                        is.close();
                    if (os!= null)
                        os.close();

                    e.printStackTrace();

                }
            }
        }

    }

}
