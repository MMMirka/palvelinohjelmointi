package MirkaM.TaskList.domain;

import javax.servlet.http.HttpServletRequest;

public class Util {
	
    public static String getSiteURL(HttpServletRequest request) {
    	
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}