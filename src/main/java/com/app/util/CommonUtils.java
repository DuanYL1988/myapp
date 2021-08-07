package com.app.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {

    @Value("${location}")
    private String location;

    /**
     * 打印对象所有get方法的值
     *
     * @param obj
     */
    public Map<String, String> printBean(Object obj) {
        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            String value = "";
            String firstLetter = name.substring(0, 1).toUpperCase(Locale.ROOT);
            String getter = "get" + firstLetter + name.substring(1);
            Method method;
            try {
                method = obj.getClass().getMethod(getter, new Class[] {});
                if (null != method.invoke(obj, new Class[] {})) {
                    value = method.invoke(obj, new Class[] {}).toString();
                    if (field.getType().toString().indexOf("List") < 0) {
                        map.put(name, value);
                    }
                    System.out.println(name + ":" + value);
                }
            } catch (NoSuchMethodException e) {
                System.out.println("==>NoSuchMethodException:" + getter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * Copy Same Object
     *
     * @param target
     * @param destination
     */
    public <M> void merge(M target, M destination) {
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(target.getClass());
            for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
                Object value = descriptor.getReadMethod().invoke(target);
                if (value == null) {
                    Object defaultValue = descriptor.getReadMethod().invoke(destination);
                    descriptor.getWriteMethod().invoke(target, defaultValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过键（不重复）把list转为map<key,object>
     *
     * @param list
     * @param primanyKey
     * @return
     */
    public <M> Map<String, M> listConventToMap(List<M> list, String primanyKey) {
        Map<String, M> map = new HashMap<String, M>();
        String getter = "get" + primanyKey.substring(0, 1).toUpperCase(Locale.ROOT) + primanyKey.substring(1);
        Object target = list.get(0);
        try {
            Method method = target.getClass().getMethod(getter, new Class[] {});
            for (M obj : list) {
                String value = method.invoke(obj, new Class[] {}).toString();
                map.put(value, obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 通过list中的逻辑主键将list对象转为Map对象
     *
     * @param keyName    逻辑主键
     * @param originList
     * @return
     */
    public <M> Map<String, List<M>> groupByList(String keyName, List<M> originList) {
        // prefix-key判断
        String prefix = "";
        if (keyName.indexOf("-") >= 0) {
            String[] fullinfo = keyName.split("-");
            keyName = fullinfo[1];
            prefix = fullinfo[0] + "-";
        }
        Map<String, List<M>> result = new HashMap<String, List<M>>();
        String getter = "get" + keyName.substring(0, 1).toUpperCase(Locale.ROOT) + keyName.substring(1);
        for (M obj : originList) {
            Method method;
            try {
                method = obj.getClass().getMethod(getter, new Class[] {});
                String keyValue = prefix + method.invoke(obj, new Class[] {}).toString();
                List<M> list = ((null == result.get(keyValue)) ? new ArrayList<M>() : result.get(keyValue));
                list.add(obj);
                result.put(keyValue, list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 数据库字段名转为java变量名
     */
    public String changeNm(String dbNm, boolean upFlag) {
        String javaNm = "";
        String[] nms = dbNm.split("_");
        if (nms.length == 1) {
            javaNm = dbNm.toLowerCase();
        } else {
            StringBuilder sb = new StringBuilder(nms[0].toLowerCase());
            for (int i = 1; i < nms.length; i++) {
                String tmp = nms[i];
                sb.append(tmp.substring(0, 1));
                sb.append(tmp.substring(1).toLowerCase());
            }
            javaNm = sb.toString();
        }
        if (upFlag) {
            javaNm = javaNm.substring(0, 1).toUpperCase() + javaNm.substring(1);
        }
        return javaNm.toString();
    }

    public boolean isInclude(String[] aStrArr, String target) {
        for (String name : aStrArr) {
            if (name.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean isImage(String fileNm) {
        String[] filename = fileNm.split("\\.");
        if (filename.length > 0) {
            String type = filename[filename.length - 1];
            return isInclude(new String[] { "gif", "jpg", "bmp", "png" }, type.toLowerCase());
        } else {
            return false;
        }
    }
}
