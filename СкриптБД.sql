CREATE DATABASE Депозиты
Use депозиты;

CREATE TABLE `Пользователь`(
`Логин` VARCHAR(20) NOT NULL,
`Пароль` VARCHAR(20) NOT NULL,
`Админ` VARCHAR(3) NOT NULL,
`Заблокирован` BOOLEAN,
PRIMARY KEY(`Логин`),
CONSTRAINT Статус_check CHECK (`Админ` IN ('Да', 'Нет'))
);

CREATE TABLE `Валюта`(
`Мнемокод` VARCHAR(3) NOT NULL,
`Наименование` VARCHAR(40) NOT NULL,
`Курс` NUMERIC(10, 4) NOT NULL,
PRIMARY KEY (Мнемокод),
CONSTRAINT Курс_check CHECK(`Курс` > 0)
);

CREATE TABLE `Депозит`(
`Код` INT NOT NULL AUTO_INCREMENT,
`Наименование` VARCHAR(30) NOT NULL,
`ВалютаВклада` VARCHAR(3) NOT NULL,
`ПроцентнаяСтавка` NUMERIC(5, 2) NOT NULL,
`МинимальнаяСумма` NUMERIC(10, 2) NOT NULL,
`ЧастичноеСнятие` VARCHAR(3) NOT NULL,
PRIMARY KEY(`Код`),
CONSTRAINT ЧастичноеСнятие_check CHECK (`ЧастичноеСнятие` IN ('Да', 'Нет')),
CONSTRAINT КодВалюты_FK FOREIGN KEY (`ВалютаВклада`) REFERENCES `Валюта`(`Мнемокод`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Клиент`(
`НомерПаспорта` VARCHAR(9) NOT NULL,
`Фамилия` VARCHAR(30) NOT NULL,
`Имя` VARCHAR(30) NOT NULL,
`Отчество` VARCHAR(30) NOT NULL,
`ДатаРождения` DATE NOT NULL,
`НомерТелефона` VARCHAR(13),
PRIMARY KEY (НомерПаспорта),
--CONSTRAINT НомерПаспорта_check CHECK(НомерПаспорта LIKE '[AZ]*2[0-9]*7'),
--CONSTRAINT НомерТелефона_check CHECK(НомерТелефона REGEXP '+375[0-9]*7'),
CONSTRAINT ДатаРождения_check CHECK (ДатаРождения <= '2002-12-31')
);

CREATE TABLE `Договор`(
`НомерДоговора` VARCHAR(10) NOT NULL,
`НомерПаспорта` VARCHAR(9) NOT NULL,
`КодВклада` INT NOT NULL,
`СрокДействия` NUMERIC(10, 2) NOT NULL,
`Единица` VARCHAR(10) NOT NULL,
`ГодЗаключения` INT NOT NULL,
`НачальнаяСумма` NUMERIC(10,2) NOT NULL,
PRIMARY KEY (`НомерДоговора`),
CONSTRAINT ГодЗаключения_check CHECK (`ГодЗаключения` >=1945 AND `ГодЗаключения` <=2021),
CONSTRAINT НомерПаспорта_FK FOREIGN KEY (`НомерПаспорта`) REFERENCES `Клиент`(`НомерПаспорта`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT Вклад_FK FOREIGN KEY (`КодВклада`) REFERENCES `Депозит`(`Код`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Статистика`(
`Код` INT AUTO_INCREMENT,
`Логин` VARCHAR(20) NOT NULL,
`Дата` DATE NOT NULL,
PRIMARY KEY(`Код`)
);

--ДОБАВЛЕНИЕ ЗАПИСЕЙ
INSERT INTO `Валюта` VALUES ('USD', 'Доллар США', 2.49);
INSERT INTO `Валюта` VALUES ('EUR', 'Евро', 2.81);
INSERT INTO `Валюта` VALUES ('RUB', 'Российский рубль', 0.034);
INSERT INTO `Валюта` VALUES ('JPY', 'Японская йена', 0.022);

INSERT INTO `Клиент` VALUES('BM2352448', 'Петров', 'Петр', 'Петрович', '1991-03-12', '+375333617793');
INSERT INTO `Клиент` VALUES('BM2772598', 'Сидоров', 'Сергей', 'Алексеевич', '1989-08-10', '+375333613583');

INSERT INTO `Депозит`(`Наименование`, `ВалютаВклада`, `ПроцентнаяСтавка`, `МинимальнаяСумма`, `ЧастичноеСнятие`) VALUES ('Традиционный', 'RUB', 7.3, 300, 'Нет');
INSERT INTO `Депозит`(`Наименование`, `ВалютаВклада`, `ПроцентнаяСтавка`, `МинимальнаяСумма`, `ЧастичноеСнятие`) VALUES ('Традиционный', 'BYN', 7.3, 300, 'Нет');
INSERT INTO `Депозит`(`Наименование`, `ВалютаВклада`, `ПроцентнаяСтавка`, `МинимальнаяСумма`, `ЧастичноеСнятие`) VALUES ('Традиционный', 'USD', 7.3, 300, 'Нет');
INSERT INTO `Депозит`(`Наименование`, `ВалютаВклада`, `ПроцентнаяСтавка`, `МинимальнаяСумма`, `ЧастичноеСнятие`) VALUES ('Традиционный', 'EUR', 7.3, 300, 'Нет');

INSERT INTO `Договор` VALUES ('2151001644', 'BM2352448', 2, 3, 'г.');
INSERT INTO `Договор` VALUES ('2151021647', 'BM2772598', 4, 3, 'мес.');
INSERT INTO `Договор` VALUES ('2151301647', 'BM2352448', 1, 5, 'г.');
INSERT INTO `Договор` VALUES ('3157001647', 'BM2772598', 3, 2.4, 'г.');