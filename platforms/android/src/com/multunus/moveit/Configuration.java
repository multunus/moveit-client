package com.multunus.moveit;

/**
 * Created by popeye on 27/4/15.
 */
public class Configuration {
    public final static String NOTIFICATION_URL = "http://mov3it.herokuapp.com/api/user/notifications/message";
    public static class MorningNotification{
        public static final int HOUR = 7;
        public static final int MINUTE = 00;
        public static final int SECOND = 00;
    }
    public static class EveningNotification{
        public static final int HOUR = 18;
        public static final int MINUTE = 00;
        public static final int SECOND = 00;
    }
}
