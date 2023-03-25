package constants;

public class Constants {
    public static class TimeOutsVariables {
        public static final byte IMPLICITLY_WAIT5S = 5;
        public static final byte LOADING_PAGE_WAIT30S = 30;
        public static final byte EXPLICITLY_WAIT_TIME10S = 10;
        public static final short LONG_EXPLICITLY_WAIT5M = 300;
        public static final short MEDIUM_WAITING_TIME5S = 5;
        public static final double RANDOM_WAIT_TO4S = Math.random() * 4000;

        public static final String CONVERTING_TEXT = "Здравствуйте, вы были найдены с помощью скрипта " +
                "написанного на Java. " +
                "При создании скрипта были использованы инструменты:\n" +
                "1. Java_19 в среде разработке IntellijIDEA.\n" +
                "2. JUnit 5- jupiter v5.9.2.\n" +
                "3. Selenium v4.8.1.\n" +
                "4. WebDriverManager v5.3.2.\n" +
                "5. Apache.Maven v4.\n" +
                "Ссылка на проект в GitHub: https://github.com/EmptyUserNameForMyAcc/SearchinJobScript\n" +
                "Более подробную информацию можете посмотреть в разделе \"О себе\" внутри моего профиля.\n" +
                "Спасибо и хорошего времени суток! ";
    }
}
