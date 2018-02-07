package com.weibar.utils;

import java.util.List;
import java.util.Map;

import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import org.codehaus.jackson.map.ObjectMapper;


public class JsonConverter {
    // 对象2Json
    public static String toJson(Object value) throws BaseException {

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(value);
            return json;
        } catch (Exception e) {
            throw BaseException.getException(ErrorCodeEnum.JSON_ERROR.getCode());
        }
    }

    // Json2Map
    public static Map<?, ?> jsonToMap(String s) throws BaseException {

        Map<?, ?> map = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(s, Map.class);
            //不用遍历了 update by zd.
            /*System.out.println(map.size());
            Iterator<?> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                System.out.print(key + ":");
                System.out.println(map.get(key).toString());
            }*/
            return map;
        } catch (Exception e) {
            throw BaseException.getException(ErrorCodeEnum.JSON_ERROR.getCode());        }
    }

    // Json2List
    public static List<?> jsonToList(String s) throws BaseException {

        List<?> list = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            list = (List<?>) mapper.readValue(s, List.class);
            return list;
        } catch (Exception e) {
            throw BaseException.getException(ErrorCodeEnum.JSON_ERROR.getCode());
        }
    }

    //JSON到对象
    public static <Type> Type fromJson(Class<Type> type, String json) throws BaseException {

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, type);
        } catch (Exception e) {
            throw BaseException.getException(ErrorCodeEnum.JSON_ERROR.getCode());
        }
    }

    public static String getStringParaFromMap(Map<?, ?> map, String key) {

        Object value = map.get(key);
        if (null != value) {
            if (value instanceof String) {
                return (String) value;
            } else {
                return value.toString();
            }
        }

        return null;
    }

    public static Integer getIntegerParaFromMap(Map<?, ?> map, String key) {

        Object value = map.get(key);
        if (null != value) {
            if (value instanceof Integer) {
                return (Integer) value;
            } else {
                return Integer.parseInt(value.toString());
            }
        }

        return null;
    }
    
    public static Boolean getBooleanParaFromMap(Map<?, ?> map, String key) {

        Object value = map.get(key);
        if (null != value) {
            if (value instanceof Boolean) {
                return (Boolean) value;
            } else {
                return Boolean.parseBoolean(value.toString());
            }
        }

        return null;
    }

    public static Long getLongParaFromMap(Map<?, ?> map, String key) {

        Object value = map.get(key);
        if (null != value) {
            if (value instanceof Long) {
                return (Long) value;
            } else {
                return Long.parseLong(value.toString());
            }
        }

        return null;
    }

    public static List getListParaFromMap(Map<?, ?> map, String key) {

        Object value = map.get(key);
        if (null != value) {
            if (value instanceof List) {
                return (List) value;
            }
        }

        return null;
    }

    public static Map getMapParaFromMap(Map<?, ?> map, String key) {

        Object value = map.get(key);
        if (null != value) {
            if (value instanceof Map) {
                return (Map) value;
            }
        }

        return null;
    }
}
