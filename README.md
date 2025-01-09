## Шаг 1: Создание Docker-образа

### 1. Добавьте файл Dockerfile в корневую директорию проекта.
   
#### Пример Dockerfile:
* FROM apache/beam_java17_sdk
* ARG JAR_FILE=target/*.jar
* COPY ${JAR_FILE} app.jar
* ENTRYPOINT ["java","-jar","/app.jar"]

### 2. Соберите образ командой:
* docker build -t spring-demo .

### 3. Запустите контейнер локально, чтобы проверить работу приложения внутри контейнера:
* docker run -p 8080:8080 spring-demo

Здесь:
- -p 8080:8080 — карта порта хост-машины к порту внутри контейнера.
- spring-demo — имя образа, которое было задано при сборке.

Теперь приложение должно быть доступно по адресу http://localhost:8080

## Шаг 2: Загрузка образа в реестр(hub.docker.com)

#### Замените имя образа на полное имя с указанием реестра:
* docker tag spring-demo:latest ilyarum/spring-demo:latest

где ilyarum — это имя хранилища образов в реестре

#### Загрузите образ в реестр:
* docker push ilyarum/spring-demo:latest

## Шаг 3: Развёртывание в Kubernetes

### 1. Убедитесь, что Kubernetes запущен:
* kubectl get nodes

### 2. Создание манифестов Kubernetes
- Создайте Deployment для приложения. Это позволит вам управлять количеством реплик и обновлениями приложения.
- Создайте Service для обеспечения доступа к приложению извне кластера.

### 3. Применение манифестов
- kubectl apply -f kubernetes/deployment.yaml
- kubectl apply -f kubernetes/service.yaml

### 4. Проверьте состояние ресурсов:
- kubectl get deployments
- kubectl get services



