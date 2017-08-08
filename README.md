# Selenium Framework #
----------------------

Тестовый фреймворк, основанный на WebDriver

## 1. Технологии

1. [Selenium WebDriver](http://docs.seleniumhq.org/)
2. [TestNG](http://testng.org/doc/index.html)
3. [Maven](http://maven.apache.org/guides/)
4. [Java](http://www.oracle.com/technetwork/java/index.html)
5. [Log4j2](https://logging.apache.org/log4j/2.x/index.html)

## 2. Структура

Проект имеет стандартную стуктуру maven проекта. 

* src
	* main
		* java
		* resources
	* test
		* java
		* resources
* suites

### 2.1 src/main/java/

Хранит вспомогательные классы для тестов:

* cases - хранит бизнес логику. Описаны основные действия пользователя при использовании системы ("войти в систему", "отправить письмо" и т.д)
* pages - хранит описание страниц. Описаны используемые на странице панели и действия со страницей со стороны браузера ("загрузить страницу", "очистить кеш", "очистить cockie" и т.д)
* panels - хранит описание панелей. Описаны основные блоки страницы (header, footer), их элементы(кнопки, ссылки) и возможные действия (клик по кнопке)
* test_objects - хранит описание тестовых сущностей(пользователь, письмо). Описаны основные свойства сущности, которые используются в тесте
* utils - хранит вспомогательные классы для работы с WebDriver, параметрами и конфигурацией тестов

### 2.2 src/main/resources/

* log_config - хранит конфигурации для логирования

### 2.3 src/test/java/

Хранит тесты и dataproviders.

* providers - хранит dataproviders для тестов
* tests - хранит тесты

### 2.4 src/test/resources/

Хранит конфигурацию и тестовые данные.

* test_сonfig - хранит файлы конфигурации тестов (url).
* data - хранит файлы с тестовыми данными (пользователи, варианты писем).

### 2.5 suites

Хранит описанные test suites для запуска через TestNG.

### 2.6 drivers

Xранит драйвера для запуска браузеров (chromedriver, iedriver)

## 3. Конфигурация
### 3.1 pom.xml

В плагине *\<surfire\>*, в блоке *\<systemPropertyVariables\>* описаны динамические параметры, которыми есть возможность управлять через консольный запуск (браузер, категории с тестовыми данными и т.д).

### 3.2 test_config/someConfig.properties

Описаны основные постоянные параметры, используемые в тестах (url, сервера и т.д).

## 4. Запуск тестов

Запуск тестов реализован через xml файлы. 

Из проекта:

>mvn clean integration-test

Для использования файла из другой категории, используем параметры * -DxmlPath* и *-DxmlFile*:

>mvn clean integration-test -DxmlPath="path/to/dir/with/xml" -DxmlFile=fileName.xml

Файлы ожидаются в категории *suite*. По-умолчанию запускается *allTest.xml'. 

Для выбора браузера передаем параметр *-Dbrowser*:

>mvn clean integration-test -Dbrowser=firefox

По-умолчанию запускается *Chrome*. Доступные значения: *"chrome"*, *"firefox"*, *"ie"*, *"html"*. Для расширения списка правим *DriverManager.initDriver()*.

Есть возможность управлять возможность раскрывать окно браузера на весь экран или нет:

>mvn clean integration-test -DisMaximizeWindow=false

По-умолчания установлено *true*.

## 5. Драйвера для запуска браузеров

Ожидается наличие драйверов в *drivers*. Можно при запуске передать ключ, указав путь к драйверу. Например
 
>mvn clean integration-test -Dwebdriver.chrome.driver="path/to/driver.exe"

## 6. Логирование

По-умолчанию используем *log4j2.xml* файл конфиграции в директории *log_config*. Для использования другого файла, передаем параметр *-Dlog4j.configurationFile*:

>mvn clean integration-test -Dlog4j.configurationFile="log_config/otherFile.xml"
