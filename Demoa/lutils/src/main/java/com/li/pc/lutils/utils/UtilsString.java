package com.li.pc.lutils.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * author   ：mo
 * data     ：2017/1/3
 * time     ：11:29
 * function :
 */

public class UtilsString {
    protected static final String TAG = UtilsString.class.getSimpleName();
    public UtilsString() {
        throw new AssertionError();
    }
    /**
     * 增加空白
     */
    public static String addBlank(int size) {
        return String.format("%" + size + "s", "");
    }

    /**
     * 判断字符串是否为null或者""
     */
    public static boolean isEmptyOrNull(String content) {
        if (content == null || content.equals("")) {
            return true;
        }
        return false;
    }
    /**
     * 判断字符串是否为IP地址
     * @param ipString
     * @return
     */
    public static boolean isIPAddress(String ipString) {
        if (ipString != null) {
            String[] singleArray = ipString.split("\\.");
            if (singleArray == null) {
                return false;
            }
            try {
                for (String numString : singleArray) {
                    if (isEmptyOrNull(numString.trim())) {
                        return false;
                    }
                    int num = Integer.parseInt(numString.trim());
                    if (num < 0 || num > 255) {
                        return false;
                    }
                }
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 是否为数字
     * @param digitString
     * @return
     */
    public static boolean isDigit(String digitString) {
        if (!isEmptyOrNull(digitString)) {
            String regex = "[0-9]*";
            return isMatch(regex, digitString);
        }
        return false;
    }
    /**
     * 字符串正则校验
     * @param regex
     * @param string
     * @return
     */
    public static boolean isMatch(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    /**
     * 是否为URL地址
     * @param strIp
     * @return
     */
    public static boolean isUrl(String strIp) {
        String strPattern = "^((https?)|(ftp))://(?:(\\s+?)(?::(\\s+?))?@)?([a-zA-Z0-9\\-.]+)"
                + "(?::(\\d+))?((?:/[a-zA-Z0-9\\-._?,'+\\&%$=~*!():@\\\\]*)+)?$";
        return isMatch(strPattern, strIp);
    }

    /**
     * String 转换成Unicode
     * @param string 传入汉字
     * @return
     */
    public static String string2Unicode(String string) {
        if (!isEmptyOrNull(string)) {
            char[] charArray = string.toCharArray();
            StringBuffer buffer = new StringBuffer();
            for (char ch : charArray) {
                int code = (int) ch;
                buffer.append(code);
            }
            return buffer.toString();
        }
        return null;
    }
    /**
     * Unicode转换成String
     * @param string
     * @return
     */
    public static String unicode2String(String string) {
        if (!isEmptyOrNull(string)) {
            int end = 0;
            String noSpace = string.trim();
            int count = noSpace.length() / 5;
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < count; j++) {
                end += 5;
                int uCode = Integer.valueOf(noSpace.substring(j * 5, end));
                buffer.append((char) uCode);
            }
            return buffer.toString();
        }
        return null;
    }

    /**
     * 半角转换为全角
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }
    /**
     * 过滤字符
     * @param str
     * @return 返回符合要求的字符
     * @throws PatternSyntaxException
     */
    public static String stringFilters(String str) throws PatternSyntaxException {
        //除指定字符外全部过滤
        String regEx = "[^0-9a-zA-Z\u4e00-\u9fa5`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？[-]•－／｜＼／～＠《》〈〉〔〕［］<>-_ˇ｛｝ˉ¨＝＜％＄＃＋︿＿＆＊＂｀．〃‖々「」『』〖〗∶＇＂＊ ＆]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

    /**
     * 去除特殊字符或将所有中文标号替换为英文标号
     * @param str
     * @return
     */
    public static String stringFilter(String str) {
        str = str.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!").replaceAll("：", ":");// 替换中文标号
        String regEx = "[『』]"; // 清除掉特殊字符
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
    /**
     * 根据Unicode编码完美的判断中文汉字和符号
     * @param c
     * @return
     */

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    /**
     * 完整的判断中文汉字和符号
     * @param strName
     * @return
     */
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 得到一个字符串的长度,
     * @param s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static int getStringLength(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    /**
     * 是否是字母
     * @param c
     * @return
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }
    /**
     * 获取前四位
     * @param s
     * @return
     */
    public static String get4String(String s) {
        if (s == null)
            return "";
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            String temp = combineChars(c, 0, i);
            if (getStringLength(temp) <= 8) {
                return temp;
            }
        }
        return s;
    }

    /**
     * 组合任意位置起始的字符串
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static String combineChars(char[] a, int start, int end) {
        if (start > end) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = start; i <= end; i++) {
            buffer.append(a[i]);
        }
        return buffer.toString();
    }
    /**
     * 文本是否不包含特殊字符
     * @param name
     * @return
     */
    public static boolean isName(String name) {
        Pattern p = Pattern.compile("^[\u4e00-\u9fa5_a-zA-Z0-9]+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
}
