package com.gmail.utils.properties;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.aeonbits.owner.Config;
import org.apache.commons.lang3.StringUtils;

public class OwnerPropertiesUtils {

    private OwnerPropertiesUtils() {
    }

    public static <T> T readPropertyByKeyValue(final Config proxy, final String value) {
        final Method method = getMethods(getProviderClass(proxy), withAnnotation(Config.Key.class)).stream()
            .filter(m -> StringUtils.equals(m.getAnnotation(Config.Key.class).value(), value))
            .findFirst()
            .orElse(null);
        return (T) method.getReturnType().cast(invoke(proxy, method));
    }

    private static Object invoke(final Config proxy, final Method method) {
        try {
            return Proxy.getInvocationHandler(proxy).invoke(proxy, method, null);
        } catch (Throwable throwable) {
            throw new IllegalArgumentException(String.format("Could not invoke method [%s]", method.getName()),
                throwable);
        }
    }

    private static Class getProviderClass(final Config proxy) {
        return Arrays.stream(proxy.getClass().getInterfaces())
            .filter(Config.class::isAssignableFrom)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Could not find property provider class!"));
    }

}
