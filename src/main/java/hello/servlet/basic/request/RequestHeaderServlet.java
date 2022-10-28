package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeader(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    /** 아래 접속 시 뜨는 정보
     * http://localhost:8080/request-header?username=hello
     *
     */
    private static void printStartLine(HttpServletRequest request) {

        System.out.println("----REQUEST LINE START----");

        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        System.out.println("request.getRequestURL() = " + request.getRequestURL()); //http://localhost:8080/request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI()); //request-header
        System.out.println("request.getQueryString() = " + request.getQueryString()); //username = hello
        System.out.println("request.isSecure() = " + request.isSecure()); //false

        System.out.println("----REQUEST LINE END----");
        System.out.println();
    }

    private static void printHeader(HttpServletRequest request) {

        System.out.println("----HEADER START----");

        /**
         * 방식 1.
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + " : " + request.getHeader(headerName));
        }
        **/

        //헤더에 있는 정보 모두 출력.
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName
                                    -> System.out.println(headerName + " : " + request.getHeader(headerName)));


        System.out.println("----HEADER END----");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("----HEADER UTILS START----");

        System.out.println("[헤더 편의 조회]");
        System.out.println("request.getServerName() : " + request.getServerName()); //localhost
        System.out.println("request.getServerPort() : " + request.getServerPort()); //8080
        System.out.println();

        System.out.println("[Accept - Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale
                                    -> System.out.println("locale : " + locale));
        System.out.println("request.getLocale() : " + request.getLocale());
        System.out.println();

        System.out.println("[Cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() : " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() : " + request.getCharacterEncoding());

        System.out.println("----HEADER UTILS END----");
        System.out.println();

    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("-----ETC-----");
        System.out.println("[Remote Info]"); //클라이언트 IP 주소
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteHost());
        System.out.println("request.getRemotePort() = " + request.getRemoteHost());
        System.out.println();

        System.out.println("[Local Info]"); //로컬의 기본정보
        System.out.println("request.getLocalName() = " + request.getRemoteHost());
        System.out.println("request.getLocalAddr() = " + request.getRemoteHost());
        System.out.println("request.getLocalPort() = " + request.getRemoteHost());
        System.out.println("-----ETC-----");
        System.out.println();

    }
}
