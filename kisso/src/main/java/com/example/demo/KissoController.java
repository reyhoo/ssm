package com.example.demo;


import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.security.token.SSOToken;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/kisso")
public class KissoController {


    @Login(action = Action.Skip)
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @Valid User user, Errors errors){
        String errorMsg = getErrorMsg(errors);
        if(errorMsg != null){
            return errorMsg;
        }
        SSOToken ssoToken  = SSOToken.create().setId(user.getId()).setIp(request).setIssuer("issuer"+user.getId());
        SSOHelper.setCookie(request,response,ssoToken,false);
        return "login success";

    }

    public String getErrorMsg(Errors errors){
        List<FieldError> errorList = errors.getFieldErrors();
        for (FieldError error :
                errorList) {
            return error.getDefaultMessage();
        }
        return null;
    }


    @RequestMapping("/token")
    public String token(HttpServletRequest request, HttpServletResponse response){
       SSOToken ssoToken = SSOHelper.getSSOToken(request);
       if(ssoToken != null){
            request.setAttribute("kissoTokenAttr",ssoToken);
       }
        ssoToken = SSOHelper.getSSOToken(request);
       StringBuilder sb = new StringBuilder();
       sb.append("id="+ssoToken.getId());
       sb.append(",");
       sb.append("issuer="+ssoToken.getIssuer());
       return sb.toString();
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        SSOHelper.clearLogin(request,response);
        return "logout success!";
    }

}
