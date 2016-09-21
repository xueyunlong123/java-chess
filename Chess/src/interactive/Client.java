package interactive;
import Model.ChessBoard;
import Model.ChessPoint;
import Model.MyPanel;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Created by ${Xueyunlong} on 2016/4/16.
 */
public class Client {
    static Socket socket;
    private static ChessBoard chessBoard;
    public static void link() throws UnknownHostException, IOException {
        socket = new Socket("localhost",1111);
    }
    public static void getData() throws IOException {

        while (true) {//保持长连接

            if (socket != null) {
                ObjectInputStream is = null;
                OutputStream os = null;
                try {
                    socket.setKeepAlive(true);
                    is = new ObjectInputStream(socket.getInputStream());
                    os = socket.getOutputStream();
                    System.out.println("服务器端接受请求");

                    //从对方手中得到棋盘
                    try {
                        chessBoard = (ChessBoard) is.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    //先判断棋盘传入，以及传入的棋盘和本地棋盘是否有差别
                    if (chessBoard.chessPoints.size() != 0 && chessBoard.chessPoints.size() != MyPanel.chessBoard.chessPoints.size()) {
                        /**
                         *通过棋盘的chessPoints来更新棋盘
                         *list元素下标从0开始
                         * 得到对手的最近一步
                         */
                        int index = chessBoard.chessPoints.size() - 1;
                        System.out.println(index);
                        ChessPoint chessPoint = chessBoard.chessPoints.get(index);
                        System.out.println(chessPoint.getState());
                        //更新棋盘UI
                        //在chessBoard.chessPoints中得到棋子位置
                        MyPanel.chessBoard.paintCilcle(MyPanel.chessBoard.getGraphics(), chessPoint.getPoint(), 30, 30, chessPoint.getState());
                        //更新棋盘存储
                        MyPanel.chessBoard.setChessPoints(chessBoard.getChessPoints());
                        MyPanel.chessBoard.setChessMap(chessBoard.getChessMap());
                        //获取棋盘控制权
                        MyPanel.power = true;
                    }
                } catch (Exception e) {
                    System.out.println("出现了错误,关闭连接");
                    if (is != null)
                        is.close();
                    if (os != null)
                        os.close();

                    e.printStackTrace();


                }


            }
        }

    }
    public static void send(ChessBoard chessBoard) throws IOException {
        if (socket.isConnected()){
            ObjectOutputStream os = null;
            ObjectInputStream is = null;

            try {
                //发送数据
                    os = new ObjectOutputStream(socket.getOutputStream());
                    os.writeObject(chessBoard);
                System.out.println("发送数据");
                    os.flush();
            } catch (Exception e) {
                e.printStackTrace();
                if(os != null)
                    os.close(); //由于是长连接，抛异常时要关闭os，否则会broken pipe
                if(is != null)
                    is.close();
            }


        }
    }

}
