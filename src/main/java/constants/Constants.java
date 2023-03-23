package constants;

public class Constants {
    public static class TimeOutsVariables {
        public static final byte IMPLICITLY_WAIT = 10;
        public static final byte LOADING_PAGE_WAIT = 30;
        public static final byte EXPLICITLY_WAIT = 10;
        public static final short LONG_EXPLICITLY_WAIT = 300;
        public static final double RANDOM_WAIT = Math.random() * 4000;
    }
}
