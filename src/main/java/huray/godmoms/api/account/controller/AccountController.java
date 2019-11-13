package huray.godmoms.api.account.controller;

import huray.godmoms.api.account.service.AccountService;
import huray.godmoms.common.code.SocialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/time")
    @ResponseBody
    public String getTime(HttpServletRequest request, HttpServletResponse response) {
        return LocalDateTime.now().toString();
    }

    @RequestMapping(value = "/token")
    @ResponseBody
    public String getToken(HttpServletRequest request, HttpServletResponse response) {
        return String.valueOf(request.getSession().getAttribute(HttpHeaders.AUTHORIZATION));
    }

    @RequestMapping(value = "/{social}", method = RequestMethod.GET)
    public ResponseEntity account(@PathVariable(value = "social") SocialType type, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        URI uri = URI.create(String.format("%s://%s:%s", request.getScheme(), request.getLocalName(), request.getLocalPort()));
        String location = accountService.createAccountUri(type, uri);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(location));
        return new ResponseEntity(headers, HttpStatus.SEE_OTHER);
    }

    @RequestMapping(value = "/callback/{social}", method = RequestMethod.GET)
    public ResponseEntity<String> callback(@PathVariable(value = "social") SocialType type, @RequestParam(value = "code") String code, HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {
        String token = accountService.requestToken(type, code, request.getRequestURL().toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI("/"));
//        headers.add(HttpHeaders.AUTHORIZATION, token);
//        headers.add(HttpHeaders.SET_COOKIE, "Authorization=" + token);
//        response.addCookie(new Cookie("authorization", token));

        request.getSession().setAttribute(HttpHeaders.AUTHORIZATION, token);

        return new ResponseEntity<>(token, headers, HttpStatus.SEE_OTHER);
    }
}
