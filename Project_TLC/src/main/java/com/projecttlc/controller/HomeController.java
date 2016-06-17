package com.projecttlc.controller;

import com.projecttlc.model.*;
import com.projecttlc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@SessionAttributes("sessionUser")
public class HomeController {
    @Autowired
    LoginService loginService;
    @Autowired
    PostLocalService postLocalService;
    @Autowired
    PostTopicService postTopicService;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    UserService userService;
    @Autowired
    TopicUserService topicUserService;
    @Autowired
    MessageService messageService;
    @Autowired
    MessageRecevierService messageRecevierService;

    Md5PasswordEncoder encodeMD5 = new Md5PasswordEncoder();

//  Confirm Email
    @RequestMapping(value = "/confirmemail/user/{idUser}/confirm.html", method = RequestMethod.GET)
    public ModelAndView confirmEmail(HttpSession session,@PathVariable("idUser") int userID){
        ModelAndView modelAndView = new ModelAndView();
//        int userID  = Integer.parseInt(userIDGET.toString().replaceAll("\\<.*?>",""));
        Users userConfirm = userService.getUser(userID);
//        if(session != null){
//            Users sessionUser = (Users) session.getAttribute("sessionUser");
//            if(sessionUser == null) {
                if(userConfirm.getStatus() != 1 || userConfirm == null){
                    userConfirm.setStatus(1);
                    userService.saveOrUpdateUser(userConfirm);
                    modelAndView.addObject("msgsuccess","Confirm Success, Please Sign Up System!");
                    modelAndView.setViewName("client/login");
                } else {
                    modelAndView.addObject("msgerror","Email had already confirmed !");
                    modelAndView.setViewName("redirect:/");
                }
//            } else {
//                modelAndView.addObject("msgerror","System Error");
//                modelAndView.setViewName("redirect:/");
//            }
//        } else {
//            modelAndView.addObject("msgerror","System Error");
//            modelAndView.setViewName("redirect:/");
//        }
        return  modelAndView;
    }


