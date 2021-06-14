
Запуск только сервиса
```
mvn jetty:run
```

Сборка докер образа сервиса
```
docker build -t rom/mongodemo-service .
```

Запуск образа сервиса
```
docker run -p 8080:8080 rom/mongodemo-service 
```

Запуск образа монги
```
docker run -p 27017:27017 mongo
```


