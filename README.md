# Задача Conditional приложение

Код
по [ссылке](https://github.com/A-Sakhmina/netology_jclo_spring_boot_conditional/tree/master/src/main/java/ru/netology/sakhmina/springbootapplication)

### Описание

Приложение на Spring boot, в котором в зависимости от параметров(один булевский параметр) вызываются разные сервисы(
бины).

Тестирование разных образов, созданных с помощью Docker. Тестирование произведено с помощью `TestContainers`.

Первый образ devapp запускается на порту 8080(внесён в 'Dockerfile' и 'application.properties')
со значением `netology.profile.dev=true`.

Второй образ prodapp запускается на порту 8081 со значением `netology.profile.dev=false`.


