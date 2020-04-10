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

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.app.model.Skill;
import com.app.repository.SkillRepository;

@Component
public class CommonUtils {

    @Inject
    private SkillRepository skillRepository;

    @Value("${location}")
    private String location;

    /**
     * 打印对象所有get方法的值
     * 
     * @param obj
     */
    public Map<String,String> printBean(Object obj) {
        Map<String,String> map = new HashMap<String, String>();
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
                    if(field.getType().toString().indexOf("List") < 0) {
                        map.put(name, value);
                    }
                    System.out.println(name + ":" + value);
                }
            } catch (NoSuchMethodException e) {
                System.out.println("==>NoSuchMethodException:" + getter);
            }catch (Exception e) {
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
            for (PropertyDescriptor descriptor : beanInfo
                    .getPropertyDescriptors()) {
                Object value = descriptor.getReadMethod().invoke(target);
                if (value == null) {
                    Object defaultValue = descriptor.getReadMethod()
                            .invoke(destination);
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
    public <M> Map<String, M> listConventToMap(List<M> list,
            String primanyKey) {
        Map<String, M> map = new HashMap<String, M>();
        String getter = "get"
                + primanyKey.substring(0, 1).toUpperCase(Locale.ROOT)
                + primanyKey.substring(1);
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
     * 技能种类分类
     * 
     * @return Map<String,List<String>>
     */
    public Map<String, List<String>> getSkillMap() {
        // 取得所有技能对象
        List<Skill> skillList = skillRepository.getAllSkill();
        // Map对象
        Map<String, List<String>> skillMap = new HashMap<>();
        // 循环取得的所有技能对象
        for (Skill skill : skillList) {
            // 取得技能对象的技能种类
            String key = skill.getSkillType();
            List<String> value;
            // Map对象中是否已有种类对应的对象
            if (null == skillMap.get(key)) {
                // 不存在新建list对象
                value = new ArrayList<String>();
            } else {
                // 存在即取出
                value = skillMap.get(key);
            }
            // list里追加
            value.add(skill.getSkillName());
            // 把list放入种类key中
            skillMap.put(key, value);
        }
        return skillMap;
    }

    /**
     * 通过list中的逻辑主键将list对象转为Map对象
     * 
     * @param keyName 逻辑主键
     * @param originList
     * @return
     */
    public <M> Map<String, List<M>> groupByList(String keyName,
            List<M> originList) {
        Map<String, List<M>> result = new HashMap<String, List<M>>();
        String getter = "get" + keyName.substring(0, 1).toUpperCase(Locale.ROOT)
                + keyName.substring(1);
        for (M obj : originList) {
            Method method;
            try {
                method = obj.getClass().getMethod(getter, new Class[] {});
                String keyValue = method.invoke(obj, new Class[] {}).toString();
                List<M> list = ((null == result.get(keyValue))
                        ? new ArrayList<M>()
                        : result.get(keyValue));
                list.add(obj);
                result.put(keyValue, list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
