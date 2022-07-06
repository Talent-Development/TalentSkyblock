package com.talent.talentskyblock.common.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Furkan Doğan
 */
public abstract class Assert {

  public static void notNull(Object object, String message) {
    if (object == null) {
      throw new NullPointerException(message);
    }
  }

  public static void notBlank(String string, String message) {
    if (string == null || string.isBlank()) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notEmpty(Object[] list, String message) {
    if (list == null || list.length == 0) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notEmpty(List<?> list, String message) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notEmpty(Set<?> list, String message) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void notEmpty(Map<?, ?> map, String message) {
    if (map == null || map.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void isTrue(boolean condition, String message) {
    if (condition) {
      throw new RuntimeException(message);
    }
  }

  public static void notTrue(boolean condition, String message) {
    if (!condition) {
      throw new RuntimeException(message);
    }
  }

  public static <T> T requireNonNull(T object, String message) {
    if (object == null) {
      throw new NullPointerException(message);
    }

    return object;
  }

  public static String requireNonBlank(String string, String message) {
    if (string == null || string.isBlank()) {
      throw new IllegalArgumentException(message);
    }

    return string;
  }

  public static <T> T[] requireNonEmpty(T[] list, String message) {
    if (list == null || list.length == 0) {
      throw new IllegalArgumentException(message);
    }

    return list;
  }


  public static <T> List<T> requireNonEmpty(List<T> list, String message) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException(message);
    }

    return list;
  }

  public static <K, V> Map<K, V> requireNonEmpty(Map<K, V> map, String message) {
    if (map == null || map.isEmpty()) {
      throw new IllegalArgumentException(message);
    }

    return map;
  }

  public static void keyNotNull(Map<String, Object> map, String key, String errorMessage) {
    Assert.notNull(map.get(key), errorMessage);
  }

  public static void valueNotBlank(Map<String, Object> map, String key, String errorMessage) {
    Assert.notBlank(String.valueOf(map.get(key)), errorMessage);
  }
}
