package com.stakater.nordmart.common;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Utils
{
    public static Map<String, String> getIstioHeaders()
    {
        return new IstioHeaders(getCurrentHttpRequest()).getHeaders();
    }

    private static HttpServletRequest getCurrentHttpRequest()
    {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes)
        {
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        }
        return null;
    }

}
