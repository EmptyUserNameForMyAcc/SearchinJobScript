package constants;


public class Constants {
    public static class TimeOutsVariables {
        public static byte countMatch;
        public static final byte IMPLICITLY_WAIT5S = 5;
        public static final byte EXPLICITLY_WAIT_TIME25S = 25;
        public static final short LOADING_PAGE_WAIT30m = 1800;
        public static final short LONG_EXPLICITLY_WAIT5M = 300;
        public static final short MEDIUM_WAITING_TIME5S = 5;
        public static final double RANDOM_WAIT_TO4S = Math.random() * 4000;
    }


    public static class TextVariables {
        public static String requirementDescription;
        public static final String[] gradesOfChoice = new String[19];

        static {
            gradesOfChoice[0] = "java";
            gradesOfChoice[1] = "junit";
            gradesOfChoice[2] = "docker";
            gradesOfChoice[3] = "maven";
            gradesOfChoice[4] = "xpath";
            gradesOfChoice[5] = "selenium";
            gradesOfChoice[6] = "selenoid";
            gradesOfChoice[7] = "selenide";
            gradesOfChoice[8] = "git";
            gradesOfChoice[9] = "github";
            gradesOfChoice[10] = "gitlab";
            gradesOfChoice[11] = "bitbucket";
            gradesOfChoice[12] = "agile";
            gradesOfChoice[13] = "scrum";
            gradesOfChoice[14] = "intellijIDEA";
            gradesOfChoice[15] = "intellij idea";
            gradesOfChoice[16] = "sql";
            gradesOfChoice[17] = "mysql";
            gradesOfChoice[18] = "jira";

        }

        public static final String[] IS_AUTOMATION_REQUIREMENT = new String[14];

        static {
            IS_AUTOMATION_REQUIREMENT[0] = "автоматизации";
            IS_AUTOMATION_REQUIREMENT[1] = "автоматизация";
            IS_AUTOMATION_REQUIREMENT[2] = "автоматизированного";
            IS_AUTOMATION_REQUIREMENT[3] = "автоматизирование";
            IS_AUTOMATION_REQUIREMENT[4] = "автоматизированное";
            IS_AUTOMATION_REQUIREMENT[5] = "automation";
            IS_AUTOMATION_REQUIREMENT[6] = "автотестов";
            IS_AUTOMATION_REQUIREMENT[7] = "автотестами";
            IS_AUTOMATION_REQUIREMENT[8] = "авто-тестами";
            IS_AUTOMATION_REQUIREMENT[9] = "авто- тестами";
            IS_AUTOMATION_REQUIREMENT[10] = "авто - тестами";
            IS_AUTOMATION_REQUIREMENT[11] = "авто- тесты";
            IS_AUTOMATION_REQUIREMENT[12] = "авто-тесты";
            IS_AUTOMATION_REQUIREMENT[13] = "автоматизированных";
        }

        public static String nextPage;
        public static String newHhPageHandle;
        public static final String COVERING_TEXT = "Здравствуйте, вы были найдены с помощью скрипта написанного на" +
                " языке программирования Java.\n" +
                "\nПри создании скрипта были использованы инструменты:" +
                "\n1. Java_19 в среде разработки IntellijIDEA." +
                "\n2. JUnit 5- jupiter v5.9.2." +
                "\n3. Selenium v4.8.1." +
                "\n4. WebDriverManager v5.3.2." +
                "\n5. Apache.Maven v4." +
                "\n6. xPath." +
                "\nА также паттерны:" +
                "\nPageObject и PageFactory.\n" +
                "\nСсылка на проект в GitHub: https://github.com/EmptyUserNameForMyAcc/SearchinJobScript" + "\n" +
                "\nБолее подробную информацию вы можете посмотреть в разделе \"О себе\" внутри моего профиля.\n" +
                "\nСпасибо и хорошего времени суток!";
    }


    public static class BoolVariables {
        public static boolean IS_AUTOMATION = false;
    }
}
