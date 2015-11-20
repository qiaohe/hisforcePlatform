package cn.mobiledaily.hisforce.common;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Johnson on 2015/11/14.
 */
public class Util {
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper beanMapper = new BeanWrapperImpl(source);
        Set<String> result = new HashSet<>();
        for (PropertyDescriptor pd : beanMapper.getPropertyDescriptors()) {
            if (beanMapper.getPropertyValue(pd.getName()) == null) result.add(pd.getName());
        }
        return result.toArray(new String[result.size()]);
    }

}
