insert into db_for_fun.roles (role) values ('USER'), ('ADMIN');

insert into db_for_fun.user_roles values (5,2);

insert into category_jokes (name) values ("Каламбуры"),("Абсурдные"),("Черный юмор"),("Программирование"),("Животные"),("Штирлиц"),("Родственники"),("Здоровье"),("Спорт"),("Дети"),("СССР"),("Национальности");

truncate table jokes;
insert into jokes(text,category_id) values ("Мужик собрался покончить жизнь самоубийством. Стоит на мосту, готовится прыгнуть в реку. Вдруг сзади кто-то хлопает его по плечу: «Извините, пожалуйста, а котят не захватите?",5),
("Жена посылает мужа-программиста в магазин: - Купи батон колбасы. Да, и спроси, есть ли яйца. Если есть - возьми десяток. Программист приходит в магазин: - Батон колбасы, пожалуйста. Ага, спасибо. А яйца у вас в продаже есть?- Есть.- Тогда, пожалуйста, ещё девять батонов колбасы.",4),
    ("То, что разработчики решают задачи каждый на своей ветке, пришло к нам от наших предков — обезьян.",4),
    ("Штирлиц стрелял вслепую. Слепая бегала зигзагами и кричала.",6),
    ("- Почему эстонцы, когда садятся в маршрутку, выбирают место спереди? - Чтобы быстрее доехать. - А почему евреи выбирают место сзади? - Чтобы ехать дольше за те же деньги.",12),
     ("Умер старый еврей. Вскрыли его завещание, читают: 'Дочке моей, Сарочке, оставляю 100 тысяч долларов и дом. Внучке моей,
 Ривочке, оставляю 200 тысяч долларов и дачу. Зятю моему, Шмулику, который просил упомянуть его в завещании, упоминаю: Привет тебе, Шмулик!..'",7),
 ('У графа пропала водка из буфета. Видит: его жена идет и шатается. - Водка в графине, - подумал граф.',1),
('Чемпион мира по карате уступил место бабушке. Теперь она чемпион мира по карате..',1),
('Во время секретного совещания в бункер Гитлера с шашкой наголо ворвался Штирлиц и закричал:
- Порублю, гады.
Гады скинулись по рублю. Штирлиц собрал деньги и ушел.',6),
('Попал Пол Уокер в аварию, приехали спасатели, стали доставать. Сначала достали Пол Уокера, а потом еще Пол Уокера.',1),
('Приходит мужик на железнодорожний вокзал, покупать билет: - Здравствуйте, а у Вас билет до Перьми есть? - Да. - А есть боковая полка у туалета? - Есть!? - А передо мной табор цыганский билеты покупал, с ними в вагон можно? - Можно, только там ещё и дембеля едут... - Во, самоe оно, давайте! Купил, домой приходит, жена с кухни выбегает и спрашивает: - Дорогой, ты билет моей маме купил? - Не поверишь, дорогая, последний урвал!',7), 
('Если дело футболистов доведут до суда, то это будет первый в истории случай, когда на суде будут судья, прокурор, защитник, полузащитник и нападающий.',9),
('Колдунья вуду, случайно проткнув спицами пакет с мусором, покалечила наряд милиции',1),
('Летит спецназ воевать в Афганистан. Мимо солдат проходится лейтенант и объясняет: -Вы когда ''духа'' завалите не забывайте его голову отрезать и мне принести. За каждую голову $10. Тут самолет приземляется и с оружием на изготовку солдаты выскакивают из него. Час их нет, два... Через три возвращаются, все веселые, а у каждого за спиной мешок отрезаных голов. Лейтенант смотрит на них квадратными глазами и говорит: Вы че, офигели? Мы же в Ташкенте на дозаправку сели!',3),
('У боснийца родилось два сына-близнеца. Он одного назвал Хусо. И другого назвал Хусо. Его спрашивают, зачем он дал им одинаковые имена. А он отвечает: А вот зачем: приду домой и крикну: Хусо, принеси папе пива! Оп-па, а у меня сразу два пива!',10),
('Однажды у мудреца спросили, смогут ли деньги сделать его счастливее. "Ладно, давай сюда зачетку", - ответил мудрец.',1),
('Мою школу называли Хогвартсом, потому что у нас тоже убили директора',3),
("Генерал в развалочку идет по мосту, смотрит вокруг ленивым взором и надо же было, ему на глаза попался солдат. Солдат как обычно в самоволке и хочет проскочить мимо, делая вид, что не замечает генерала. Генерал:'-Рядовой, это что такое? Почему честь не отдали?' Солдат: '- Соглавсно пункту 147 устава чесь на мосту не отдается!' Генерал растерялся и сразу домой. Пришел, полистал устав, нашел нужный пункт и читает: Пункт 147. Солдат должен быть находчив и смел.", 11),
("Почему не существует обзоров на наркотики? - Отсутствуют независимые эксперты.",1),
("- Ты кто такой? - Вор. - А почему такой маленький? - Карманный.",1),
("Мюллер вызывает Штирлица и говорит: - Завтра будет субботник, явка обязательна! Штирлиц отвечает: - Есть! Немного погодя Штирлиц понимает, что провалился и решает написать рапорт:'Я, штандартенфюрер фон Штирлиц, признаюсь, что являюсь советским шпионом...'.Когда рапорт дошел до Мюллера, он показывает его Шелленбергу и говорит:- Вальтер, глянь чего Штирлиц опять выдумал, лишь бы на субботник не приходить!",6);

 
 insert into memes (url) values 
('https://sun9-86.userapi.com/impg/Ih5ykaDY4OpCXyDvG30N9RPYH7xl5OwusM3Ipw/fK2RGAahsbg.jpg?size=794x1196&quality=96&sign=2ac7930c5e5804a40f2bf0d8af6d289c&type=album'),
('https://sun9-3.userapi.com/impg/TIemqf2F26-3MQtuXklqfJcw-CTeSH1cMFoDfA/-AJPClp_siA.jpg?size=584x734&quality=96&sign=dcdcc842ee6d5bef0973494b8da7da4d&type=album'),
('https://sun9-6.userapi.com/impg/Q_NkbTKS9QBjhqVJsBF8YgmCly89h8i6hMGWyw/DwVT8s9dIzc.jpg?size=732x773&quality=96&sign=f2fe805dd8e2bf6583ce7d676f41fd30&type=album'),
('https://sun9-34.userapi.com/impg/oTaqSUALpXhEKg_Qk8TE0Cl7IeCweVedCbugMA/k3HidOSsP58.jpg?size=768x576&quality=96&sign=4654983fe9e0e83441601689a3ee9593&type=album'),
('https://sun9-84.userapi.com/impg/EJfp2W1YtlisX3Vwl7pPrugEKbQBt6JNkljcwA/rcSnAY7kaF0.jpg?size=594x454&quality=96&sign=e84da58cbc43f3b397221e840cee6e8f&type=album'),
('https://sun9-14.userapi.com/impg/9cln9kTZff24WknrGgRMfOFF3Y4Px2JNUCXujw/5EDHdDv5IQI.jpg?size=1605x1356&quality=96&sign=8d64fa601b1ea27e60295bcddfba9740&type=album'),
('https://sun1.dataix-kz-akkol.userapi.com/impg/qoVo55AdOzNQhvR2HV8XGo2Z3d0CuxBl_3rVqQ/gVuR8T48w_k.jpg?size=716x1182&quality=96&sign=2f5dfca56c45361f3d4892c8fa0fb70b&type=album'),
('https://sun2.dataix-kz-akkol.userapi.com/impg/6iuGkIbYh1Zeu3tZWkCBAqRi5I4cmUZocXA__Q/O1m5Wn-MIpU.jpg?size=844x806&quality=95&sign=8ee4d25fe061f1cd40d53306e8dc9874&type=album'),
('https://sun2.dataix-kz-akkol.userapi.com/impg/o_kSlHhZBgGU0SeyqHX34uCA2IY8_nI_TfDcbw/83hOZ0a49w0.jpg?size=854x458&quality=95&sign=13c422a786d6c952157775dfef491ef4&type=album'),
('https://sun2.dataix-kz-akkol.userapi.com/impg/sIDBO7H2brqogaxuugC4corK4a-FSY_7641meQ/8pKwq5MJmZ4.jpg?size=991x765&quality=95&sign=ac1ebea45d64ac5ac12c7ab19a9c05b6&type=album'),
('https://sun2.dataix-kz-akkol.userapi.com/impg/Pi76-xYhlLNH-uBjCCLO_JI7YVZKygxExNBkKg/axCtGGvC-Rg.jpg?size=651x785&quality=96&sign=91db5dea1cf626b191d5d0afe315e960&type=album');
 
commit;
