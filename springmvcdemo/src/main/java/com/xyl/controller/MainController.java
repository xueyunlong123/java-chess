package com.xyl.controller;

import com.xyl.Dao.*;
import com.xyl.Util.CookieUtil;
import com.xyl.Util.JudgeUserIdentityUtil;
import com.xyl.bean.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/5.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
    @RequestMapping(value = "/roRegister")
    public String roRegister(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String email = httpServletRequest.getParameter("email");
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        int index = userDao.addUser(user);
        System.out.println(index);
        return "register_success";
    }

    @RequestMapping(value = "/login")
    public String login(User user,HttpServletResponse response) {
        UserDao userDao = new UserDao();
        /*查询有无该用户信息*/
        List<User> userList = userDao.queryByName(user.getUsername());
        //无，返回登录页面
        if(userList.size()==0){
            return "login";
        }
        //有，返回主页
        else if(userList.get(0).getPassword().equals(user.getPassword())){
            Cookie cookie = new Cookie("username",user.getUsername());
            Cookie cookie1 = new Cookie("uid",userList.get(0).getId()+"");

            response.addCookie(cookie);
            response.addCookie(cookie1);
            return "redirect:/index";
        }
        return "login";
    }

    @RequestMapping(value = "/index")
    public String zhuye(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest,ModelMap modelMap){
        /*判断用户是否登录*/
        if(JudgeUserIdentityUtil.judgeUserIdentity(httpServletRequest.getCookies()) == 0){
            return "login";
        }
        //获取图书信息list
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getAllBook();
        modelMap.addAttribute("books",books);
        return "main/index";
    }
    /*购物车*/
    @RequestMapping(value = "/cart")
    public String cart(HttpServletRequest httpServletRequest,ModelMap modelMap){
        /*判断用户是否登录*/
        if(JudgeUserIdentityUtil.judgeUserIdentity(httpServletRequest.getCookies()) == 0){
            return "login";
        }
        CartDao cartDao = new CartDao();
        List<Cart> carts = cartDao.queryCartByUid(Integer.parseInt(CookieUtil.getCookie(httpServletRequest.getCookies(),"uid")));
        float total_price= 0;

        if(carts.size()!=0){
            for (Cart cart: carts) {
                total_price +=cart.getTotalprice();
            }
        }
        modelMap.addAttribute("carts",carts);
        modelMap.addAttribute("total_price",total_price);
        return "main/cart";
    }

    /*购物车添加物品*/
    @RequestMapping(value = "/addCart")
    public String addCart(HttpServletRequest httpServletRequest) {
        /*判断用户是否登录*/
        if(JudgeUserIdentityUtil.judgeUserIdentity(httpServletRequest.getCookies()) == 0){
            return "login";
        }
        String[] bookids = httpServletRequest.getParameterValues("bookid");
        System.out.println(bookids.length);
        if (bookids == null) {return "redirect:/index";
        } else {
                CartDao cartDao = new CartDao();
                for (String bookid : bookids) {
                    System.out.println(bookid);
                    //通过cookie获取当前用户uid
                    Cookie[] cookies = httpServletRequest.getCookies();
                    Cookie c = null;
                    String uid = CookieUtil.getCookie(httpServletRequest.getCookies(),"uid");
                    //插入数据
                    /*先判断当前用户下，当前书是否有过购物车记录*//*
                    List<Cart> carts = cartDao.queryCartByUid(Integer.parseInt(uid));
                    System.out.println(carts == null);

                    //如果不为空，判断当前用户有无对该本书的购物车记录*/

                        List<Cart> carts1 = cartDao.queryCartByUidAndBid(Integer.parseInt(uid), Integer.parseInt(bookid));
                        //如果当前用户有对该书的购物车记录，将记录+1
                        if (carts1 != null&&carts1.size()!=0) {

                            /*更新当前用户记录的购书数目*/
                            int index = cartDao.updateCartCountByUidAndBid(Integer.parseInt(uid),Integer.parseInt(bookid));
                            continue;
                        }
                    //没有该本书的购买记录，则添加一条记录
                    Book book = new BookDao().queryBookById(Integer.parseInt(bookid));


                    cartDao.insertCart(Integer.parseInt(uid),book.getPrice(),book.getPrice(),1,Integer.parseInt(bookid),book.getTitle(),book.getFace());
                }
            return "redirect:/cart";
        }
    }

    /*查询订单*/
    @RequestMapping(value = "/orders")
    public String orders(HttpServletRequest httpServletRequest,ModelMap modelMap){
        /*判断用户是否登录*/
        if(JudgeUserIdentityUtil.judgeUserIdentity(httpServletRequest.getCookies()) == 0){
            return "login";
        }
        OrderDao orderDao = new OrderDao();
        List<Order> orders =orderDao.queryOrderByUid(Integer.parseInt(CookieUtil.getCookie(httpServletRequest.getCookies(),"uid")));
        modelMap.addAttribute("orders",orders);
        return "main/orders";
    }
    /*添加订单*/
    @RequestMapping(value = "/addOrder")
    public String addOrder(HttpServletRequest httpServletRequest){
        /*判断用户是否登录*/
        if(JudgeUserIdentityUtil.judgeUserIdentity(httpServletRequest.getCookies()) == 0){
            return "login";
        }
        Timestamp d = new Timestamp(System.currentTimeMillis());
        OrderDao orderDao = new OrderDao();

        Order order = new Order();
        order.setUid(Integer.parseInt(CookieUtil.getCookie(httpServletRequest.getCookies(),"uid")));
        order.setBuydate(d);
        order.setTotalprice(Float.parseFloat(httpServletRequest.getParameter("hidden_total_price")));
        order.setReceiver(httpServletRequest.getParameter("receiver"));
        order.setRaddress(httpServletRequest.getParameter("raddress"));
        order.setRphone(httpServletRequest.getParameter("rphone"));

        /*int index =orderDao.insertOrder(Integer.parseInt(CookieUtil.getCookie(httpServletRequest.getCookies(),"uid")),
                d,Float.parseFloat(httpServletRequest.getParameter("hidden_total_price")) ,
                httpServletRequest.getParameter("receiver"),httpServletRequest.getParameter("raddress"),
                httpServletRequest.getParameter("rphone"));*/
        /*添加订单*/
        int index = orderDao.insertOrder(order);
        int oid = order.getId();
        System.out.println(oid);
        /*添加订单详情*/
        CartDao cartDao = new CartDao();
        OrderDetailDao orderDetailDao = new OrderDetailDao();
        List<Cart> carts = cartDao.queryCartByUid(Integer.parseInt(CookieUtil.getCookie(httpServletRequest.getCookies(),"uid")));
        for (Cart cart:carts
             ) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOid(oid);
            orderDetail.setBid(cart.getBid());
            orderDetail.setCounts(cart.getCounts());
            orderDetail.setBuyprice(cart.getPrice());
            orderDetailDao.insertOrderDetail(orderDetail);
        }
        /*清空当前用户购物车*/
        cartDao.deleteCartByUid(Integer.parseInt(CookieUtil.getCookie(httpServletRequest.getCookies(),"uid")));
        return "redirect:/orders";
    }
    /*查看订单详情*/
    @RequestMapping(value = "/orderdetail")
    public String orderDetail(HttpServletRequest httpServletRequest, ModelMap modelMap){
        /*判断用户是否登录*/
        if(JudgeUserIdentityUtil.judgeUserIdentity(httpServletRequest.getCookies()) == 0){
            return "login";
        }
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        /*通过id获取订单*/
        OrderDao orderDao = new OrderDao();
        Order order= orderDao.queryOrderByid(id);
        /*通过id获取订单详情list*/
        OrderDetailDao orderDetailDao = new OrderDetailDao();
        List<OrderDetail> orderDetails = orderDetailDao.queryOrderDetailByOid(id);

        /*通过订单详情及订单，获取订单内每本书的信息*/
        float total_price= 0;
        List<Cart> carts = new ArrayList<>();
        for (OrderDetail orderDetail:orderDetails
             ) {
            Cart cart = new Cart();
            BookDao bookDao = new BookDao();
            Book book= bookDao.queryBookById(orderDetail.getBid());
            cart.setFace(book.getFace());
            cart.setTitle(book.getTitle());
            cart.setPrice(book.getPrice());
            cart.setCounts(orderDetail.getCounts());
            cart.setTotalprice(orderDetail.getBuyprice()*orderDetail.getCounts());
            carts.add(cart);
            total_price +=orderDetail.getBuyprice()*orderDetail.getCounts();

        }
        modelMap.addAttribute("carts",carts);
        modelMap.addAttribute("total_price",total_price);
        modelMap.addAttribute("receiver",order.getReceiver());
        modelMap.addAttribute("raddress",order.getRaddress());
        modelMap.addAttribute("rphone",order.getRphone());
        return "main/orderdetail";
    }
    /*注销*/
    @RequestMapping(value = "/logout")
    public String logout(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("uid",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        return "login";
    }
}

