# SearchinJobScript
This script find me job. 
/*
* Данный скрипт реализован для следующих целей: Поиск работы по заданным критериям поиска на сайте https://hh.ru.
* Осуществляет дейтсивия:
*
* 1. Открывает браузер и сайт: https://hh.ru/
*
* 2. Осуществляет поиск вакансий по заданным параметрам:
*
* 2.1 Условия ввода в строку поиска вакансий:
Условия: QA Automation Engineer || Тестировщик || Тест || Автотестировщик || Автоматическому тестированию
* Автоматизации тестирования || AQA || QA инженер || QA engineer || QA Engineer Automation || Qa Java ||
*
* 2.2 Опыт работы:
* Локатор: //p[@class = 'vacancy-description-list-item'] +
* Условия: Не требуется || От 1-го до 3-х лет.
*
* 2.3 Требования:
* Локатор: //div[@data-qa = 'vacancy-description'] +
* Условия: Java && ( Automation || tests || development || Maven || TestNG || Junit || Docker || тестирования || тестирование
* || автоматизация || автоматизации || автоматизированного || xPath || Selenium || Selenoid || Selenide || тесты || тест
* || Git || GitLab || GitHub || покрытие || автотесты || автотестами || Agile || Scrum || IntellijIDEA || Intellij)
*
* 5. Ключевые навыки:
* Локатор: //div[@class = 'bloko-tag-list']/div/span +
* Условия: Java || Docker || Git || xPAth || Ui || API
*
* 3. Кнопка отправки резюме.
* Локатор: //a[@data-qa = 'vacancy-response-link-top'] +
*
* 4. Кнопка скрыть вакансию.
* Локатор: //button[@data-qa = 'vacancy__blacklist-show-add'] +
*
* 5. Строка ввода для поиска вакансй.
* Локатор: id="a11y-search-input" +
*
* 6. Кнопка поска вакансий на главной странице.
* Локатор: //button[@data-qa = 'search-button'] +
*
* 7. Кнопка подтверждения отклика из другой страны.
* Локатор: //button[@data-qa = 'relocation-warning-confirm'] +
*
* 8. Переход на написание сопроводительного письма.
* Локатор: //button[@data-qa = 'vacancy-response-letter-toggle'] +
*
* 9. Поле ввода сопроводительного письма.
* Локатор: //form[contains(@action, 'vacancy_response/edit_ajax')]/input +
*
* 10. Кнопка отправки сопроводительного письма.
* Локатор: //button[@data-qa = 'vacancy-response-letter-submit'] - FIX IT (Fixed) +
*
* 11. Кнопка после отклика.
* Локатор: //a[@data-qa = 'vacancy-response-link-view-topic']/span здесь gettext +
*
* 12. Кнопка для ввода данных авторизации:
* Локатор: //a[@data-qa = 'login'] +
*
* 13. Поле для ввода логина:
* Локатор: //input[@name = 'login'] +
*
* 14. Поле для ввода пароля:
* Локатор: //input[@type = 'number'] +
*
* 15. Кнопка подтверждения логина:
* Локатор: //form/descendant::button[@data-qa = 'account-signup-submit'] (усложнён для наглядности понимания работы
 * с xPath)
*
* Модификаторы доступа расставлены для наглядности понимания необходимости в доступе к полям с дальнейшей возможностью
* расширения тестов.
*/



https://hh.ru/vacancy/75831711?from=vacancy_search_list&query=Qa%20automation%20engineer
