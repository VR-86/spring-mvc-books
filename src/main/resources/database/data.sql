INSERT INTO genre (id,change_date_time,create_date_time,genre) VALUES ('188475a5-d2f5-4cee-9155-2b0851ae1480','2023-03-09 16:30:43.259245','2023-03-09 16:30:43.259245','Учебная литература')
INSERT INTO genre (id,change_date_time,create_date_time,genre) VALUES ('4486a525-8997-429d-b73a-12069f99f133','2023-03-05 21:37:29.448022','2023-03-05 21:37:29.448022','Сказки')
INSERT INTO genre (id,change_date_time,create_date_time,genre) VALUES ('e65a9035-fa7c-4c2f-a1da-0f206850ef26','2023-03-03 00:51:25.690565','2023-03-02 23:41:38.632112','Фэнтэзи')
INSERT INTO genre (id,change_date_time,create_date_time,genre) VALUES ('e9fc89c8-f64f-4a64-bfc8-8136a4a52624','2023-03-09 16:26:18.915201','2023-03-09 16:26:18.915201','Техническая литература')

INSERT INTO author (id,name,create_date_time,change_date_time,book_id,patronymic,surname,fullname) VALUES ('40998f03-ec7c-4774-b237-8ff6fcc80a5e','Михаил','2023-03-05 21:34:53.783596','2023-03-09 01:09:17.973665',NULL,'Михайлович','Пришвин','Пришвин Михаил Михайлович')
INSERT INTO author (id,name,create_date_time,change_date_time,book_id,patronymic,surname,fullname) VALUES ('56a5b61e-d011-422b-971a-044f7182acbf','Роберт','2023-03-09 16:25:09.367057','2023-03-09 16:32:22.152656',NULL,'С.','Мартин','Мартин Роберт С.')
INSERT INTO author (id,name,create_date_time,change_date_time,book_id,patronymic,surname,fullname) VALUES ('912fc2b0-47e0-41e9-8778-23851175000a','Джон Рональд','2023-03-09 15:04:19.398043','2023-03-09 16:34:26.304618',NULL,'Руэл','Толкин','Толкин Джон Рональд Руэл')
INSERT INTO author (id,name,create_date_time,change_date_time,book_id,patronymic,surname,fullname) VALUES ('f0e242ae-1843-4cbe-b201-1730175ac0cc','Дарья','2023-03-09 16:30:03.034538','2023-03-09 16:32:18.069832',NULL,'Сергеевна','Герасимова','Герасимова Дарья Сергеевна')

INSERT INTO BOOK (id,change_date_time,create_date_time,isbn,language,sold,title,author_id,genre_id,author_fio) VALUES ('3f41da11-0b1e-46e1-9885-aa8f8028a6e6','2023-03-05 21:21:17.888406','2023-03-05 21:21:17.888406','978-5-04-177208-6','Русский',0,'Рассказы о животных','40998f03-ec7c-4774-b237-8ff6fcc80a5e','4486a525-8997-429d-b73a-12069f99f133',NULL)
INSERT INTO BOOK (id,change_date_time,create_date_time,isbn,language,sold,title,author_id,genre_id,author_fio) VALUES ('9d77aa5a-c50a-40bc-a815-3fdd9b2728e0','2023-03-09 16:27:24.924924','2023-03-09 16:27:24.924924','978-5-4461-0772-8','Русский',0,'Чистая архитектура','56a5b61e-d011-422b-971a-044f7182acbf','e9fc89c8-f64f-4a64-bfc8-8136a4a52624',NULL)
INSERT INTO BOOK (id,change_date_time,create_date_time,isbn,language,sold,title,author_id,genre_id,author_fio) VALUES ('ae269a33-5f0a-4ed3-88fa-ae34ad325e0c','2023-03-09 16:30:51.815267','2023-03-09 11:28:51.885832','978-5-699-20486-1','Русский',0,'Букварь. Учебное пособие','f0e242ae-1843-4cbe-b201-1730175ac0cc','188475a5-d2f5-4cee-9155-2b0851ae1480',NULL)
INSERT INTO BOOK (id,change_date_time,create_date_time,isbn,language,sold,title,author_id,genre_id,author_fio) VALUES ('c13d31f8-c7bd-40df-b484-542898edb584','2023-03-09 16:36:35.860255','2023-03-09 02:05:46.275015','978-5-17-145344-2','Русский',0,'Лисичкин хлеб ','40998f03-ec7c-4774-b237-8ff6fcc80a5e','4486a525-8997-429d-b73a-12069f99f133',NULL)
INSERT INTO BOOK (id,change_date_time,create_date_time,isbn,language,sold,title,author_id,genre_id,author_fio) VALUES ('c2d68736-81a0-4db7-9256-d556b2e8914c','2023-03-09 16:26:31.888486','2023-03-09 16:26:31.888486','978-5-4461-0960-9','Русский',0,'Чистый код','56a5b61e-d011-422b-971a-044f7182acbf','e9fc89c8-f64f-4a64-bfc8-8136a4a52624',NULL)
INSERT INTO BOOK (id,change_date_time,create_date_time,isbn,language,sold,title,author_id,genre_id,author_fio) VALUES ('d541a8f7-2fbb-48de-bf99-7d706e0b9923','2023-03-09 16:35:23.30741','2023-03-09 16:35:23.30741','978-5-17-116759-2','Русский',0,'Хоббит, или Туда и обратно','912fc2b0-47e0-41e9-8778-23851175000a','e65a9035-fa7c-4c2f-a1da-0f206850ef26',NULL)
