package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----전체 파라미터 조회 START-----");
        Enumeration<String> parameterNames = request.getParameterNames();
        /**
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + " : " + request.getParameter(paramName));
        }

         **/

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName
                                    -> System.out.println(paramName + " : " + request.getParameter(paramName)));
        System.out.println("-----전체 파라미터 조회 END-----");
        System.out.println();

        System.out.println("----단일 파라미터 조회 START----");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) : " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) : " + age);

        System.out.println("[이름이 같은 복수 파라미터]");

        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("usernames = " + name);
        }

        response.getWriter().write("ok");

        System.out.println("----단일 파라미터 조회 END----");

    }

}