    @RequestMapping(value = "/sendmsg/send-message/s/{postID}", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView sendMessage(HttpServletRequest request, HttpSession session,
                                    @PathVariable("postID")int postID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                String fromUserEmailGet = request.getParameter("fromUserEmail");
                String fromUserEmail = fromUserEmailGet.toString().replaceAll("\\<.*?>",""); // remove tags html in text
                Users fromUser = userService.getUser(fromUserEmail);
                if(fromUser == null){
                    modelAndView.addObject("msgerror","The message has been error !");
                    modelAndView.setViewName("redirect:/post-user/infor-post-topic/"+postID);
                } else {
                    if(sessionUser.getUser_ID() == fromUser.getUser_ID()){
                        String toUserEmailGet = request.getParameter("toUserEmail");
                        String toUserEmail = toUserEmailGet.toString().replaceAll("\\<.*?>","");
                        Users toUser = userService.getUser(toUserEmail);
                        if(toUser != null){
                            if(toUser.getUser_ID() != fromUser.getUser_ID()){
                                String subjectGET = request.getParameter("subject");
                                String subject = subjectGET.toString().replaceAll("\\<.*?>","");

                                String contentGET = request.getParameter("message");
                                String content = contentGET.toString().replaceAll("\\<.*?>","");

                                Calendar currenttime = Calendar.getInstance();
                                Date sqldate = new Date((currenttime.getTime()).getTime());
                                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                String dateSend = df.format(sqldate);
                                Message message = new Message();
                                message.setFromUserID(fromUser);
                                message.setToUserID(toUser);
                                message.setSubject(subject);
                                message.setContent(content);
                                message.setDateSend(dateSend);
                                messageService.saveAndUpdateMessage(message);
                                Message message1 = messageService.getMessageWithUserID(fromUser.getUser_ID(),toUser.getUser_ID());
                                Message_Recevier messageRecevier = new Message_Recevier();
                                messageRecevier.setMessage_ID(message1);
                                messageRecevier.setRecevier_ID(toUser);
                                messageRecevier.setIs_read(0);
                                messageRecevierService.saveAndUpdate(messageRecevier);

                                modelAndView.addObject("msgsuccess","The message was sent successfully !");
                                modelAndView.setViewName("redirect:/post-user/infor-post-topic/"+postID);
                            } else {
                                modelAndView.addObject("msgerror","You can not send messages to yourself");
                                modelAndView.setViewName("redirect:/post-user/infor-post-topic/"+postID);
                            }
                        } else {
                            modelAndView.addObject("msgerror","The message has been error !");
                            modelAndView.setViewName("redirect:/post-user/infor-post-topic/"+postID);
                        }
                    } else {
                        modelAndView.addObject("msgerror","The message has been error !");
                        modelAndView.setViewName("redirect:/post-user/infor-post-topic/"+postID);
                    }
                }
            } else {
                modelAndView.addObject("msgerror","Please Sign In Or Register");
                modelAndView.setViewName("client/login");
            }
        }else {
            modelAndView.addObject("msgerror","Please Sign In Or Register");
            modelAndView.setViewName("client/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/createmsg/{userID}", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView createMessage(HttpServletRequest request, HttpSession session,
                                    @PathVariable("userID")int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                String fromUserEmailGET = request.getParameter("fromUserEmail");
                String fromUserEmail = fromUserEmailGET.toString().replaceAll("\\<.*?>","");

                Users fromUser = userService.getUser(fromUserEmail);
                if(fromUser == null){
                    if(sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                        modelAndView.addObject("msgerror","The message has been error !");
                        modelAndView.setViewName("redirect:/");
                    } else {
                        modelAndView.addObject("msgerror","The message has been error !");
                        modelAndView.setViewName("redirect:/manage-user/list-message/"+userID);
                    }
                } else {
                    if(sessionUser.getUser_ID() == fromUser.getUser_ID()){
                        String toUserEmailGET = request.getParameter("toUserEmail");
                        String toUserEmail = toUserEmailGET.toString().replaceAll("\\<.*?>","");

                        Users toUser = userService.getUser(toUserEmail);
                        if(toUser != null){
                            if(toUser.getUser_ID() != fromUser.getUser_ID()){
                                String subjectGET = request.getParameter("subject");
                                String subject = subjectGET.toString().replaceAll("\\<.*?>","");

                                String contentGET = request.getParameter("message");
                                String content = contentGET.toString().replaceAll("\\<.*?>","");

                                Calendar currenttime = Calendar.getInstance();
                                Date sqldate = new Date((currenttime.getTime()).getTime());
                                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                String dateSend = df.format(sqldate);
                                Message message = new Message();
                                message.setFromUserID(fromUser);
                                message.setToUserID(toUser);
                                message.setSubject(subject);
                                message.setContent(content);
                                message.setDateSend(dateSend);
                                messageService.saveAndUpdateMessage(message);
                                Message message1 = messageService.getMessageWithUserID(fromUser.getUser_ID(),toUser.getUser_ID());
                                Message_Recevier messageRecevier = new Message_Recevier();
                                messageRecevier.setMessage_ID(message1);
                                messageRecevier.setRecevier_ID(toUser);
                                messageRecevier.setIs_read(0);
                                messageRecevierService.saveAndUpdate(messageRecevier);
                                if(sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                                    modelAndView.addObject("msgsuccess","The message was sent successfully !");
                                    modelAndView.setViewName("redirect:/");
                                } else {
                                    modelAndView.addObject("msgsuccess","The message was sent successfully !");
                                    modelAndView.setViewName("redirect:/manage-user/list-message/"+userID);
                                }

                            } else {
                                if(sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                                    modelAndView.addObject("msgerror","You can not send messages to yourself");
                                    modelAndView.setViewName("redirect:/");
                                } else {
                                    modelAndView.addObject("msgerror","You can not send messages to yourself");
                                    modelAndView.setViewName("redirect:/manage-user/list-message/"+userID);
                                }

                            }
                        } else {
                            if(sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                                modelAndView.addObject("msgerror","The message has been error !");
                                modelAndView.setViewName("redirect:/");
                            } else {
                                modelAndView.addObject("msgerror","The message has been error !");
                                modelAndView.setViewName("redirect:/manage-user/list-message/"+userID);
                            }
                        }
                    } else {
                        if(sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                            modelAndView.addObject("msgerror","The message has been error !");
                            modelAndView.setViewName("redirect:/");
                        } else {
                            modelAndView.addObject("msgerror","The message has been error !");
                            modelAndView.setViewName("redirect:/manage-user/list-message/"+userID);
                        }
                    }
                }
            } else {
                modelAndView.addObject("msgerror","Please Sign In Or Register");
                modelAndView.setViewName("client/login");
            }
        }else {
            modelAndView.addObject("msgerror","Please Sign In Or Register");
            modelAndView.setViewName("client/login");
        }
        return modelAndView;

    }
    @RequestMapping(value = "/detail-message-recevice/msg/{messageID}", method = RequestMethod.GET)
    public ModelAndView detailMessage(HttpSession session,
                                      @PathVariable("messageID")int messageID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                Message_Recevier messageRecevier = messageRecevierService.getMessageRecevierWithMessageID(messageID);
                if(sessionUser.getUser_ID() == messageRecevier.getRecevier_ID().getUser_ID()){
                    messageRecevier.setIs_read(1);
                    messageRecevierService.saveAndUpdate(messageRecevier);
                    modelAndView.addObject("messageRecevier",messageRecevier);
                    modelAndView.setViewName("client/detailmessage");
                } else {
                    modelAndView.addObject("msgerror","Error system!");
                    modelAndView.setViewName("redirect:/");
                }

            } else {
                modelAndView.addObject("msgerror","Error system!");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error system!");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/detail-message-sent/msg/{messageID}", method = RequestMethod.GET)
    public ModelAndView detailMessageSent(HttpSession session,
                                      @PathVariable("messageID")int messageID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                Message message = messageService.getMessageWithMsgID(messageID);
                if(sessionUser.getUser_ID() == message.getFromUserID().getUser_ID()){
                    modelAndView.addObject("message",message);
                    modelAndView.setViewName("client/detailmessage_sent");
                } else {
                    modelAndView.addObject("msgerror","Error system!");
                    modelAndView.setViewName("redirect:/");
                }
            } else {
                modelAndView.addObject("msgerror","Error system!");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error system!");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

//    Notificaton
    @RequestMapping(value = "/getnotification", method = RequestMethod.GET)
    public @ResponseBody String getData(@RequestParam(value = "userID")int userID) {

        List<Topic_User> topicUserList = topicUserService.getAllUserJoinTopic(userID,0);
        List<Message_Recevier> messageRecevierList = messageRecevierService.getAllMessageRecevierWithUserID(userID,0);
        List<Posts> postsList = postTopicService.getAllPostStatus(userID,3);
        String result = "";
        if(topicUserList.size() > 0 && messageRecevierList.size() > 0 &&  postsList.size() > 0){
            result =   "<div class='content'>"+
                            "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                                "You have "+topicUserList.size()+" peoples would like to join to your topic"+
                            "</a>"+
                        "</div>"+
                        "<div class='content'>"+
                            "<a href='/manage-user/list-message/'"+userID+"'>" +
                                "You have "+messageRecevierList.size()+" new messages"+
                            "</a>"+
                        "</div>"+
                        "<div class='content'>"+
                            "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                                "You have "+postsList.size()+" topics had been deleted by System"+
                            "</a>"+
                        "</div>";
        } else if(topicUserList.size() == 0 && messageRecevierList.size() > 0 &&  postsList.size() > 0){
            result =    "<div class='content'>"+
                            "<a href='/manage-user/list-message/"+userID+"'>" +
                                "You have "+messageRecevierList.size()+" new messages"+
                            "</a>"+
                        "</div>"+
                        "<div class='content'>"+
                            "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                                    "You have "+postsList.size()+" topics had been deleted by System"+
                            "</a>"+
                        "</div>";
        } else if(topicUserList.size() > 0 && messageRecevierList.size() == 0 &&  postsList.size() > 0){
            result = "<div class='content'>"+
                        "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                            "You have "+topicUserList.size()+" peoples would like to join to your topic"+
                        "</a>"+
                    "</div>"+
                    "<div class='content'>"+
                        "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                            "You have "+postsList.size()+" topics had been deleted by System"+
                        "</a>"+
                    "</div>";
        } else if(topicUserList.size() > 0 && messageRecevierList.size() > 0 &&  postsList.size() == 0){
            result = "<div class='content'>"+
                        "<a href='/manage-user/list-message/"+userID+"'>" +
                            "You have "+messageRecevierList.size()+" new messages"+
                        "</a>"+
                    "</div>"+
                    "<div class='content'>"+
                        "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                            "You have "+postsList.size()+" topics had been deleted by System"+
                        "</a>"+
                    "</div>";
        }
        else if(topicUserList.size() == 0 && messageRecevierList.size() == 0 &&  postsList.size() > 0){
            result =
                    "<div class='content'>"+
                        "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                            "You have "+postsList.size()+" topics had been deleted by System"+
                        "</a>"+
                    "</div>";
        } else if(topicUserList.size() > 0 && messageRecevierList.size() == 0 &&  postsList.size() == 0){
            result = "<div class='content'>"+
                        "<a href='/manage-user/manage-post-topic/"+userID+"/page/0'>" +
                            "You have "+topicUserList.size()+" peoples would like to join to your topic"+
                        "</a>"+
                    "</div>";
        } else if(topicUserList.size() == 0 && messageRecevierList.size() > 0 &&  postsList.size() == 0){
            result = "<div class='content'>"+
                        "<a href='/manage-user/list-message/"+userID+"'>" +
                            "You have "+messageRecevierList.size()+" new messages"+
                        "</a>"+
                    "</div>";
        } else {
            result = "No notification";
        }

        return result;
    }

    public boolean isNumeric(String s) {
        return s.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
    }

}
