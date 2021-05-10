package javaprojects.test_task_2;

import java.io.IOException;

public class Main {

    /**
     * 2. Имеется реляционная база данных (oracle, sql server, mysql,
     * postgresql, sqlite и т.д. - любая). Завести в БД таблицу данных о
     * студентах, которая будет содержать: имя, фамилия, отчество, дата
     * рождения, группа, уникальный номер.
     * Реализовать консольный или графический пользовательский интерфейс, с
     * помощью которого можно: добавить студента, удалить студента по
     * уникальному номеру, вывести список студентов.
     */

    public static void main(String[] args) throws IOException {
        JavaToMySQL.start();
    }
}
