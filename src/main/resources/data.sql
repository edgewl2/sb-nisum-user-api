insert into ROLE (created, created_by, modified, modified_by, description, name)
values ('2022-01-30T01:48:03.123456789', 'edgewl2', '2022-01-30T01:48:03.123456789', 'edgewl2', 'Admin user role', 'ROLE_ADMIN'),
       ('2022-01-30T01:48:03.123456789', 'edgewl2', '2022-01-30T01:48:03.123456789', 'edgewl2', 'Normal user role', 'ROLE_NORMAL'),
       ('2022-01-30T01:48:03.123456789', 'edgewl2', '2022-01-30T01:48:03.123456789', 'edgewl2', 'Anonymous user role','ROLE_ANONYMOUS');

insert into USER (id, created, created_by, modified, modified_by, email, is_active, last_login, name, password, token)
values ('d0049d0907f54b78898844aaa9769746', '2022-01-31T01:04:40.125458781', 'edgewl2', '2022-01-31T01:04:40.125458781', 'edgewl2', 'edgewl2@gmail.com', true, '2022-01-31T01:04:40.125458781', 'Edvin Gerardo Aguirre', '$2b$10$Ik.iDeWTlFP6MQu04xXXNupAUd3zN/wBie9csPbQ21.x9B4fKjy4C', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlZGdld2wyQGdtYWlsLmNvbSIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2NDM3ODE3MDgsImV4cCI6MTY0NjM3MzcwOH0.1SSaGFtHtBBEciQFOf3nkwaZl-fQaq3J8o-WR17ZP80');

insert into PHONE (created, created_by, modified, modified_by, city_code, country_code, number, user_id)
values ('2022-01-31T01:04:40.125458781', 'edgewl2', '2022-01-31T01:04:40.125458781', 'edgewl2', '3200', '505', '89785645', 'd0049d0907f54b78898844aaa9769746'),
       ('2022-01-31T01:04:40.125458781', 'edgewl2', '2022-01-31T01:04:40.125458781', 'edgewl2', '3200', '505', '86485315', 'd0049d0907f54b78898844aaa9769746');

insert into USER_HAS_ROLE (user_id, role_id)
values ('d0049d0907f54b78898844aaa9769746', 1);
