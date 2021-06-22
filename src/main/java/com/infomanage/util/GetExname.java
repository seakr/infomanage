package com.infomanage.util;

public class GetExname {
  public static String GetExname(String filename) {
    if ((filename != null) && (filename.length() > 0)) {

      int dot = filename.lastIndexOf('.');

      if ((dot > -1) && (dot < (filename.length() - 1))) {

        return filename.substring(dot + 1);
      }
    }

    return filename;
  }
}
