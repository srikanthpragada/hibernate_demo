create table subjects
( subcode varchar2(10) primary key,
  subname varchar2(50)
);

insert into subjects values('java','Java Langauge');
insert into subjects values('c#','C# Language');
insert into subjects values('hib','Hibernate');
insert into subjects values('aspnet','Asp.Net');

create table titles
(  titleid  int  primary key,
   title    varchar2(50),
   subcode  varchar2(10) references subjects(subcode),
   price    number(5)
);


insert into titles values (1,'Java Complete Reference','java',450);
insert into titles values (2,'Thinking in Java','java',550);
insert into titles values (3,'C# Complete Reference','c#',499);
insert into titles values (4,'Hibernate In Action','hib',450);
insert into titles values (5,'Beginning Hibernate','hib',299);
insert into titles values (6,'Asp.Net Unleashed','aspnet',500);
insert into titles values (7,'Pro ASP.NET 3.5 with C#','aspnet',650);
insert into titles values (8,'C# Programming','c#',400);
insert into titles values (9,'Illustrated C# 2008','c#',300);
insert into titles values (10,'Java 6 Platform Revealed','java',350);

create table Etitles
(  titleid  int  primary key,
   weburl   varchar2(50)
);

insert into ETitles  values(9,'http://www.apress.com/book/view/9781590599549');
insert into ETitles  values(10,'http://www.apress.com/book/view/9781590596609');


create table courses
( courseid  number(5) primary key,
  name   varchar(30)
);

create table coursesubjects
( courseid  number(5) references course,
  subject   varchar(30)
);

insert into courses values(1,'Java EE');
insert into courses values(2,'ASP.NET');
insert into courses values(3,'Oracle Developer');

insert into coursesubjects values(1,'Servlets');
insert into coursesubjects values(1,'JSP');
insert into coursesubjects values(1,'JSF');

insert into coursesubjects values(2,'Web Contols');
insert into coursesubjects values(2,'ADO.NET');
insert into coursesubjects values(2,'LINQ');

insert into coursesubjects values(3,'SQL');
insert into coursesubjects values(3,'PL/SQL');










