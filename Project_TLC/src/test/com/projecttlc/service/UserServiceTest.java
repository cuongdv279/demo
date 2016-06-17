//package com.projecttlc.service;
//
//import com.projecttlc.dao.UserDAO;
//import com.projecttlc.model.Users;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.stubbing.Answer;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//import static org.mockito.Matchers.any;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// * Created by CHIP_IT_DVC on 05/04/2016.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//
//    private UserDAO userDAO;
//    private UserService userService;
//    public Users createUser (int user_ID, String first_Name, String last_Name, int gender,
//                 String email, String password, String user_Role, String activation_Date,
//                 String avatar, String address, String phone_Number, String birthday,
//                 String job, String country, String website,int status) {
//        Users user = new Users();
//        user.setUser_ID(user_ID);
//        user.setFirst_Name(first_Name);
//        user.setLast_Name(last_Name);
//        user.setStatus(status);
//        user.setActivation_Date(activation_Date);
//        user.setAddress(address);
//        user.setBirthday(birthday);
//        user.setCountry(country);
//        user.setGender(gender);
//        user.setJob(job);
//        user.setPassword(password);
//        user.setPhone_Number(phone_Number);
//        user.setUser_Role(user_Role);
//        user.setEmail(email);
//        user.setAvatar(avatar);
//        user.setWebsite(website);
//
//        return user;
//    }
//    private Map<String ,Users> userMap = new HashMap<String, Users>();
//    private Map<String , Users> createUsersMap(int length){
//        Map<String, Users> quesMap = new HashMap<String, Users>();
//        for(int i = 0; i < length; i++){
//            Users user = createUser((i+1),"firstName"+i,"lastName"+i,1,"email"+i,"pass"+i,"USER_ROLE","12/02/2016","img"+i
//                    ,"address"+i,"phone"+i,"12/02/2016","job"+i,"counry"+i,"website"+i,1);
//            quesMap.put("User_"+i,user);
//        }
//        return quesMap;
//    }
//
//    @Before
//    public void doSetup(){
//        userDAO = mock(UserDAO.class);
//        userService = new UserService();
//        userMap = createUsersMap(10);
//        when(userDAO.getAllUser()).thenAnswer(new Answer<List<Users>>() {
//            public List<Users> answer(InvocationOnMock invocation)
//                    throws Throwable {
//                List<Users> newList = new ArrayList<Users>();
//                for (int i = 0; i < userMap.size(); i++) {
//                    newList.add(userMap.get("User_" + i));
//                }
//                return newList;
//            }
//        });
//
//    }
//    @Test
//    public void testGetAllUser() throws Exception {
//
//        List<Users> listUsers = userDAO.getAllUser();
//        assertTrue(listUsers.size() == 10);
//
//    }
//
////    @Test
////    public void testGetAllUser1() throws Exception {
////
////    }
////
////    @Test
////    public void testGetAllUserWithStatus() throws Exception {
////
////    }
////
//    @Test
//    public void testGetUser() throws Exception {
//        when(userDAO.getUser(anyInt())).thenAnswer(new Answer<Users>() {
//           public Users answer(InvocationOnMock invocation)
//                   throws Throwable {
//                   Users users = new Users();
//                   users.setUser_ID(1);
//                   users.setFirst_Name("cuong");
//                   users.setLast_Name("duong van");
//                   users.setStatus(1);
//                   users.setActivation_Date("23/02/2016");
//                   users.setAddress("danang");
//                   users.setBirthday("27/09/1994");
//                   users.setCountry("vietnam");
//                   users.setGender(1);
//                   users.setJob("developer");
//                   users.setPassword("12345");
//                   users.setPhone_Number("02120112112");
//                   users.setUser_Role("ROLE_USER");
//                   users.setEmail("chipkahu@gmail.com");
//               return users;
//           }
//
//        });
//        Users userTest = userDAO.getUser(1);
//        assertNotNull(userTest.getUser_ID());
//        assertEquals(1, userTest.getUser_ID());
//        assertEquals("cuong", userTest.getFirst_Name());
//    }
////
////    @Test
////    public void testGetUser1() throws Exception {
////
////    }
////
////    @Test
////    public void testLogIn() throws Exception {
////
////    }
////
////    @Test
////    public void testLogOut() throws Exception {
////
////    }
////
////    @Test
////    public void testSaveOrUpdateUser() throws Exception {
////        Users users = new Users();
////        users.setFirst_Name("cuong");
////        users.setLast_Name("duong van");
////        users.setStatus(1);
////        users.setActivation_Date("23/02/2016");
////        users.setAddress("danang");
////        users.setBirthday("27/09/1994");
////        users.setCountry("vietnam");
////        users.setGender(1);
////        users.setJob("developer");
////        users.setPassword("12345");
////        users.setPhone_Number("02120112112");
////        users.setUser_Role("ROLE_USER");
////        users.setEmail("chipkahu@gmail.com");
////    }
////
////    @Test
////    public void testUpdateStatusAndRoleUser() throws Exception {
////
////    }
////
////    @Test
////    public void testUpdateProfileAdmin() throws Exception {
////
////    }
////
////    @Test
////    public void testDeleteUser() throws Exception {
////
////    }
////
////    @Test
////    public void testUpdatePassword() throws Exception {
////
////    }
//}