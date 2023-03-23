package constants;

public class Constants {
    public static class TimeOutsVariables {
        public static final byte IMPLICITLY_WAIT10S = 10;
        public static final byte LOADING_PAGE_WAIT30S = 30;
        public static final byte EXPLICITLY_WAIT_TIME10S = 10;
        public static final short LONG_EXPLICITLY_WAIT5M = 300;
        public static final short MEDIUM_WAITING_TIME5S = 5;
        public static final double RANDOM_WAIT_TO4S = Math.random() * 4000;
    }
}
