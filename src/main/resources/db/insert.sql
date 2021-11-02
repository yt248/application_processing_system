insert into users(active, username, name, password, role, surname)
VALUES (true, 'c', 'client Name', 1, 'ROLE_CLIENT', 'client surname'),
       (true, 'a', 'admin Name', 1, 'ROLE_ADMIN', 'admin surname');

insert into applications (bid, due_date, request, status, creator_application_id)
VALUES (1200.2, '2022-09-20', 'Починить шкаф', 0, 1),
       (800, '2021-09-20', 'Написать курсовую', 1, 1),
       (350.4, '2021-10-20', 'Найти машину', 3, 1);