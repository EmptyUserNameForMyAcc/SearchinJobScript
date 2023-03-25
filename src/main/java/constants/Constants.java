package constants;

import static constants.Constants.TextVariables.requirementDescription;

import static constants.Constants.TimeOutsVariables.countMatch;

public class Constants {
    public static class TimeOutsVariables {
        public static byte countMatch;
        public static final byte IMPLICITLY_WAIT5S = 5;
        public static final byte EXPLICITLY_WAIT_TIME10S = 10;
        public static final short LOADING_PAGE_WAIT30m = 1800;
        public static final short LONG_EXPLICITLY_WAIT5M = 300;
        public static final short MEDIUM_WAITING_TIME5S = 5;
        public static final double RANDOM_WAIT_TO4S = Math.random() * 4000;


    }

    public static class TextVariables {
        public static String requirementDescription;
        public static final String[] gradesChoice = new String[18];

        static {
            gradesChoice[0] = "java";
            gradesChoice[1] = "junit";
            gradesChoice[2] = "docker";
            gradesChoice[3] = "maven";
            gradesChoice[4] = "xpath";
            gradesChoice[5] = "selenium";
            gradesChoice[6] = "selenoid";
            gradesChoice[7] = "selenide";
            gradesChoice[8] = "git";
            gradesChoice[9] = "github";
            gradesChoice[10] = "gitlab";
            gradesChoice[11] = "bitbucket";
            gradesChoice[12] = "agile";
            gradesChoice[13] = "scrum";
            gradesChoice[14] = "intellijIDEA";
            gradesChoice[15] = "intellij idea";
            gradesChoice[16] = "sql";
            gradesChoice[17] = "mysql";
        }

        public static final String COVERING_TEXT = """
                    Здравствуйте, вы были найдены с помощью скрипта написанного на языке программирования Java.
                                
                    При создании скрипта были использованы инструменты:
                1. Java_19 в среде разработки IntellijIDEA.
                2. JUnit 5- jupiter v5.9.2.
                3. Selenium v4.8.1.
                4. WebDriverManager v5.3.2.
                5. Apache.Maven v4.
                6. xPath.
                                
                    А также паттерны:
                PageObject и PageFactory.
                                
                Ссылка на проект в GitHub: https://github.com/EmptyUserNameForMyAcc/SearchinJobScript
                                
                Более подробную информацию вы можете посмотреть в разделе "О себе" внутри моего профиля.
                Спасибо и хорошего времени суток! \uD83D\uDE0A""";
    }

    public static class BoolVariables {
        public static final boolean IS_AUTOMATION = requirementDescription.contains("автоматизации")
                || requirementDescription.contains("автоматизация")
                || requirementDescription.contains("автоматизированного")
                || requirementDescription.contains("автоматизирование")
                || requirementDescription.contains("автоматизированное")
                || requirementDescription.contains("automation");
        public static final boolean IS_CONTAIN_JAVA_AUTOMATION_AND_MATCH_MORE_5 =
                countMatch > 5 && requirementDescription.contains("java") && IS_AUTOMATION;
    }
}
