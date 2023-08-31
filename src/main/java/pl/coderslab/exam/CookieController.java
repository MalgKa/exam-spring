package pl.coderslab.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {


    @GetMapping("add-cookies")
    public void addCookies(HttpServletResponse response){
        Cookie cookieUser = new Cookie("user", "Jan");
        Cookie cookieUid = new Cookie("uid", "ccb1b154-c4ff");
        Cookie cookieIde = new Cookie("IDE", "IntelliJ");
        cookieUser.setMaxAge(10*60);
        response.addCookie(cookieUser);
        cookieUid.setMaxAge(10*24*60*60);
        response.addCookie(cookieUid);
        cookieIde.setMaxAge(30*24*60*60);
        response.addCookie(cookieIde);
    }

    //1 sposób z wykorzystaniem WebUtils
    @GetMapping("all-cookies")
    public String allCookies(HttpServletRequest request, Model model){
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(WebUtils.getCookie(request,"user"));
        cookieList.add(WebUtils.getCookie(request,"uid"));
        cookieList.add(WebUtils.getCookie(request,"IDE"));
        model.addAttribute("cookieList", cookieList);
        return "cookiesView";
    }

    //2 sposób
//    @GetMapping("all-cookies")
//    public String allCookies(@CookieValue("user") Cookie cookieUser,
//                             @CookieValue("uid") Cookie cookieUid,
//                             @CookieValue("IDE") Cookie cookieIde, Model model){
//        List<Cookie> cookieList = List.of(cookieUser,cookieUid,cookieIde);
//        model.addAttribute("cookieList", cookieList);
//        return "cookiesView";
//
//    }



}
